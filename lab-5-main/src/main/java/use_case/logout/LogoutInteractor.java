package use_case.logout;

/**
 * The Logout Interactor.
 */

public class LogoutInteractor implements LogoutInputBoundary {

    private final LogoutUserDataAccessInterface userDataAccessObject;
    private final LogoutOutputBoundary logoutPresenter;

    // Constructor to save the DAO and Presenter in the instance variables
    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;  // DAO for data access
        this.logoutPresenter = logoutOutputBoundary;  // Presenter for the output view
    }

    @Override
    public void execute(LogoutInputData logoutInputData) {
        // 1. Get the username out of the input data
        String username = logoutInputData.getUsername();

        // 2. Set the username to null in the DAO (i.e., log the user out)
        userDataAccessObject.setCurrentUsername(username);

        // 3. Instantiate the `LogoutOutputData`, which needs to contain the username
        LogoutOutputData outputData = new LogoutOutputData(username, false);

        // 4. Tell the presenter to prepare a success view
        logoutPresenter.prepareSuccessView(outputData);
    }
}


