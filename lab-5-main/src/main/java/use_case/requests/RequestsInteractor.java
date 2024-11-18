package use_case.requests;

import use_case.home.HomeOutputBoundary;

public class RequestsInteractor implements RequestsInputBoundary{
    private final RequestsOutputBoundary userPresenter;

    public RequestsInteractor(RequestsOutputBoundary outputBoundary) {

        this.userPresenter = outputBoundary;
    }

    @Override
    public void switchToDashBoardView(){
        userPresenter.switchToDashBoardView();
    }

    @Override
    public void switchToViewProfileView(){
        userPresenter.switchToViewProfileView();
    }

}
