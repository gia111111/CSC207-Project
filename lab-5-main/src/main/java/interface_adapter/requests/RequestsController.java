package interface_adapter.requests;

import data_access.RemoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.requests.RequestsInputBoundary;
import use_case.requests.RequestsInputData;

import java.util.HashMap;


public class RequestsController {
    private final ViewManagerModel viewManagerModel;
    private final RequestsInputBoundary requestsInputBoundary;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public RequestsController(ViewManagerModel viewManagerModel, RequestsInputBoundary requestsInteractor,
                              RemoteDataAccessObject remoteDataAccessObject) {
        this.viewManagerModel = viewManagerModel;
        this.requestsInputBoundary = requestsInteractor;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }

    public void switchToDashboard() {
        // Switch to the dashboard view
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Return a map with requesters and scores.
     */
    public HashMap<String,Double> execute(){
         System.out.println("Controller execute");
         final RequestsInputData requestsInputData = new RequestsInputData(remoteDataAccessObject, null);
         return requestsInputBoundary.execute(requestsInputData);
//        viewManagerModel.setState("requests");
//        viewManagerModel.firePropertyChanged();
//        return scoresMap;
    }

    public HashMap<String, Boolean>  accept(String partnerName){
        final RequestsInputData requestsInputData = new RequestsInputData(remoteDataAccessObject,partnerName);
        return requestsInputBoundary.accept(requestsInputData);

    }

    public HashMap<String, Boolean> reject(String partnerName) {
        final RequestsInputData requestsInputData = new RequestsInputData(remoteDataAccessObject,partnerName);
        return requestsInputBoundary.reject(requestsInputData);
    }


}
