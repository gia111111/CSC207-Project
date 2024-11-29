package interface_adapter.requests;

import interface_adapter.ViewManagerModel;
import use_case.requests.RequestsInputBoundary;
import use_case.requests.RequestsInputData;


public class RequestsController {
    private final ViewManagerModel viewManagerModel;
    private final RequestsInputBoundary requestsInputBoundary;

    public RequestsController(ViewManagerModel viewManagerModel, RequestsInputBoundary requestsInputBoundary) {
        this.viewManagerModel = viewManagerModel;
        this.requestsInputBoundary = requestsInputBoundary;
    }

    /**
     * Executes the Request Profiles Use Case.
     *
     * @param username The username of the current user.
     */
    public void execute(String username){
        RequestsInputData requestsInputData = new RequestsInputData(username);
        requestsInputBoundary.execute(requestsInputData);
    };


    public void switchToDashboard() {
        // Switch to the dashboard view
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }
}
