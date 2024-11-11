package interface_adapter.home;

import interface_adapter.ViewManagerModel;

/**
 * Controller for the Home Page.
 */
public class HomePageController {
    private final ViewManagerModel viewManagerModel;

    public HomePageController(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Navigates to the Login View.
     */
    public void switchToLoginView() {
        viewManagerModel.setState("login");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Navigates to the Signup View.
     */
    public void switchToSignupView() {
        viewManagerModel.setState("sign up");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Navigates to the Dashboard View.
     */
    public void switchToDashboardView() {
        viewManagerModel.setState("logged in");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Navigates to the Reset Password View.
     */
    public void switchToResetPasswordView() {
        viewManagerModel.setState("reset password");
        viewManagerModel.firePropertyChanged();
    }
}
