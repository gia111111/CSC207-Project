package interface_adapter.requests;

import interface_adapter.ViewManagerModel;


public class RequestsController {
    private final ViewManagerModel viewManagerModel;

    public RequestsController(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    public void switchToDashboard() {
        // Switch to the dashboard view
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }
}
