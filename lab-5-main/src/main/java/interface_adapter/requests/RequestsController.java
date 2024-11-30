package interface_adapter.requests;

import interface_adapter.ViewManagerModel;
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

    /**
     * Return a map with requesters and status.
     *
     * @param username The username of the current user.
     */
    public HashMap<String,Double> execute(String username){
        // RequestsInputData requestsInputData = new RequestsInputData(username);
        HashMap<String, Double> scoresMap = requestsInputBoundary.execute(username);
//        viewManagerModel.setState("requests");
//        viewManagerModel.firePropertyChanged();
        return scoresMap;
    }




    public HashMap<String,Double> getActionMap(String username){
        HashMap<String, Double> scoresMap = requestsInputBoundary.execute(username);
//        viewManagerModel.setState("requests");
//        viewManagerModel.firePropertyChanged();
        return scoresMap;
    }

    public HashMap<String, Boolean>  accept(String myName, String partnerName){
        final RequestsInputData requestsInputData = new RequestsInputData(myName, partnerName);
        return requestsInputBoundary.accept(requestsInputData);

    }

    public HashMap<String, Boolean> reject(String myname, String partnerName) {
        final RequestsInputData requestsInputData = new RequestsInputData(myname, partnerName);
        return requestsInputBoundary.reject(requestsInputData);
    }


}
