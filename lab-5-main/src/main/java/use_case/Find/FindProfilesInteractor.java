package use_case.Find;

import entity.Finds;
import entity.Profile;

import java.util.HashMap;
import java.util.List;

public class FindProfilesInteractor implements FindProfilesInputBoundary {
    private final FindUserDataAccessInterface profileRepository; // Data access interface for profiles
    private final CompatibilityAlgorithm compatibilityAlgorithm; // Algorithm for compatibility calculation

    public FindProfilesInteractor(FindUserDataAccessInterface profileRepository, CompatibilityAlgorithm compatibilityAlgorithm) {
        this.profileRepository = profileRepository;
        this.compatibilityAlgorithm = compatibilityAlgorithm;
    }

    @Override
    public Finds execute(String currentUsername) {
        // Fetch the current user's profile
        Profile currentUserProfile = profileRepository.getProfile(currentUsername);

        // Fetch all profiles from the repository
        List<Profile> allProfiles = profileRepository.getAllProfiles();

        // Prepare result maps
        HashMap<String, Boolean> finds = new HashMap<>();
        HashMap<String, Double> scores = new HashMap<>();

        // Iterate over profiles and calculate compatibility scores
        for (Profile otherProfile : allProfiles) {
            if (!otherProfile.getName().equals(currentUsername)) {
                // Calculate compatibility score
                double score = compatibilityAlgorithm.calculateScore(currentUserProfile, otherProfile);

                // Add score and match decision
                scores.put(otherProfile.getName(), score);
                finds.put(otherProfile.getName(), score >= 0.8); // Example threshold for compatibility
            }
        }

        // Return the finds
        return new Finds(finds, scores);
    }
}
