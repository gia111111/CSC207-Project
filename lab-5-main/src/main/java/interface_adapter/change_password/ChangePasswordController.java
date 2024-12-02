package interface_adapter.change_password;

import data_access.RemoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.changePassword.ChangePasswordInputBoundary;
import use_case.changePassword.ChangePasswordInputData;

/**
 * Controller for the Change Password Use Case.
 */
public class ChangePasswordController {
    private final ChangePasswordInputBoundary userChangePasswordUseCaseInteractor;
    private final ViewManagerModel viewManagerModel;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public ChangePasswordController(ChangePasswordInputBoundary userChangePasswordUseCaseInteractor,
                                    ViewManagerModel viewManagerModel, RemoteDataAccessObject dataAccessObject) {
        this.userChangePasswordUseCaseInteractor = userChangePasswordUseCaseInteractor;
        this.viewManagerModel = viewManagerModel;
        this.remoteDataAccessObject = dataAccessObject;
    }

    /**
     * Executes the Change Password Use Case.
     * @param password the new password
     * @param username the user whose password to change
     * @param securityWord the security word to verify the user
     */

    public void execute(String username, String password, String repeatPassword, String securityWord) {
        final ChangePasswordInputData changePasswordInputData = new ChangePasswordInputData(username, password, repeatPassword, securityWord);
        userChangePasswordUseCaseInteractor.execute(changePasswordInputData);
        remoteDataAccessObject.setCurrentUsername(username);
        System.out.println(remoteDataAccessObject.getCurrentUsername());


    }

    /**
     * Redirects to the Login View after a successful password change.
     */
    public void redirectToLogin() {
        viewManagerModel.setState("log in");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Handles the Cancel action to switch back to the homepage.
     */
    public void handleCancel() {
        viewManagerModel.setState("home");
        viewManagerModel.firePropertyChanged();
    }
}
