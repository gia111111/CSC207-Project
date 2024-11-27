package interface_adapter.requests;

import interface_adapter.ViewManagerModel;
import use_case.login.LoginInputBoundary;
import use_case.requests.RequestsInputBoundary;
import use_case.requests.RequestsInputData;

import java.util.HashMap;


public class RequestsController {
    private final ViewManagerModel viewManagerModel;
    private final RequestsInputBoundary requestsInputBoundary;

    public RequestsController(ViewManagerModel viewManagerModel, RequestsInputBoundary requestsInputBoundary) {
        this.viewManagerModel = viewManagerModel;
        this.requestsInputBoundary = requestsInputBoundary;
    }

    public void switchToDashboard() {
        // Switch to the dashboard view
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }

    public void accept(String myName, String partnerName){
        final RequestsInputData requestsInputData = new RequestsInputData(myName, partnerName);
        requestsInputBoundary.accept(requestsInputData);

    }

//    public void reject(String username, HashMap<String, Boolean> finds){
//        final RequestsInputData requestsInputData = new RequestsInputData(username,finds);
//        requestsInputBoundary.reject(requestsInputData);
//
//    }

}
