package use_case.manageRequest;

import entity.Match;
import entity.Request;

public class ManageRequestInteractor implements ManageRequestInputBoundary{
    private final ManageRequestUserDataAccessInterface requestDataAccessObject;
    private final ManageRequestOutputBoundary requestPresenter;
    // private final ManageRequestInputData inputData;

    public ManageRequestInteractor(ManageRequestUserDataAccessInterface manageRequestUserDataAccessInterface,
                                   ManageRequestOutputBoundary manageRequestOutputBoundary,
                                   ManageRequestInputData inputData) {
        this.requestDataAccessObject = manageRequestUserDataAccessInterface;
        this.requestPresenter = manageRequestOutputBoundary;
        // this.inputData = inputData;
    }

    @Override
    public void accept(ManageRequestInputData inputData) {
        inputData.setStatus(true);
        final Match match = new Match(inputData.getRequestName(),
                requestDataAccessObject.getContactMethod(inputData.getRequestName()),
                requestDataAccessObject.getContactInfo(inputData.getRequestName()));
        requestDataAccessObject.save(match);

        final ManageRequestOutputData manageRequestOutputData =
                new ManageRequestOutputData(inputData.getRequestName(), false, true);
        requestPresenter.prepareSuccessView(manageRequestOutputData);
    }

    @Override
    public void reject(ManageRequestInputData inputData) {
        inputData.setStatus(false);
        Request request = new Request(inputData.getRequestName(), inputData.getScores(), inputData.getStatus());
        requestDataAccessObject.delete(request);
        final ManageRequestOutputData manageRequestOutputData =
                new ManageRequestOutputData(inputData.getRequestName(), false, false);
        requestPresenter.prepareSuccessView(manageRequestOutputData);
    }

    @Override
    public void switchToRequestsView() {
        requestPresenter.switchToRequestsView();
    }
}





