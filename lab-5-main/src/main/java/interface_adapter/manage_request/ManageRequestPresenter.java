package interface_adapter.manage_request;

import interface_adapter.ViewManagerModel;
import use_case.manageRequest.ManageRequestOutputBoundary;
import use_case.manageRequest.ManageRequestOutputData;

public class ManageRequestPresenter implements ManageRequestOutputBoundary {
    private final ManageRequestViewModel manageRequestViewModel;
    private final ViewManagerModel viewManagerModel;

    public ManageRequestPresenter(ManageRequestViewModel manageRequestViewModel,
                                    ViewManagerModel viewManagerModel) {
            this.manageRequestViewModel = manageRequestViewModel;
            this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(ManageRequestOutputData outputData) {
        final ManageRequestState manageRequestState = manageRequestViewModel.getState();
        this.manageRequestViewModel.setState(manageRequestState);
        manageRequestViewModel.firePropertyChanged();

       // viewManagerModel.setState("dashboard");
    }

    @Override
    public void prepareFailView(String error) {
        final ManageRequestState manageRequestState = manageRequestViewModel.getState();
        manageRequestState.setErrorMessage(error);
        this.manageRequestViewModel.setState(manageRequestState);
        manageRequestViewModel.firePropertyChanged();
    }

    @Override
    public void switchToRequestsView() {
        viewManagerModel.setState("requests");
        viewManagerModel.firePropertyChanged();
    }
}

