package use_case.find;

import entity.Profile;

public interface CompatibilityAlgorithm {
    double calculateScore(Profile currentUser, Profile otherUser);
}