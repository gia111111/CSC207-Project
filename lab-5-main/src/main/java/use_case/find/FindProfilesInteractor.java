package use_case.find;

import data_access.RemoteDataAccessObject;
import entity.Finds;
import entity.Profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindProfilesInteractor implements FindProfilesInputBoundary {
//    private final FindUserDataAccessInterface dataAccess; // RemoteDataAccessObject
    private final CompatibilityAlgorithm compatibilityAlgorithm;
    private final FindProfilesOutputBoundary outputBoundary;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public FindProfilesInteractor(CompatibilityAlgorithm compatibilityAlgorithm,
                                  FindProfilesOutputBoundary outputBoundary,
                                  RemoteDataAccessObject remoteDataAccessObject) {
//        this.dataAccess = dataAccess;
        this.compatibilityAlgorithm = compatibilityAlgorithm;
        this.outputBoundary = outputBoundary;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }



    @Override
    public Map<String, Double> execute(FindProfileInputData findProfileInputData) {
        String username = remoteDataAccessObject.getCurrentUsername();
        try {
            // Fetch the current user's profile
            Profile currentUserProfile = remoteDataAccessObject.getProfile(username);
            if (currentUserProfile == null) {
                throw new IllegalArgumentException("Profile not found for username: " + username);
            }

            // Fetch all usernames from Firebase
            List<String> allUsernames = remoteDataAccessObject.getNames();
            if (allUsernames.isEmpty()) {
                throw new IllegalArgumentException("No profiles found in the database.");
            }

            // Remove the current user's username from the list
            allUsernames.remove(username);

            // Prepare results
            HashMap<String, Double> scores = new HashMap<>();
            HashMap<String, Boolean> matches = new HashMap<>();

            // Fetch each profile and calculate compatibility scores
            for (String otherUsername : allUsernames) {
                // Fetch other user's profile
                Profile otherProfile = remoteDataAccessObject.getProfile(otherUsername);
                if (otherProfile != null) {
                    // Calculate compatibility score
                    double score = compatibilityAlgorithm.calculateScore(currentUserProfile, otherProfile);

                    // Store score and match status
                    scores.put(otherUsername, score);
                    matches.put(otherUsername, score >= 0.8); // Example threshold
                }
            }

            // Package results into a Finds object
            Finds finds = new Finds(matches, scores);

            // Send results to the output boundary (e.g., Presenter)
            outputBoundary.presentFinds(finds);
            return scores;

        } catch (Exception e) {
            // Handle exceptions and pass error messages to the presenter
            outputBoundary.presentError("Error finding profiles: " + e.getMessage());
        }
        return null;
    }
}
