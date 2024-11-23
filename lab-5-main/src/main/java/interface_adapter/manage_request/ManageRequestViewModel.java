package interface_adapter.manage_request;

import interface_adapter.ViewModel;

public class ManageRequestViewModel extends ViewModel<ManageRequestState> {
    public static final String BACK_BUTTON_LABEL = "Back";
    public static final String ACCEPT_BUTTON_LABEL = "Accept";
    public static final String REJECT_BUTTON_LABEL = "Reject";


    public ManageRequestViewModel() {
            super("manage request");
            setState(new ManageRequestState());
        }

    }
