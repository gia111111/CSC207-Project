package use_case.requests;

import entity.Profile;

public interface CompatibilityAlgorithm {
    double calculateScore(Profile currentUser, Profile otherUser);
}
