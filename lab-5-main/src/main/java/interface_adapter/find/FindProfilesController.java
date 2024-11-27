package interface_adapter.find;

import entity.Finds;
import interface_adapter.ViewManagerModel;
import use_case.find.FindProfilesInputBoundary;
import use_case.find.FindProfilesOutputBoundary;

public class FindProfilesController {

    private final FindProfilesInputBoundary findProfilesUseCase; // Interactor to perform the use case
    private final ViewManagerModel viewManagerModel; // Manages view state

    public FindProfilesController(FindProfilesInputBoundary findProfilesUseCase, ViewManagerModel viewManagerModel) {
        this.findProfilesUseCase = findProfilesUseCase;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Executes the Find Profiles Use Case.
     *
     * @param currentUsername The username of the current user.
     */
    public void findProfiles(String currentUsername) {
        // Trigger the interactor to execute the find profiles use case
        findProfilesUseCase.execute(currentUsername);

        // Optionally update the view state or handle navigation
        viewManagerModel.setState("find");
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Executes the "switch to a specific view" Use Case (e.g., Profile View).
     */
    public void switchToDashBoard() {
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }
}