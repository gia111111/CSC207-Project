package use_case.requests;

import entity.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasicCompatibilityAlgorithm2 implements CompatibilityAlgorithm2 {
    public double calculateScore(Profile currentUser, Profile otherUser) {
        double totalScore = 0.0; // Accumulate the total score
        int totalQuestions = 25; // Total number of questions (5 sections * 5 questions)

        // Retrieve user and other user's choices
        Map<String, List<String>> userChoices = currentUser.getAnswer();
        Map<String, List<String>> profileChoices = otherUser.getAnswer();

        for (int section = 1; section <= 5; section++) {
            String sectionKey = "section " + section;

            // Get answers for the current section
            List<String> userAnswers = userChoices.getOrDefault(sectionKey, new ArrayList<>());
            List<String> profileAnswers = profileChoices.getOrDefault(sectionKey, new ArrayList<>());

            // Calculate score for the current section
            totalScore += calculateSectionScore(userAnswers, profileAnswers);
        }

        // Scale the score to a maximum of 100
        return Math.round((totalScore / totalQuestions) * 100 * 100.0) / 100.0;
    }


    private double calculateSectionScore(List<String> userAnswers, List<String> profileAnswers) {
        double sectionScore = 0.0;

        for (int i = 0; i < Math.min(userAnswers.size(), profileAnswers.size()); i++) {
            String userAnswer = userAnswers.get(i);
            String profileAnswer = profileAnswers.get(i);

            // Introduce some randomness for non-matching answers
            if (userAnswer.equals(profileAnswer)) {
                sectionScore += 1.0; // Full score for a match
            } else {
                sectionScore += Math.random() * 0.5; // Partial score for mismatch
            }
        }

        return sectionScore;
    }
}
