package interface_adapter.dashboard;

import interface_adapter.ViewModel;
import interface_adapter.profile.ProfileState;

public class DashBoardViewModel extends ViewModel<DashBoardState> {
    // Define labels for the dashboard buttons and title
    public static final String TITLE_LABEL = "Dashboard";
    public static final String PROFILE_BUTTON_LABEL = "My Profile";
    public static final String REQUESTS_BUTTON_LABEL = "Requests";
    public static final String COMPATIBILITY_BUTTON_LABEL = "Find";
    public static final String MATCHES_BUTTON_LABEL = "Matches";
    public static final String LOGOUT_BUTTON_LABEL = "Logout";

    public DashBoardViewModel() {
        super("dashboard");
        setState(new DashBoardState());
    }
}
