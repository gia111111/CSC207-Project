package use_case.home;

/**
 * An interface for the Home use case.
 */
public class HomeInteractor implements HomeInputBoundary {
    private final HomeOutputBoundary userPresenter;

    public HomeInteractor(HomeOutputBoundary outputBoundary) {
        this.userPresenter = outputBoundary;
    }

    @Override
    public void switchToLoginView() {
        userPresenter.switchToLoginView();
    }

    @Override
    public void switchToSignupView() {
        userPresenter.switchToSignupView();
    }

    @Override
    public void switchToResetPasswordView() {
        userPresenter.switchToResetPasswordView();
    }
}
