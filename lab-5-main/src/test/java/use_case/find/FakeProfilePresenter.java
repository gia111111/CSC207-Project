package use_case.find;

import use_case.createProfile.CreateProfileOutputData;

public class FakeProfilePresenter {
    private String successMessage;
    private String errorMessage;

    public void prepareSuccessView(CreateProfileOutputData data) {
        this.successMessage = "Success: " + data.getName();
    }

    public void prepareFailView(String errorMessage) {
        this.errorMessage = errorMessage;
    }

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
