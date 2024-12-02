package use_case.profile;

import use_case.createProfile.CreateProfileOutputBoundary;
import use_case.createProfile.CreateProfileOutputData;

public class FakeProfilePresenter implements CreateProfileOutputBoundary {
    private String successMessage;
    private String errorMessage;

    @Override
    public void prepareSuccessView(CreateProfileOutputData data) {
        this.successMessage = "Success: " + data.getName();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void switchToDashBoardView() {
        // Fake implementation, do nothing
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
