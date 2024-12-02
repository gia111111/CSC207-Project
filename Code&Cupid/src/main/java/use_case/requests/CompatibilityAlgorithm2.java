package use_case.requests;

import entity.Profile;

/**
 * An interface for the CompatibilityAlgorithm2 use case.
 */
public interface CompatibilityAlgorithm2 {

    /**
     * Calculates the compatibility score between two profiles.
     * @param currentUser The current user's profile.
     * @param otherUser The other user's profile.
     * @return The compatibility score.
     */
    double calculateScore(Profile currentUser, Profile otherUser);
}
