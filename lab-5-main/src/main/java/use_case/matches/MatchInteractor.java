package use_case.matches;

import use_case.requests.RequestsInputBoundary;
import use_case.requests.RequestsOutputData;

public class MatchInteractor implements MatchInputBoundary {
    private final MatchDataAccessInterface matchDataAccess;
    private final MatchOutputBoundary presenter;
    private final RequestsInputBoundary requestsInteractor;

    public MatchInteractor(MatchDataAccessInterface matchDataAccess,
                           MatchOutputBoundary presenter,
                           RequestsInputBoundary requestsInteractor) {
        this.matchDataAccess = matchDataAccess;
        this.presenter = presenter;
        this.requestsInteractor = requestsInteractor;
    }

    @Override
    public void saveMatch(MatchInputData inputData) {
        // Evaluate the request before saving the match
        RequestsOutputData requestEvaluation = requestsInteractor.evaluateRequest(inputData.getUsername(), inputData.getMatchName());

        if (requestEvaluation.isValid()) {
            // Save the match if the request is valid
            matchDataAccess.saveMatch(inputData.getUsername(), inputData.getMatchName(), inputData.getContactInfo());

            // Notify the presenter of success
            MatchOutputData outputData = new MatchOutputData(inputData.getUsername(), inputData.getMatchName(), true);
            presenter.presentMatchSaved(outputData);
        } else {
            // Notify the presenter of failure
            MatchOutputData outputData = new MatchOutputData(inputData.getUsername(), inputData.getMatchName(), false);
            presenter.presentMatchSaved(outputData);
        }
    }
}
