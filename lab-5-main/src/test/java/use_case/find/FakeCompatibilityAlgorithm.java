package use_case.find;

import entity.Profile;

public class FakeCompatibilityAlgorithm implements CompatibilityAlgorithm {
    @Override
    public double calculateScore(Profile currentUserProfile, Profile otherProfile) {
        // Return a fake score based on the username
        if (otherProfile.getName().equals("user1")) return 0.9;
        if (otherProfile.getName().equals("user2")) return 0.7;
        return 0.0;
    }
}
