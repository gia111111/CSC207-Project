package interface_adapter.matches;

import interface_adapter.ViewManagerModel;
import use_case.matches.MatchInputBoundary;
import use_case.matches.MatchInputData;
import use_case.matches.MatchOutputData;

import java.util.HashMap;
import java.util.List;

public class MatchesController {
    private final MatchInputBoundary matchInteractor;
    private final ViewManagerModel viewManagerModel;

    public MatchesController(ViewManagerModel viewManagerModel, MatchInputBoundary matchInteractor) {
        this.viewManagerModel = viewManagerModel;
        this.matchInteractor = matchInteractor;
    }

    public void switchToDashboard() {
        // Switch to the dashboard view
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Handles saving multiple matches for a user.
     * @param username The username of the current user.
     * @param matches A HashMap where the key is the match's username, and the value is a list containing contact info.
     */
    public void saveMatches(String username, HashMap<String, List<String>> matches) {
        // Create MatchInputData with the provided data
        MatchInputData inputData = new MatchInputData(username, matches);

        // Call the interactor to process the matches
        matchInteractor.saveMatch(inputData);
    }

    /**
     * Handles retrieving all matches for a user.
     * @param username The username of the current user.
     */
    public void getMatches(String username) {
        // Call the interactor to fetch matches
        MatchOutputData outputData = matchInteractor.getMatches(username);

        // Output or process the result (delegating to the presenter)
        // For simplicity, this example directly prints the output
        if (outputData.isSuccess()) {
            System.out.println("Matches for " + username + ":");
            outputData.getMatches().forEach((matchName, contactInfo) -> {
                System.out.println("  Match Name: " + matchName);
                System.out.println("  Contact Method: " + contactInfo.get(0));
                System.out.println("  Contact Info: " + contactInfo.get(1));
            });
        } else {
            System.out.println("Failed to retrieve matches: " + outputData.getMessage());
        }
    }
}
