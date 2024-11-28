package view;

import entity.Profile;

public interface CompatibilityAlgorithm {
    double calculateScore(Profile currentUser, Profile otherUser);
}
