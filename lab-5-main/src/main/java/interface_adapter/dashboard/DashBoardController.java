package interface_adapter.dashboard;

import interface_adapter.ViewManagerModel;

public class DashBoardController {
    private final ViewManagerModel viewManagerModel;

    public DashBoardController(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    public void switchToLogout() {
        // Switch to the homepage view
        viewManagerModel.setState("home");
        viewManagerModel.firePropertyChanged();
    }

    public void switchToProfile() {
        viewManagerModel.setState("profile");
        viewManagerModel.firePropertyChanged();
    }

    public void switchToMatchView() {
        viewManagerModel.setState("matches");
        viewManagerModel.firePropertyChanged();
    }
    public void switchToFindView() {
        viewManagerModel.setState("find");
        viewManagerModel.firePropertyChanged();
    }

    public void switchToRequestsView(){
        viewManagerModel.setState("requests");
        viewManagerModel.firePropertyChanged();

    }


}
