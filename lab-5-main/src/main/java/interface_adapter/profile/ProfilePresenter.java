package interface_adapter.profile;

import interface_adapter.ViewManagerModel;
import use_case.createProfile.CreateProfileOutputBoundary;
import use_case.createProfile.CreateProfileOutputData;


/**
 * The Presenter for the Create Profile Use Case.
 */
public class ProfilePresenter implements CreateProfileOutputBoundary {

    private final ProfileViewModel profileViewModel;
    private final ViewManagerModel viewManagerModel;

    public ProfilePresenter(ProfileViewModel profileViewModel, ViewManagerModel viewManagerModel) {
        this.profileViewModel = profileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * If successful, switch to the dashboard view.
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(CreateProfileOutputData outputData) {
        final ProfileState profileState = profileViewModel.getState();
        this.profileViewModel.setState(profileState);
        profileViewModel.firePropertyChanged();

        viewManagerModel.setState("dashboard");
    }

    public void prepareFailView(String error) {
        final ProfileState profileState = profileViewModel.getState();
        profileState.setErrorMessage(error);
        profileViewModel.firePropertyChanged();
    }

    @Override
    public void switchToDashBoardView() {

    }
}
