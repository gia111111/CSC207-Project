package use_case.requests;


public interface RequestsOutputBoundary {
    /**
     * Prepares the success view for the Requests Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RequestsOutputData outputData);

    /**
     * Prepares the failure view for the Requests Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the ViewProfile View.
     */
    void switchToViewProfileView();

    /**
     * Switches to the Dashboard View.
     */
    void switchToDashBoardView();

}
