package use_case.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Profile;

/**
 * A basic compatibility algorithm that calculates the compatibility score between two profiles.
 */
public class BasicCompatibilityAlgorithm2 implements CompatibilityAlgorithm2 {

    /**
     * Calculates the compatibility score between the current user and another user.
     * @param currentUser The current user.
     * @param otherUser The other user.
     * @return The compatibility score between the two users.
     */
    public double calculateScore(Profile currentUser, Profile otherUser) {
        // Accumulate the total score
        double totalScore = 0.0;
        // Total number of questions (5 sections * 5 questions)
        final int totalSections = 5;
        final int totalQuestions = 25;
        final int percent = 100;

        // Retrieve user and other user's choices
        final Map<String, List<String>> userChoices = currentUser.getAnswer();
        final Map<String, List<String>> profileChoices = otherUser.getAnswer();

        for (int section = 1; section <= totalSections; section++) {
            final String sectionKey = "section " + section;

            // Get answers for the current section
            final List<String> userAnswers = userChoices.getOrDefault(sectionKey, new ArrayList<>());
            final List<String> profileAnswers = profileChoices.getOrDefault(sectionKey, new ArrayList<>());

            // Calculate score for the current section
            totalScore += calculateSectionScore(userAnswers, profileAnswers);
        }

        // Scale the score to a maximum of 100
        return Math.round((totalScore / totalQuestions) * percent * percent) / percent;
    }

    private double calculateSectionScore(List<String> userAnswers, List<String> profileAnswers) {
        double sectionScore = 0.0;
        final double partial = 0.5;

        for (int i = 0; i < Math.min(userAnswers.size(), profileAnswers.size()); i++) {
            final String userAnswer = userAnswers.get(i);
            final String profileAnswer = profileAnswers.get(i);

            // Introduce some randomness for non-matching answers
            if (userAnswer.equals(profileAnswer)) {
                // Full score for a match
                sectionScore += 1.0;
            }
            else {
                // Partial score for mismatch
                sectionScore += Math.random() * partial;
            }
        }

        return sectionScore;
    }
}
