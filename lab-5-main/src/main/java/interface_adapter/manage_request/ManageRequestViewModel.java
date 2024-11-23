package interface_adapter.manage_request;

import interface_adapter.ViewModel;

public class ManageRequestViewModel extends ViewModel<ManageRequestState> {

    public ManageRequestViewModel(String viewName) {
            super("manage request");
            setState(new ManageRequestState());
        }

    }
