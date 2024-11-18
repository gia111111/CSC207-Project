package interface_adapter.requests;

import interface_adapter.ViewModel;


public class RequestsViewModel extends ViewModel <RequestsState> {
    public static final String VIEW_PROFILE_BUTTON_LABEL = "View Profile";
    public static final String BACK_BUTTON_LABEL = "Back";


    public RequestsViewModel() {
        super("sign up");
        setState(new RequestsState());
    }

}
