package interface_adapter.change_password;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomePageState;
import interface_adapter.home.HomePageViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.signup.SignupState;
import use_case.change_password.ChangePasswordOutputBoundary;
import use_case.change_password.ChangePasswordOutputData;

/**
 * The Presenter for the Change Password Use Case.
 */
public class ChangePasswordPresenter implements ChangePasswordOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedInViewModel;
    private final HomePageViewModel homePageViewModel;

    public ChangePasswordPresenter(ViewManagerModel viewManagerModel,LoggedInViewModel loggedInViewModel,
                                   HomePageViewModel homePageViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.homePageViewModel = homePageViewModel;
    }

    @Override
    public void prepareSuccessView(ChangePasswordOutputData outputData) {
        // currently there isn't anything to change based on the output data,
        // since the output data only contains the username, which remains the same.
        // We still fire the property changed event, but just to let the view know that
        // it can alert the user that their password was changed successfully..
//        loggedInViewModel.firePropertyChanged("password");
        // On success, switch to the homepage view.;

        // On success, switch to the login view.
        final HomePageState homePageState = homePageViewModel.getState();
        // homePageState.setUsername(response.getUsername());
        this.homePageViewModel.setState(homePageState);
        homePageViewModel.firePropertyChanged();

        this.viewManagerModel.setState(homePageViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // note: this use case currently can't fail
       final LoggedInState changePasswordState = loggedInViewModel.getState();
       // changepasswordState.setUserNotExistError(error);
       changePasswordState.setPasswordError(error);
       loggedInViewModel.firePropertyChanged();
    }

    public void switchToHomePageView() {
        viewManagerModel.setState(homePageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
