package use_case.requests;

public interface RequestsInputBoundary {
    void switchToDashBoardView();
    void accept(RequestsInputData requestsInputData);
    void reject(RequestsInputData requestsInputData);
}
