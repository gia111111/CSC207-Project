package interface_adapter.change_password;

import interface_adapter.ViewManagerModel;
import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInputData;

/**
 * Controller for the Change Password Use Case.
 */
public class ChangePasswordController {
    private final ChangePasswordInputBoundary userChangePasswordUseCaseInteractor;
    private final ViewManagerModel viewManagerModel;

    public ChangePasswordController(ChangePasswordInputBoundary userChangePasswordUseCaseInteractor,
                                    ViewManagerModel viewManagerModel) {
        this.userChangePasswordUseCaseInteractor = userChangePasswordUseCaseInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Executes the Change Password Use Case.
     * @param password the new password
     * @param username the user whose password to change
     * @param securityWord the security word to verify the user
     */

    public void execute(String password, String username, String repeatPassword, String securityWord) {
        final ChangePasswordInputData changePasswordInputData = new ChangePasswordInputData(username, password, repeatPassword, securityWord);

        userChangePasswordUseCaseInteractor.execute(changePasswordInputData);

    }

    /**
     * Redirects to the Login View after a successful password change.
     */
    public void redirectToLogin() {
        viewManagerModel.setState("log in");
        viewManagerModel.firePropertyChanged();
    }
}
