
package use_case.find;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Profile;

/**
 * A basic compatibility algorithm that calculates the compatibility score between two profiles.
 * The algorithm calculates the score based on the number of matching answers between the profiles of two users.
 * The score is scaled to a maximum of 100.
 */
public class BasicCompatibilityAlgorithm implements CompatibilityAlgorithm {

    /**
     * Calculate the compatibility score between the current user and another user.
     * The score is calculated based on the number of matching answers between the two profiles.
     * The score is scaled to a maximum of 100.
     *
     * @param currentUser The profile of the current user.
     * @param otherUser The profile of the other user.
     * @return The compatibility score between the two profiles.
     */
    public double calculateScore(Profile currentUser, Profile otherUser) {
        // Accumulate the total score
        double totalScore = 0.0;
        // Total number of questions (5 sections * 5 questions)
        final int totalQuestions = 25;
        final int totalSections = 5;
        final int percentage = 100;

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
        return Math.round((totalScore / totalQuestions) * percentage * percentage) / percentage;
    }

    private double calculateSectionScore(List<String> userAnswers, List<String> profileAnswers) {
        double sectionScore = 0.0;
        final double randomFactor = 0.5;

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
                sectionScore += Math.random() * randomFactor;
            }
        }

        return sectionScore;
    }
}
