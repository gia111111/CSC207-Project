package interface_adapter.editprofile;

import interface_adapter.ViewManagerModel;
import use_case.editprofile.EditProfileOutputBoundary;
import use_case.editprofile.EditProfileOutputData;

/**
 * Presenter for the EditProfile Use Case.
 */
public class EditProfilePresenter implements EditProfileOutputBoundary {
    private final EditProfileViewModel editProfileViewModel;
    private final ViewManagerModel viewManagerModel;

    public EditProfilePresenter(EditProfileViewModel editProfileViewModel,
                                ViewManagerModel viewManagerModel) {
        this.editProfileViewModel = editProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(EditProfileOutputData outputData) {
        final EditProfileState editProfileState = editProfileViewModel.getState();
        this.editProfileViewModel.setState(editProfileState);
        editProfileViewModel.firePropertyChanged();

        viewManagerModel.setState("dashboard");
    }

    @Override
    public void prepareFailView(String error) {
        final EditProfileState editProfileState = editProfileViewModel.getState();
        editProfileState.setErrorMessage(error);
        this.editProfileViewModel.setState(editProfileState);
        editProfileViewModel.firePropertyChanged();
    }

    @Override
    public void switchToDashBroadView() {
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }
}
