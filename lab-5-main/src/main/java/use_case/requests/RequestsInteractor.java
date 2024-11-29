package use_case.requests;

import use_case.home.HomeOutputBoundary;

import java.util.HashMap;

public class RequestsInteractor implements RequestsInputBoundary{
    private final RequestsOutputBoundary userPresenter;
    private final RequestsDataAccessInterface requestsDataAccessInterface;

    public RequestsInteractor(RequestsOutputBoundary outputBoundary, RequestsDataAccessInterface requestsDataAccessInterface) {
        this.userPresenter = outputBoundary;
        this.requestsDataAccessInterface = requestsDataAccessInterface;
    }

    @Override
    public void switchToDashBoardView(){
        userPresenter.switchToDashBoardView();
    }

    @Override
    public HashMap<String, Double> execute(RequestsInputData requestsInputData){


    }

}
