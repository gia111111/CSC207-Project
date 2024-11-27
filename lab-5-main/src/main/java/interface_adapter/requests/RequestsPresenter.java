package interface_adapter.requests;

import interface_adapter.ViewManagerModel;
import use_case.requests.RequestsOutputBoundary;
import use_case.requests.RequestsOutputData;

public class RequestsPresenter implements RequestsOutputBoundary {

    private final RequestsViewModel requestsViewModel;
    private final ViewManagerModel viewManagerModel;

    public RequestsPresenter(ViewManagerModel viewManagerModel,
                           RequestsViewModel requestsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.requestsViewModel = requestsViewModel;
    }

    @Override
    public void prepareSuccessView(RequestsOutputData response) {
        final RequestsState requestsState = requestsViewModel.getState();
        requestsState.setUsername(response.getMyName());
        this.requestsViewModel.setState(requestsState);
        requestsViewModel.firePropertyChanged();

//        viewManagerModel.setState("");
//        viewManagerModel.firePropertyChanged();
    }

    @Override
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
}





