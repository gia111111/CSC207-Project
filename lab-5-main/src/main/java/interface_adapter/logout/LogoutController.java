package interface_adapter.logout;

import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInputData;

/**
 * The controller for the Logout Use Case.
        */
public class LogoutController {

    private final LogoutInputBoundary logoutUseCaseInteractor;

    // Constructor to save the interactor in the instance variable
    public LogoutController(LogoutInputBoundary logoutUseCaseInteractor) {
        this.logoutUseCaseInteractor = logoutUseCaseInteractor;
    }

    /**
     * Executes the Logout Use Case.
     * @param username the username of the user logging in
     */
    public void execute(String username) {
        // 1. Instantiate the `LogoutInputData` with the username
        LogoutInputData inputData = new LogoutInputData(username);

        // 2. Tell the Interactor to execute the use case
        logoutUseCaseInteractor.execute(inputData);
    }
}