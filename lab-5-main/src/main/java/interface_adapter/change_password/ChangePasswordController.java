package interface_adapter.change_password;

import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInputData;

/**
 * Controller for the Change Password Use Case.
 */
public class ChangePasswordController {
    private final ChangePasswordInputBoundary userChangePasswordUseCaseInteractor;
    // private final ChangePasswordInputBoundary userChangePasswordUseCaseInteractor2;

    public ChangePasswordController(ChangePasswordInputBoundary userChangePasswordUseCaseInteractor) {
        this.userChangePasswordUseCaseInteractor = userChangePasswordUseCaseInteractor;
        // this.userChangePasswordUseCaseInteractor2 = userChangePasswordUseCaseInteractor2;

    }

    /**
     * Executes the Change Password Use Case.
     * @param password the new password
     * @param username the user whose password to change
     * @param securityCode the security code to verify the user
     */
    public void execute(String password, String username, String securityCode) {
        final ChangePasswordInputData changePasswordInputData = new ChangePasswordInputData(username, password, securityCode);

        userChangePasswordUseCaseInteractor.execute(changePasswordInputData);
        // userChangePasswordUseCaseInteractor2.execute(changePasswordInputData);

    }
}
