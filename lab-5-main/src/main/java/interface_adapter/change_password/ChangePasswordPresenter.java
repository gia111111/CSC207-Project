package interface_adapter.change_password;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.changePassword.ChangePasswordOutputBoundary;
import use_case.changePassword.ChangePasswordOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class ChangePasswordPresenter implements ChangePasswordOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final ChangePasswordViewModel changePasswordViewModel;
    private final LoginViewModel loginViewModel;

    public ChangePasswordPresenter(ChangePasswordViewModel changePasswordViewModel, ViewManagerModel viewManagerModel,
                                   LoginViewModel loginViewModel) {
        this.changePasswordViewModel = changePasswordViewModel;
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(ChangePasswordOutputData outputData) {
        // currently there isn't anything to change based on the output data,
        // since the output data only contains the username, which remains the same.
        // We still fire the property changed event, but just to let the view know that
        // it can alert the user that their password was changed successfully..
//        loggedInViewModel.firePropertyChanged("password");
        // On success, switch to the homepage view.;

        // Switch to the login view after successful password change

        final LoginState logInState = loginViewModel.getState();
        logInState.setUsername(outputData.getUsername());
        this.loginViewModel.setState(logInState);
        this.loginViewModel.firePropertyChanged();

        this.viewManagerModel.setState("log in");
        this.viewManagerModel.firePropertyChanged();
    }



    @Override
    public void prepareFailView(String error) {
       final ChangedPasswordState changePasswordState = changePasswordViewModel.getState();
       // changepasswordState.setUserNotExistError(error);

       changePasswordState.setPasswordError(error);
       changePasswordViewModel.firePropertyChanged();
    }
}
