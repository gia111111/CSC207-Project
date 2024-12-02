package interface_adapter.change_password;

import interface_adapter.ViewModel;

/**
 * The View Model for the Logged In View.
 */
public class ChangePasswordViewModel extends ViewModel<ChangedPasswordState> {

    public ChangePasswordViewModel() {
        super("logged in");
        setState(new ChangedPasswordState());
    }

}
