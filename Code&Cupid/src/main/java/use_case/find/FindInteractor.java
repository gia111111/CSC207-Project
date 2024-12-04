package use_case.find;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data_access.RemoteDataAccessObject;
import entity.Finds;
import entity.Profile;

/**
 * Interactor responsible for finding compatible profiles for the current user.
 * Implements the {@link FindInputBoundary} interface to define use case behavior.
 */
public class FindInteractor implements FindInputBoundary {
    private final CompatibilityAlgorithm compatibilityAlgorithm;
    private final FindOutputBoundary outputBoundary;
    private final FindDataAccessInterface remoteDataAccessObject;

    /**
     * Constructs a new FindProfilesInteractor instance.
     *
     * @param compatibilityAlgorithm the algorithm used to calculate compatibility scores
     * @param outputBoundary         the output boundary for presenting results or errors
     * @param remoteDataAccessObject the remote data access object for interacting with the database
     */
    public FindInteractor(CompatibilityAlgorithm compatibilityAlgorithm,
                          FindOutputBoundary outputBoundary,
                          FindDataAccessInterface remoteDataAccessObject) {
        this.compatibilityAlgorithm = compatibilityAlgorithm;
        this.outputBoundary = outputBoundary;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }

    /**
     * Executes the profile finding use case.
     * Fetches the current user's profile and calculates compatibility scores with other profiles.
     *
     * @param findInputData input data containing the request details
     * @return a map of usernames to their compatibility scores, or null if an error occurs
     */
    @Override
    public Map<String, Double> execute(FindInputData findInputData) {
        final String username = remoteDataAccessObject.getCurrentUsername();
        final double threshold = 0.8;
        try {
            // Fetch the current user's profile
            final Profile currentUserProfile = remoteDataAccessObject.getProfile(username);
            if (currentUserProfile == null) {
                throw new IllegalArgumentException("Profile not found for username: " + username);
            }

            // Fetch all usernames from Firebase
            final List<String> allUsernames = remoteDataAccessObject.getNames();
            if (allUsernames.isEmpty()) {
                throw new IllegalArgumentException("No profiles found in the database.");
            }

            // Remove the current user's username from the list
            allUsernames.remove(username);

            // Prepare results
            final HashMap<String, Double> scores = new HashMap<>();
            final HashMap<String, Boolean> matches = new HashMap<>();

            // Fetch each profile and calculate compatibility scores
            for (String otherUsername : allUsernames) {
                // Fetch other user's profile
                final Profile otherProfile = remoteDataAccessObject.getProfile(otherUsername);
                if (otherProfile != null) {
                    // Calculate compatibility score
                    final double score = compatibilityAlgorithm.calculateScore(currentUserProfile, otherProfile);

                    // Store score and match status
                    scores.put(otherUsername, score);
                    // Example threshold
                    matches.put(otherUsername, score >= threshold);
                }
            }

            // Package results into a Finds object
            final Finds finds = new Finds(matches, scores);
            remoteDataAccessObject.save(finds);
            // Send results to the output boundary (e.g., Presenter)
            outputBoundary.presentFinds(finds);
            return scores;

        }
        catch (Exception e) {
            // Handle exceptions and pass error messages to the presenter
            outputBoundary.presentError("Error finding profiles: " + e.getMessage());
        }
        return null;
    }

    /**
     * Updates the request status for a given user ID.
     * Delegates the action to the remote data access object.
     *
     * @param otherUserId the ID of the other user whose request status is being updated
     * @param isAccepted  the new status of the request (accepted or rejected)
     */
    @Override
    public void setRequestStatus(String otherUserId, Boolean isAccepted) {

        // Delegate the action to the data access interface
        remoteDataAccessObject.setRequestStatus(otherUserId, isAccepted);
    }
}
