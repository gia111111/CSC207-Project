package interface_adapter.login;

import data_access.RemoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

/**
 * The controller for the Login Use Case.
 */
public class LoginController {

    private final LoginInputBoundary loginUseCaseInteractor;
    private final ViewManagerModel viewManagerModel;
    private final RemoteDataAccessObject dataAccessObject;

    public LoginController(LoginInputBoundary loginUseCaseInteractor, ViewManagerModel viewManagerModel, RemoteDataAccessObject dataAccessObject) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
        this.viewManagerModel = viewManagerModel;
        this.dataAccessObject = dataAccessObject;
    }

    /**
     * Executes the Login Use Case.
     * @param username the username of the user logging in
     * @param password the password of the user logging in
     */
    public void execute(String username, String password) {
        final LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
        dataAccessObject.setCurrentUsername(username);
    }

    /**
     * Handles the Cancel action to switch back to the homepage.
     */
    public void handleCancel() {
        viewManagerModel.setState("home");
        viewManagerModel.firePropertyChanged();
    }
}
