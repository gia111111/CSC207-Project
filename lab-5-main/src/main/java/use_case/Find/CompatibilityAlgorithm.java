package use_case.Find;

import entity.Profile;

public interface CompatibilityAlgorithm {
    double calculateScore(Profile currentUser, Profile otherUser);
}
