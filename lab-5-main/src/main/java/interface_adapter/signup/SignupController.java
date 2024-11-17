package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * Controller for the Signup Use Case.
 */
public class SignupController {

    private final SignupInputBoundary userSignupUseCaseInteractor;
    private final ViewManagerModel viewManagerModel;

    public SignupController(SignupInputBoundary userSignupUseCaseInteractor,
                            ViewManagerModel viewManagerModel) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
        this.viewManagerModel = viewManagerModel;
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
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToProfileView() {
        viewManagerModel.setState("profile");
        viewManagerModel.firePropertyChanged();
    }
}
