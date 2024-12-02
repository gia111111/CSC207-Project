package use_case.createProfile;

/**
 * The output boundary for the createProfile Use Case.
 */
public interface CreateProfileOutputBoundary {

    /**
     * Prepares the success view for the createProfile Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(CreateProfileOutputData outputData);

    /**
     * Prepares the failure view for the createProfile Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the DashBoard View.
     */
    void switchToDashBoardView();
}
