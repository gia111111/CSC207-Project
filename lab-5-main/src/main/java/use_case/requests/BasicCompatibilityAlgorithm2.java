//package use_case.requests;
//
//import entity.Profile;
//import use_case.requests.CompatibilityAlgorithm2;
//
//import java.util.Map;
//
//public class BasicCompatibilityAlgorithm2 implements CompatibilityAlgorithm2 {
//
//    public enum QuestionType {
//        HIGHEST_VALUE, // Type 1: A as the highest value, others lower
//        FREQUENCY_BASED, // Type 2: Higher frequency closer to the user's choice
//        OPEN_SIMILARITY // Type 3: Open question with graded similarity
//    }
//
//    Map<Integer, QuestionType> questionTypes = Map.of(
//            1, QuestionType.HIGHEST_VALUE, // Section 1, Question 1
//            2, QuestionType.FREQUENCY_BASED, // Section 1, Question 2
//            3, QuestionType.OPEN_SIMILARITY// Section 1, Question 3
//            // Add for all sections/questions...
//    );
//
//    private int scoreHighestValue(String userChoice, String profileChoice) {
//        int userValue = 5; // Always assign 5 to user's selected choice
//        int defaultValue = 2; // Default value for others
//        return userChoice.equals(profileChoice) ? userValue : defaultValue;
//    }
//
//    private int scoreFrequencyBased(String userChoice, String profileChoice) {
//        Map<String, Integer> values = Map.of(
//                "A", 1, "B", 2, "C", 3, "D", 4, "E", 5
//        );
//        int userValue = values.get(userChoice);
//        int profileValue = values.get(profileChoice);
//
//        // Calculate difference and assign scores
//        return 5 - Math.abs(userValue - profileValue);
//    }
//
//    private int scoreOpenSimilarity(String userChoice, String profileChoice) {
//        // Define a similarity matrix or a mapping of choices
//        Map<String, Map<String, Integer>> similarityMatrix = Map.of(
//                "A", Map.of("A", 5, "B", 4, "C", 3, "D", 2, "E", 1),
//                "B", Map.of("A", 4, "B", 5, "C", 4, "D", 3, "E", 2),
//                "C", Map.of("A", 3, "B", 4, "C", 5, "D", 4, "E", 3)
//                // Add mappings for "D" and "E"...
//        );
//
//        return similarityMatrix.get(userChoice).getOrDefault(profileChoice, 1); // Default to 1 if no match
//    }
//
//    @Override
//    public double calculateScore(Profile currentUser, Profile otherUser) {
//        double totalScore = 0.0;
//        int totalQuestions = 25; // 5 sections * 5 questions per section
//
//        for (int section = 1; section <= 5; section++) {
//            for (int question = 1; question <= 5; question++) {
//                String userChoice = currentUser.getAnswer().toString();
//                String profileChoice = otherUser.getAnswer().toString();
//
//                QuestionType questionType = questionTypes.get((section - 1) * 5 + question);
//
//                int questionScore;
//                switch (questionType) {
//                    case HIGHEST_VALUE:
//                        questionScore = scoreHighestValue(userChoice, profileChoice);
//                        break;
//                    case FREQUENCY_BASED:
//                        questionScore = scoreFrequencyBased(userChoice, profileChoice);
//                        break;
//                    case OPEN_SIMILARITY:
//                        questionScore = scoreOpenSimilarity(userChoice, profileChoice);
//                        break;
//                    default:
//                        questionScore = 0; // Default if no type is matched
//                }
//
//                totalScore += questionScore;
//            }
//        }
//
//        // Normalize the total score to a range between 0.0 and 1.0
//        return totalScore / (totalQuestions * 5.0); // Max score per question is 5
//    }
//
//    public double calculateWeightedScore(Profile currentUserProfile, Profile otherProfile, Map<Integer, Double> sectionWeights) {
//        double totalScore = 0.0;
//
//        for (int section = 1; section <= 5; section++) {
//            double sectionWeight = sectionWeights.getOrDefault(section, 1.0); // Default weight is 1.0
//
//            for (int question = 1; question <= 5; question++) {
//                String userChoice = currentUserProfile.getAnswer().toString();
//                String profileChoice = otherProfile.getAnswer().toString();
//
//                QuestionType questionType = questionTypes.get((section - 1) * 5 + question);
//
//                int questionScore;
//                switch (questionType) {
//                    case HIGHEST_VALUE:
//                        questionScore = scoreHighestValue(userChoice, profileChoice);
//                        break;
//                    case FREQUENCY_BASED:
//                        questionScore = scoreFrequencyBased(userChoice, profileChoice);
//                        break;
//                    case OPEN_SIMILARITY:
//                        questionScore = scoreOpenSimilarity(userChoice, profileChoice);
//                        break;
//                    default:
//                        questionScore = 0;
//                }
//
//                totalScore += questionScore * sectionWeight;
//            }
//        }
//
//        // Normalize to a range between 0.0 and 1.0
//        double maxPossibleScore = sectionWeights.values().stream().mapToDouble(Double::doubleValue).sum() * 5 * 5; // 5 questions per section
//        return totalScore / maxPossibleScore;
//    }
//}

package use_case.requests;

import entity.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasicCompatibilityAlgorithm2 implements CompatibilityAlgorithm2{

//    public enum QuestionType {
//        HIGHEST_VALUE, // Type 1: A as the highest value, others lower
//        FREQUENCY_BASED, // Type 2: Higher frequency closer to the user's choice
//        OPEN_SIMILARITY // Type 3: Open question with graded similarity
//    }
//
//    Map<Integer, QuestionType> questionTypes = Map.of(
//            1, QuestionType.HIGHEST_VALUE, // Section 1, Question 1
//            2, QuestionType.FREQUENCY_BASED, // Section 1, Question 2
//            3, QuestionType.OPEN_SIMILARITY// Section 1, Question 3
//            // Add for all sections/questions...
//    );
//
//    private int scoreHighestValue(Map<String, List<String>> userChoice, Map<String, List<String>> profileChoice, String questionKey) {
////        int userValue = 5; // Always assign 5 to user's selected choice
////        int defaultValue = 2; // Default value for others
////        return userChoice.equals(profileChoice) ? userValue : defaultValue;
//        int maxScore = 10; // Define the max score for a match
//        int mismatchPenalty = 2; // Penalty for mismatches
//
//        // Retrieve the lists of choices for the given question key
//        List<String> userAnswers = userChoice.getOrDefault(questionKey, new ArrayList<>());
//        List<String> profileAnswers = profileChoice.getOrDefault(questionKey, new ArrayList<>());
//
//        if (userAnswers.isEmpty() || profileAnswers.isEmpty()) {
//            return 0; // No score if either user or profile has no answer
//        }
//
//        // Compare the first answer in each list (or extend logic for multiple answers)
//        String userAnswer = userAnswers.get(0);
//        String profileAnswer = profileAnswers.get(0);
//
//        // Calculate the score based on equality
//        return userAnswer.equals(profileAnswer) ? maxScore : Math.max(0, maxScore - mismatchPenalty);
//    }
//
//    private int scoreFrequencyBased(Map<String, List<String>> userChoice, Map<String, List<String>> profileChoice, String questionKey) {
////        Map<String, Integer> values = Map.of(
////                "A", 1, "B", 2, "C", 3, "D", 4, "E", 5
////        );
////        int userValue = values.get(userChoice);
////        int profileValue = values.get(profileChoice);
////
////        // Calculate difference and assign scores
////        return 5 - Math.abs(userValue - profileValue);
//        // Example logic
//        List<String> userAnswers = userChoice.getOrDefault(questionKey, new ArrayList<>());
//        List<String> profileAnswers = profileChoice.getOrDefault(questionKey, new ArrayList<>());
//
//        if (userAnswers.isEmpty() || profileAnswers.isEmpty()) {
//            return 0;
//        }
//
//        // Compare frequency or other metrics between userAnswers and profileAnswers
//        // For now, simple comparison of first answers:
//        String userAnswer = userAnswers.get(0);
//        String profileAnswer = profileAnswers.get(0);
//
//        Map<String, Integer> values = Map.of("A", 1, "B", 2, "C", 3, "D", 4, "E", 5);
//        int userValue = values.getOrDefault(userAnswer, 0);
//        int profileValue = values.getOrDefault(profileAnswer, 0);
//
//        return 5 - Math.abs(userValue - profileValue); // Score decreases as the difference increases
//    }
//
//    private int scoreOpenSimilarity(Map<String, List<String>> userChoice, Map<String, List<String>> profileChoice, String questionKey) {
//        // Define a similarity matrix or a mapping of choices
//        Map<String, Map<String, Integer>> similarityMatrix = Map.of(
//                "A", Map.of("A", 5, "B", 4, "C", 3, "D", 2, "E", 1),
//                "B", Map.of("A", 4, "B", 5, "C", 4, "D", 3, "E", 2),
//                "C", Map.of("A", 3, "B", 4, "C", 5, "D", 4, "E", 3)
//                // Add mappings for "D" and "E"...
//        );
//
//        // Retrieve the answers for the given questionKey
//        List<String> userAnswers = userChoice.getOrDefault(questionKey, new ArrayList<>());
//        List<String> profileAnswers = profileChoice.getOrDefault(questionKey, new ArrayList<>());
//
//        if (userAnswers.isEmpty() || profileAnswers.isEmpty()) {
//            return 1; // Default score if one or both answers are missing
//        }
//
//        // Use the first answer in the list (can be extended to consider multiple answers)
//        String userAnswer = userAnswers.get(0);
//        String profileAnswer = profileAnswers.get(0);
//
//        // Check the similarity matrix
//        return similarityMatrix.getOrDefault(userAnswer, Map.of()).getOrDefault(profileAnswer, 1); // Default to 1 if no match
//    }
//
//    @Override
//    public double calculateScore(Profile currentUser, Profile otherUser) {
//        double totalScore = 0.0;
//        int totalQuestions = 25; // 5 sections * 5 questions per section
//
//        for (int section = 1; section <= 5; section++) {
//            for (int question = 1; question <= 5; question++) {
//                String questionKey = "section" + section + "_question" + question;
//                Map<String, List<String>> userChoice = currentUser.getAnswer();
//                Map<String, List<String>> profileChoice = otherUser.getAnswer();
//
//                QuestionType questionType = questionTypes.get((section - 1) * 5 + question);
//
//                int questionScore;
//                if (questionType == null) {
//                    questionScore = 0; // Default score if no type is matched
//                } else {
//                    switch (questionType) {
//                        case HIGHEST_VALUE:
//                            questionScore = scoreHighestValue(userChoice, profileChoice, questionKey);
//                            break;
//                        case FREQUENCY_BASED:
//                            questionScore = scoreFrequencyBased(userChoice, profileChoice, questionKey);
//                            break;
//                        case OPEN_SIMILARITY:
//                            questionScore = scoreOpenSimilarity(userChoice, profileChoice, questionKey);
//                            break;
//                        default:
//                            questionScore = 0; // Default score for undefined question type
//                    }
//                }
//
//                totalScore += questionScore; // Add question score to total
//            }
//        }
//
//        // Normalize the total score to a range between 0.0 and 1.0
//        return totalScore / (totalQuestions * 5.0); // Max score per question is 5
//    }

    //    public double calculateWeightedScore(Profile currentUserProfile, Profile otherProfile, Map<Integer, Double> sectionWeights) {
//        double totalScore = 0.0;
//
//        for (int section = 1; section <= 5; section++) {
//            double sectionWeight = sectionWeights.getOrDefault(section, 1.0); // Default weight is 1.0
//
//            for (int question = 1; question <= 5; question++) {
//                String userChoice = currentUserProfile.getAnswer().toString();
//                String profileChoice = otherProfile.getAnswer().toString();
//
//                QuestionType questionType = questionTypes.get((section - 1) * 5 + question);
//
//                int questionScore;
//                switch (questionType) {
//                    case HIGHEST_VALUE:
//                        questionScore = scoreHighestValue(userChoice, profileChoice);
//                        break;
//                    case FREQUENCY_BASED:
//                        questionScore = scoreFrequencyBased(userChoice, profileChoice);
//                        break;
//                    case OPEN_SIMILARITY:
//                        questionScore = scoreOpenSimilarity(userChoice, profileChoice);
//                        break;
//                    default:
//                        questionScore = 0;
//                }
//
//                totalScore += questionScore * sectionWeight;
//            }
//        }
//
//        // Normalize to a range between 0.0 and 1.0
//        double maxPossibleScore = sectionWeights.values().stream().mapToDouble(Double::doubleValue).sum() * 5 * 5; // 5 questions per section
//        return totalScore / maxPossibleScore;
//    }
    public double calculateScore(Profile currentUser, Profile otherUser) {
        double totalScore = 0.0; // Accumulate the total score
        int totalQuestions = 25; // Total number of questions (5 sections * 5 questions)

        // Retrieve user and other user's choices
        Map<String, List<String>> userChoices = currentUser.getAnswer();
        Map<String, List<String>> profileChoices = otherUser.getAnswer();

        for (int section = 1; section <= 5; section++) {
            for (int question = 1; question <= 5; question++) {
                String questionKey = "section" + section + "_question" + question;

                // Get answers for the current question
                List<String> userAnswers = userChoices.getOrDefault(questionKey, new ArrayList<>());
                List<String> profileAnswers = profileChoices.getOrDefault(questionKey, new ArrayList<>());

                // Calculate score for the current question
                totalScore = calculateQuestionScore(userAnswers, profileAnswers) + 1.0;
            }
        }

        // Normalize the total score to a range of 0.0 to 1.0
        return totalScore / totalQuestions; // Assume max score per question is 1.0
    }

    private double calculateQuestionScore(List<String> userAnswers, List<String> profileAnswers) {
        if (userAnswers.isEmpty() || profileAnswers.isEmpty()) {
            return 0.0; // No score if either user or profile has no answer
        }

        // Compare the first answer of each (extend for multiple answers if needed)
        String userAnswer = userAnswers.get(0);
        String profileAnswer = profileAnswers.get(0);

        // Return 1.0 for a match, 0.0 for a mismatch
        double score = userAnswer.equals(profileAnswer) ? 1.0 : 0.0;
        System.out.println("User Answer: " + userAnswer + ", Profile Answer: " + profileAnswer + ", Score: " + score);
        return score;
    }
}