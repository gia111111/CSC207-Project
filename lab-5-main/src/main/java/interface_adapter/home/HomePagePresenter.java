package interface_adapter.home;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangePasswordViewModel;
import interface_adapter.change_password.ChangedPasswordState;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.home.HomeOutputBoundary;
import use_case.home.HomeOutputData;

public class HomePagePresenter implements HomeOutputBoundary{

    private final HomePageViewModel homeViewModel;
    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private final ChangePasswordViewModel changePasswordViewModel;
    private final ViewManagerModel viewManagerModel;

    public HomePagePresenter(HomePageViewModel homeViewModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, ChangePasswordViewModel changePasswordViewModel, ViewManagerModel viewManagerModel) {
        this.homeViewModel = homeViewModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.changePasswordViewModel = changePasswordViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(HomeOutputData outputData) {
        // Determine the type of action based on data in HomeOutputData
        String actionType = outputData.getActionType();  // Assume actionType is a field like "login", "signup", or "resetPassword"

        switch (actionType) {
            case "login":
                // Set up the login view state with any relevant data from the response
                final LoginState loginState = loginViewModel.getState();
                loginState.setUsername(outputData.getUsername());
                loginViewModel.setState(loginState);
                loginViewModel.firePropertyChanged();

                // Update ViewManagerModel to switch to the login view
                viewManagerModel.setState("login");
                break;

            case "signup":
                // Set up the signup view state with any relevant data from the response
                final SignupState signupState = signupViewModel.getState();
                signupViewModel.setState(signupState);
                signupViewModel.firePropertyChanged();

                // Update ViewManagerModel to switch to the signup view
                viewManagerModel.setState("signup");
                break;

            case "resetPassword":
                // Set up the reset password view state with any relevant data from the response
                final ChangedPasswordState resetPasswordState = changePasswordViewModel.getState();
                changePasswordViewModel.setState(resetPasswordState);
                changePasswordViewModel.firePropertyChanged();

                // Update ViewManagerModel to switch to the reset password view
                viewManagerModel.setState("reset password");
                break;

            default:
                throw new IllegalArgumentException("Unknown action type: " + actionType);
        }

        // Notify the ViewManagerModel to update the UI
        viewManagerModel.firePropertyChanged();
    }


    @Override
    public void prepareFailView(String errorMessage) {
        final HomePageState homePageState = homeViewModel.getState();
        // Set an error message on the view model and update the state
        homePageState.setErrorMessage(errorMessage);
        // Notify observers of the error state
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToLoginView() {
        viewManagerModel.setState("login");
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void switchToResetPasswordView() {
        viewManagerModel.setState("reset password");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToSignupView() {
        viewManagerModel.setState("sign up");
        viewManagerModel.firePropertyChanged();
    }
}
