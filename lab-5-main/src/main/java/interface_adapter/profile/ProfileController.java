package interface_adapter.profile;

import interface_adapter.ViewManagerModel;

public class ProfileController {
    private final ViewManagerModel viewManagerModel;

    public ProfileController(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    public void handleCancel() {
        // Switch back to the homepage or another view
        viewManagerModel.setState("home");
        viewManagerModel.firePropertyChanged();
    }

    public void save_success() {
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }

//    void switchToDashboardView(){
//
//    }

}
