package use_case.find;

import entity.Finds;
import entity.Profile;

import java.util.HashMap;
import java.util.List;

public class FindProfilesInteractor implements FindProfilesInputBoundary {
    private final FindUserDataAccessInterface dataAccess; // RemoteDataAccessObject
    private final CompatibilityAlgorithm compatibilityAlgorithm;
    private final FindProfilesOutputBoundary outputBoundary;

    public FindProfilesInteractor(FindUserDataAccessInterface dataAccess,
                                  CompatibilityAlgorithm compatibilityAlgorithm,
                                  FindProfilesOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.compatibilityAlgorithm = compatibilityAlgorithm;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(String currentUsername) {
        try {
            // Fetch the current user's profile from Firebase
            Profile currentUserProfile = dataAccess.getProfile(currentUsername);
            if (currentUserProfile == null) {
                throw new IllegalArgumentException("Profile not found for username: " + currentUsername);
            }

            // Fetch all other profiles from Firebase
            List<Profile> allProfiles = dataAccess.getAllProfiles();

            // Prepare results
            HashMap<String, Double> scores = new HashMap<>();
            HashMap<String, Boolean> matches = new HashMap<>();

            // Calculate compatibility scores for each profile
            for (Profile otherProfile : allProfiles) {
                if (!otherProfile.getName().equals(currentUsername)) {
                    // Calculate compatibility score
                    double score = compatibilityAlgorithm.calculateScore(currentUserProfile, otherProfile);

                    // Store score and match status
                    scores.put(otherProfile.getName(), score);
                    matches.put(otherProfile.getName(), score >= 0.8); // Example threshold
                }
            }

            // Package results into a Finds object
            Finds finds = new Finds(matches, scores);

            // Send results to the output boundary (e.g., Presenter)
            outputBoundary.presentFinds(finds);

        } catch (Exception e) {
            // Handle exceptions and pass error messages to the presenter
            outputBoundary.presentError("Error finding profiles: " + e.getMessage());
        }
    }
}
