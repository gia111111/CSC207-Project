package interface_adapter.home;

/**
 * The state for the Home Page View Model.
 */
public class HomePageState {
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

    @Override
    public String toString() {
        return "HomePageState{"
                + "currentView='" + currentView + '\''
                + ", errorMessage='" + errorMessage + '\''
                + '}';
    }
}
