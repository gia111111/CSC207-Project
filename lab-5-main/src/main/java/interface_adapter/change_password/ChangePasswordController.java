package interface_adapter.change_password;

import interface_adapter.ViewManagerModel;
import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInputData;

/**
 * Controller for the Change Password Use Case.
 */
public class ChangePasswordController {
    private final ChangePasswordInputBoundary userChangePasswordUseCaseInteractor;
    // private final ChangePasswordInputBoundary userChangePasswordUseCaseInteractor2;
    private final ViewManagerModel viewManagerModel;

    public ChangePasswordController(ChangePasswordInputBoundary userChangePasswordUseCaseInteractor,
                                    ViewManagerModel viewManagerModel) {
        this.userChangePasswordUseCaseInteractor = userChangePasswordUseCaseInteractor;
        // this.userChangePasswordUseCaseInteractor2 = userChangePasswordUseCaseInteractor2;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Executes the Change Password Use Case.
     * @param password the new password
     * @param username the user whose password to change
     * @param securityCode the security code to verify the user
     */
    public void execute(String password, String username, String repeatPassword, String securityCode) {
        final ChangePasswordInputData changePasswordInputData = new ChangePasswordInputData(username, password, repeatPassword, securityCode);

        userChangePasswordUseCaseInteractor.execute(changePasswordInputData);
        // userChangePasswordUseCaseInteractor2.execute(changePasswordInputData);

    }

    /**
     * Redirects to the Login View after a successful password change.
     */
    public void redirectToLogin() {
        viewManagerModel.setState("log in");
        viewManagerModel.firePropertyChanged();
    }
}
