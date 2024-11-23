package interface_adapter.requests;

import interface_adapter.ViewManagerModel;
import use_case.requests.RequestsInputBoundary;
import use_case.requests.RequestsInputData;


public class RequestsController {
    private final ViewManagerModel viewManagerModel;
    private final RequestsViewModel requestsViewModel;
    private final RequestsInputBoundary requestsInputBoundary;

    public RequestsController(ViewManagerModel viewManagerModel, RequestsViewModel requestsViewModel,
                              RequestsInputBoundary requestsInputBoundary) {

        this.viewManagerModel = viewManagerModel;
        this.requestsViewModel = requestsViewModel;
        this.requestsInputBoundary = requestsInputBoundary;

    }

    public void execute(String requestName){
        final RequestsInputData requestsInputData = new RequestsInputData(requestName);
        requestsInputBoundary.execute(requestsInputData);

    }


    public void switchToDashboard() {
        // Switch to the dashboard view
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }
}
