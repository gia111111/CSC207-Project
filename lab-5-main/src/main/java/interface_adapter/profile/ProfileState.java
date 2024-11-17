package interface_adapter.profile;

public class ProfileState {
    private String currentView = "";
    private String errorMessage;

    public String getCurrentView() {
        return currentView;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setCurrentView(String currentView) {
        this.currentView = currentView;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String toString() {
        return "ProfileState{"
                + "currentView='" + currentView + '\''
                + ", errorMessage='" + errorMessage + '\''
                + '}';
    }
}
