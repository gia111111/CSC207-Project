package use_case.home;

/**
 * An interface for the Home use case.
 */
public interface HomeInputBoundary {

    /**
     * Switches to the login view.
     */
    void switchToLoginView();

    /**
     * Switches to the signup view.
     */
    void switchToSignupView();

    /**
     * Switches to the reset password view.
     */
    void switchToResetPasswordView();
}
