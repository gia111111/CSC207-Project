package use_case.manageRequest;

public interface ManageRequestOutputBoundary {
    /**
     * Prepares the success view for the manageRequest Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(ManageRequestOutputData outputData);

    /**
     * Prepares the failure view for the manageRequest Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Request View.
     */
    void switchToRequestView();
}

