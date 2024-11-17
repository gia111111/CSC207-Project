package interface_adapter.profile;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class ProfileViewModel extends ViewModel<ProfileState> {

    public ProfileViewModel() {
        super("log in");
        setState(new ProfileState());
    }
}
