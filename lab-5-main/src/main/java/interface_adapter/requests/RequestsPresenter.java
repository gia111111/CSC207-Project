package interface_adapter.requests;

import interface_adapter.ViewManagerModel;
import interface_adapter.profile.ProfileState;
import interface_adapter.profile.ProfileViewModel;
import use_case.requests.RequestsInputData;
import use_case.requests.RequestsOutputBoundary;
import use_case.requests.RequestsOutputData;

public class RequestsPresenter implements RequestsOutputBoundary {
    private final RequestsViewModel requestsViewModel;
    private final ViewManagerModel viewManagerModel;

    public RequestsPresenter(RequestsViewModel requestsViewModel, ViewManagerModel viewManagerModel) {
        this.requestsViewModel = requestsViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * If successful, switch to the manage request view.
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(RequestsOutputData outputData) {
        final RequestsState requestsState = requestsViewModel.getState();
        this.requestsViewModel.setState(requestsState);
        requestsViewModel.firePropertyChanged();

        viewManagerModel.setState("manage request ");
    }

    public void prepareFailView(String error) {
        final RequestsState requestsState = requestsViewModel.getState();
        requestsState.setErrorMessage(error);
        requestsViewModel.firePropertyChanged();
    }

    @Override
    public void switchToDashBoardView() {
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();


    }

    @Override
    public void switchToManageRequestView(RequestsInputData requestsInputData){
        viewManagerModel.setState("manage request");
        viewManagerModel.firePropertyChanged();

}

}
