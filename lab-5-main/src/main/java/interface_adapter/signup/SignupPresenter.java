package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.profile.ProfileState;
import interface_adapter.profile.ProfileViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class SignupPresenter implements SignupOutputBoundary {

    private final SignupViewModel signupViewModel;
    //private final LoginViewModel loginViewModel;
    private ProfileViewModel profileViewModel;
    private final ViewManagerModel viewManagerModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           ProfileViewModel profileViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        //this.loginViewModel = loginViewModel;
        this.profileViewModel = profileViewModel;
    }

    @Override
    public void prepareSuccessView(SignupOutputData response) {
        // On success, switch to the login view.
//        final LoginState loginState = loginViewModel.getState();
//        loginState.setUsername(response.getUsername());
//        this.loginViewModel.setState(loginState);
//        loginViewModel.firePropertyChanged();
//
//        viewManagerModel.setState(loginViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
        final SignupState signupState = signupViewModel.getState();
        signupState.setUsername(response.getUsername());
        this.signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();

        viewManagerModel.setState("profile");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void switchToProfileView() {
        //viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.setState("profile");
        viewManagerModel.firePropertyChanged();
    }
}
