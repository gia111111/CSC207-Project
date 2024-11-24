package use_case.accessFind;

public class AccessFindInteractor implements AccessFindInputBoundary{
    private final AccessFindOutputBoundary userPresenter;

    public AccessFindInteractor(AccessFindOutputBoundary userPresenter) {
        this.userPresenter = userPresenter;
    }

    @Override
    public void switchToDashboardView() {
        userPresenter.switchToDashboardView();
    }

    @Override
    public void switchToViewProfileView() {
        userPresenter.switchToViewProfileView();
    }
}
