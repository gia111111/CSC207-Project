package interface_adapter.home;

import interface_adapter.ViewModel;

/**
 * The ViewModel for the Home Page View.
 */
public class HomePageViewModel extends ViewModel<String>{
    // Define labels for the buttons and title
    public static final String TITLE_LABEL = "Welcome to Code & Cupid";
    public static final String LOGIN_BUTTON_LABEL = "Log In";
    public static final String SIGNUP_BUTTON_LABEL = "Sign Up";
    public static final String RESET_PASSWORD_BUTTON_LABEL = "Reset Password";
    public static final String DASHBOARD_BUTTON_LABEL = "Dashboard";

    /**
     * Constructor initializes the view model with a default state.
     */
    public HomePageViewModel() {
        super("home");
        setState("");
    }
}
