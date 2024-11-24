package use_case.accessFind;

public interface AccessFindOutputBoundary {

    void prepareSuccessView(AccessFindOutputData outputData);

    void prepareFailView(String errorMessage);

    void switchToViewProfileView();

    void switchToDashboardView();
}
