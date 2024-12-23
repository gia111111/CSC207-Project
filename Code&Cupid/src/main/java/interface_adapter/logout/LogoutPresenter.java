package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangedPasswordState;
import interface_adapter.change_password.ChangePasswordViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.logout.LogoutOutputBoundary;
import use_case.logout.LogoutOutputData;

/**
 * The Presenter for the Logout Use Case.
 */
public class LogoutPresenter implements LogoutOutputBoundary {

    private final ChangePasswordViewModel changePasswordViewModel;
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;

    // Constructor with proper assignment to instance variables
    public LogoutPresenter(ViewManagerModel viewManagerModel,
                           ChangePasswordViewModel changePasswordViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.changePasswordViewModel = changePasswordViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LogoutOutputData response) {
        // Step 1: Update the LoggedInState
        // Get the LoggedInState from the LoggedInViewModel
        ChangedPasswordState changedPasswordState = changePasswordViewModel.getState();

        // Step 2: Set the username in the state to an empty string (user is logged out)
        changedPasswordState.setUsername("");

        // Step 3: Update the LoggedInViewModel with the modified state
        changePasswordViewModel.setState(changedPasswordState);

        // Step 4: Fire property change to update the view
        changePasswordViewModel.firePropertyChanged();

        // Step 5: Update the LoginState
        // Get the LoginState from the LoginViewModel
        LoginState loginState = loginViewModel.getState();

        // Step 6: Set the username and password in the state to empty strings (clear them)
        loginState.setUsername("");
        loginState.setPassword("");

        // Step 7: Update the LoginViewModel with the modified state
        loginViewModel.setState(loginState);

        // Step 8: Fire property change to update the view
        loginViewModel.firePropertyChanged();

        // Step 9: Switch to the login view using the ViewManagerModel
        this.viewManagerModel.setState(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // No need to implement any action here, as logout is assumed to be successful
        // (Note: It's reasonable to assume logout won't fail unless there's a system error)
    }
}
