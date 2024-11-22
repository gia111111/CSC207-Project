package interface_adapter.editprofile;

import interface_adapter.ViewModel;

/**
 * ViewModel for the EditProfile Use Case.
 */
public class EditProfileViewModel extends ViewModel<EditProfileState> {

    public EditProfileViewModel(String viewName) {
        super("edit profile");
        setState(new EditProfileState());
    }

}
