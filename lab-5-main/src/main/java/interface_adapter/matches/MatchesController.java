package interface_adapter.matches;

import interface_adapter.ViewManagerModel;

public class MatchesController {
    private final ViewManagerModel viewManagerModel;

    public MatchesController(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    public void switchToDashboard() {
        // Switch to the dashboard view
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }
}
