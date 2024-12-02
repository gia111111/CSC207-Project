package use_case.matches;

/**
 * An interface for the Matches output boundary.
 */
public interface MatchesOutputBoundary {

    /**
     * Prepares the success view for Matches usecase.
     * @param matchesOutputData The output data for the Matches use case.
     */
    void prepareSuccessView(MatchesOutputData matchesOutputData);

    /**
     * Prepares the failure view for the Matches usecase.
     * @param errorMessage The error message to display.
     */
    void prepareFailView(String errorMessage);

    /**
     * Swtiches to the Dashboard view.
     */
    void switchToDashBoardView();

}
