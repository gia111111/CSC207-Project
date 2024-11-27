package use_case.requests;

import entity.User;
import use_case.home.HomeOutputBoundary;
import use_case.signup.SignupOutputData;

public class RequestsInteractor implements RequestsInputBoundary {
    private final RequestsOutputBoundary userPresenter;
    private final RequestsDataAccessInterface dataAccessInterface;

    public RequestsInteractor(RequestsOutputBoundary outputBoundary, RequestsDataAccessInterface dataAccessInterface) {

        this.userPresenter = outputBoundary;
        this.dataAccessInterface = dataAccessInterface;
    }

    @Override
    public void switchToDashBoardView() {
        userPresenter.switchToDashBoardView();
    }

    @Override
    public void accept(RequestsInputData inputData) {
        String myName = inputData.getMyName();
        String partnerName = inputData.getPartnerName();

        // dataAccessInterface.saveMatches(myName, partnerName);
        dataAccessInterface.updateSatus(myName, partnerName, true);

        final RequestsOutputData requestsOutputData = new RequestsOutputData(myName, partnerName, false);
        userPresenter.prepareSuccessView(requestsOutputData);

//        final SignupOutputData signupOutputData = new SignupOutputData(user.getName(), false);
//        userPresenter.prepareSuccessView(signupOutputData);
    }

    @Override
    public void reject(RequestsInputData requestsInputData) {
        String myName = requestsInputData.getMyName();
        String partnerName = requestsInputData.getPartnerName();

        dataAccessInterface.updateSatus(myName, partnerName, false);

        final RequestsOutputData requestsOutputData = new RequestsOutputData(myName, partnerName, false);
        userPresenter.prepareSuccessView(requestsOutputData);


    }
}