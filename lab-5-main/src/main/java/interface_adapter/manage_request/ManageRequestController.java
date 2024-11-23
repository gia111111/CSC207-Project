package interface_adapter.manage_request;

import interface_adapter.ViewManagerModel;
import use_case.manageRequest.ManageRequestInputBoundary;
import use_case.manageRequest.ManageRequestInputData;

public class ManageRequestController {
    private final ManageRequestInputBoundary manageRequestInputBoundary;
    private final ManageRequestViewModel manageRequestViewModel;
    private final ViewManagerModel viewManagerModel;

    public ManageRequestController(ManageRequestInputBoundary manageRequestInputBoundary,
                                   ManageRequestViewModel manageRequestViewModel,
                                   ViewManagerModel viewManagerModel){
        this.manageRequestInputBoundary = manageRequestInputBoundary;
        this.manageRequestViewModel = manageRequestViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void accept(String name, double scores, Boolean status){
        final ManageRequestInputData manageRequestInputData = new ManageRequestInputData(name,scores,status);
        manageRequestInputBoundary.accept(manageRequestInputData);
    }

    public void reject(String name, double scores, Boolean status){
        final ManageRequestInputData manageRequestInputData = new ManageRequestInputData(name,scores,status);
        manageRequestInputBoundary.reject(manageRequestInputData);
    }

    public void switchToRequestsView(){
        viewManagerModel.setState("requests");
        viewManagerModel.firePropertyChanged();
    }



}
