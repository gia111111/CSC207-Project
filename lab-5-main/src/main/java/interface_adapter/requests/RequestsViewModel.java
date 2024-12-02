package interface_adapter.requests;

import interface_adapter.ViewModel;
import interface_adapter.find.FindState;


public class RequestsViewModel extends ViewModel <RequestsState> {
    public static final String VIEW_PROFILE_BUTTON_LABEL = "View Profile";
    public static final String BACK_BUTTON_LABEL = "Back";
    public static final String TITLE_LABEL = "Requests";
//    public static final String USERNAME_LABEL = "user"


    public RequestsViewModel() {
        super("requests");
        setState(new RequestsState());
    }

    /**
     * Sets an error message in the state.
     *
     * @param errorMessage The error message to display.
     */
    public void setErrorMessage(String errorMessage) {
        RequestsState currentState = getState();
        currentState.setErrorMessage(errorMessage);
        firePropertyChanged(); // Notify UI components of state changes
    }

}
