package use_case.matches;

public interface MatchesOutputBoundary {

    /**
     * Prepares the success view for Matches usecase.
     * @param matchesOutputData
     */
    void prepareSuccessView(MatchesOutputData matchesOutputData);

    /**
     * Prepares the failure view for the Matches usecase.
     * @param errorMessage
     */
    void prepareFailView(String errorMessage);

    /**
     * Swtiches to the Dashboard view.
     */
    void switchToDashBoardView();

}
