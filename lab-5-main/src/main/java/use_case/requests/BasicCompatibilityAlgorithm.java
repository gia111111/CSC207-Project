package use_case.requests;

import entity.Profile;
import use_case.find.CompatibilityAlgorithm;

import java.util.Map;

public class BasicCompatibilityAlgorithm implements CompatibilityAlgorithm {

    public enum QuestionType {
        HIGHEST_VALUE, // Type 1: A as the highest value, others lower
        FREQUENCY_BASED, // Type 2: Higher frequency closer to the user's choice
        OPEN_SIMILARITY // Type 3: Open question with graded similarity
    }

    Map<Integer, QuestionType> questionTypes = Map.of(
            1, QuestionType.HIGHEST_VALUE, // Section 1, Question 1
            2, QuestionType.FREQUENCY_BASED, // Section 1, Question 2
            3, QuestionType.OPEN_SIMILARITY// Section 1, Question 3
            // Add for all sections/questions...
    );

    private int scoreHighestValue(String userChoice, String profileChoice) {
        int userValue = 5; // Always assign 5 to user's selected choice
        int defaultValue = 2; // Default value for others
        return userChoice.equals(profileChoice) ? userValue : defaultValue;
    }

    private int scoreFrequencyBased(String userChoice, String profileChoice) {
        Map<String, Integer> values = Map.of(
                "A", 1, "B", 2, "C", 3, "D", 4, "E", 5
        );
        int userValue = values.get(userChoice);
        int profileValue = values.get(profileChoice);

        // Calculate difference and assign scores
        return 5 - Math.abs(userValue - profileValue);
    }

    private int scoreOpenSimilarity(String userChoice, String profileChoice) {
        // Define a similarity matrix or a mapping of choices
        Map<String, Map<String, Integer>> similarityMatrix = Map.of(
                "A", Map.of("A", 5, "B", 4, "C", 3, "D", 2, "E", 1),
                "B", Map.of("A", 4, "B", 5, "C", 4, "D", 3, "E", 2),
                "C", Map.of("A", 3, "B", 4, "C", 5, "D", 4, "E", 3)
                // Add mappings for "D" and "E"...
        );

        return similarityMatrix.get(userChoice).getOrDefault(profileChoice, 1); // Default to 1 if no match
    }

    @Override
    public double calculateScore(Profile currentUser, Profile otherUser) {
        double totalScore = 0.0;
        int totalQuestions = 25; // 5 sections * 5 questions per section

        for (int section = 1; section <= 5; section++) {
            for (int question = 1; question <= 5; question++) {
                String userChoice = currentUser.getAnswer().toString();
                String profileChoice = otherUser.getAnswer().toString();

                QuestionType questionType = questionTypes.get((section - 1) * 5 + question);

                int questionScore;
                switch (questionType) {
                    case HIGHEST_VALUE:
                        questionScore = scoreHighestValue(userChoice, profileChoice);
                        break;
                    case FREQUENCY_BASED:
                        questionScore = scoreFrequencyBased(userChoice, profileChoice);
                        break;
                    case OPEN_SIMILARITY:
                        questionScore = scoreOpenSimilarity(userChoice, profileChoice);
                        break;
                    default:
                        questionScore = 0; // Default if no type is matched
                }

                totalScore += questionScore;
            }
        }

        // Normalize the total score to a range between 0.0 and 1.0
        return totalScore / (totalQuestions * 5.0); // Max score per question is 5
    }

    public double calculateWeightedScore(Profile currentUserProfile, Profile otherProfile, Map<Integer, Double> sectionWeights) {
        double totalScore = 0.0;

        for (int section = 1; section <= 5; section++) {
            double sectionWeight = sectionWeights.getOrDefault(section, 1.0); // Default weight is 1.0

            for (int question = 1; question <= 5; question++) {
                String userChoice = currentUserProfile.getAnswer().toString();
                String profileChoice = otherProfile.getAnswer().toString();

                QuestionType questionType = questionTypes.get((section - 1) * 5 + question);

                int questionScore;
                switch (questionType) {
                    case HIGHEST_VALUE:
                        questionScore = scoreHighestValue(userChoice, profileChoice);
                        break;
                    case FREQUENCY_BASED:
                        questionScore = scoreFrequencyBased(userChoice, profileChoice);
                        break;
                    case OPEN_SIMILARITY:
                        questionScore = scoreOpenSimilarity(userChoice, profileChoice);
                        break;
                    default:
                        questionScore = 0;
                }

                totalScore += questionScore * sectionWeight;
            }
        }

        // Normalize to a range between 0.0 and 1.0
        double maxPossibleScore = sectionWeights.values().stream().mapToDouble(Double::doubleValue).sum() * 5 * 5; // 5 questions per section
        return totalScore / maxPossibleScore;
    }
}
