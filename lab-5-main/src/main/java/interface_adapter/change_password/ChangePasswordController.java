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
     * @param repeatPassword the repeated password
     */
    public void execute(String password, String username, String repeatPassword) {
        final ChangePasswordInputData changePasswordInputData =
                new ChangePasswordInputData(username, password, repeatPassword);

        userChangePasswordUseCaseInteractor.execute(changePasswordInputData);
        // userChangePasswordUseCaseInteractor2.execute(changePasswordInputData);

    }

    public void switchToHomePageView() {
        userChangePasswordUseCaseInteractor.switchToHomePageView();
    }
}
