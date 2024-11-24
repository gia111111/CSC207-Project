package interface_adapter.signup;

import data_access.RemoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * Controller for the Signup Use Case.
 */
public class SignupController {

    private final SignupInputBoundary userSignupUseCaseInteractor;
    private final ViewManagerModel viewManagerModel;
    private final RemoteDataAccessObject remoteDataAccessObject;


    public SignupController(SignupInputBoundary userSignupUseCaseInteractor, ViewManagerModel viewManagerModel, RemoteDataAccessObject remoteDataAccessObject) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
        this.viewManagerModel = viewManagerModel;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }

    /**
     * Executes the Signup Use Case.
     * @param username the username to sign up
     * @param password1 the password
     * @param password2 the password repeated
     */
    public void execute(String username, String password1, String password2, String securityWord) {
        final SignupInputData signupInputData = new SignupInputData(
                username, password1, password2, securityWord);

        userSignupUseCaseInteractor.execute(signupInputData);
        remoteDataAccessObject.setCurrentUsername(username);
        System.out.println(remoteDataAccessObject.getCurrentUsername());
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToProfileView() {
        viewManagerModel.setState("profile");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Handles the Cancel action to switch back to the Home Page.
     */
    public void handleCancel() {
        viewManagerModel.setState("home");
        viewManagerModel.firePropertyChanged();
    }
}
