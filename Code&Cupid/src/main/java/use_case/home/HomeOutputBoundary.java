package use_case.home;

import use_case.signup.SignupOutputData;

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
    void switchToResetPasswordView();
    void switchToSignupView();
}
