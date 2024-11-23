package use_case.requests;

public class RequestsInteractor implements RequestsInputBoundary{
    private final RequestsOutputBoundary userPresenter;

    public RequestsInteractor(RequestsOutputBoundary outputBoundary) {

        this.userPresenter = outputBoundary;
    }

    @Override
    public void execute(RequestsInputData requestInputData) {
        userPresenter.switchToManageRequestView(requestInputData);
    }


    @Override
    public void switchToDashBoardView(){
        userPresenter.switchToDashBoardView();
    }


}
