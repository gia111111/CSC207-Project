package use_case.matches;

import use_case.requests.RequestsInputBoundary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchInteractor implements MatchInputBoundary {
    private final MatchDataAccessInterface matchDataAccess;
    private final MatchOutputBoundary presenter;
    //private final RequestsInputBoundary requestsInteractor;

    public MatchInteractor(MatchDataAccessInterface matchDataAccess,
                           MatchOutputBoundary presenter,
                           RequestsInputBoundary requestsInteractor) {
        this.matchDataAccess = matchDataAccess;
        this.presenter = presenter;
        //this.requestsInteractor = requestsInteractor;
    }

    @Override
    public void saveMatch(MatchInputData inputData) {
        HashMap<String, List<String>> matches = inputData.getMatches();

        for (Map.Entry<String, List<String>> entry : matches.entrySet()) {
            String matchName = entry.getKey();
            List<String> contactInfo = entry.getValue();

            // Save match for each entry
            matchDataAccess.saveMatch(inputData.getUsername(), matchName, contactInfo);
        }

        // Return success output to the presenter
        MatchOutputData outputData = new MatchOutputData(
                inputData.getUsername(),
                matches,
                true,
                "Matches saved successfully."
        );
        presenter.presentMatchOutput(outputData);
    }
    @Override
    public MatchOutputData getMatches(String username) {
        HashMap<String, List<String>> matches = matchDataAccess.getMatches(username);

        MatchOutputData outputData = new MatchOutputData(
                username,
                matches,
                true,
                "Matches retrieved successfully."
        );
        presenter.presentMatchOutput(outputData);
        return outputData;
    }
}
