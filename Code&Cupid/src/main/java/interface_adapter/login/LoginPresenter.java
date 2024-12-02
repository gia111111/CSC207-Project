package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangePasswordViewModel;
import interface_adapter.change_password.ChangedPasswordState;
import interface_adapter.dashboard.DashBoardViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final ChangePasswordViewModel changePasswordViewModel;
    private final ViewManagerModel viewManagerModel;
    private final DashBoardViewModel dashBoardViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          ChangePasswordViewModel changePasswordViewModel,
                          LoginViewModel loginViewModel, DashBoardViewModel dashBoardViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.changePasswordViewModel = changePasswordViewModel;
        this.loginViewModel = loginViewModel;
        this.dashBoardViewModel = dashBoardViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        final ChangedPasswordState changedPasswordState = changePasswordViewModel.getState();
        changedPasswordState.setUsername(response.getUsername());
        this.changePasswordViewModel.setState(changedPasswordState);
        this.changePasswordViewModel.firePropertyChanged();

        this.viewManagerModel.setState("dashboard");
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final LoginState loginState = loginViewModel.getState();
        loginState.setLoginError(error);
        loginViewModel.firePropertyChanged();
    }

}
