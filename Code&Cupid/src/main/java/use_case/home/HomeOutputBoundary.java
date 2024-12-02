package use_case.home;

/**
 * An interface for the Home use case.
 */
public interface HomeOutputBoundary {
    /**
     * Prepares the success view for the Home Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(HomeOutputData outputData);

    /**
     * Prepares the failure view for the Signup Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Login View.
     */
    void switchToLoginView();

    /**
     * Switches to the Signup View.
     */
    void switchToResetPasswordView();

    /**
     * Switches to the Reset Password View.
     */
    void switchToSignupView();
}
