package use_case.find;

import entity.Profile;

/**
 * An interface for compatibility algorithms that calculate the compatibility score between two profiles.
 */
public interface CompatibilityAlgorithm {
    /**
     * Calculate the compatibility score between the current user and another user.
     *
     * @param currentUser The profile of the current user.
     * @param otherUser The profile of the other user.
     * @return The compatibility score between the two profiles.
     */
    double calculateScore(Profile currentUser, Profile otherUser);
}
