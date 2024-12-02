package use_case.requests;

import entity.Profile;

public interface CompatibilityAlgorithm2 {
    double calculateScore(Profile currentUser, Profile otherUser);
}
