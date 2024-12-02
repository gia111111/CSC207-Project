package interface_adapter.find;

import data_access.RemoteDataAccessObject;
import entity.Finds;
import interface_adapter.ViewManagerModel;
import use_case.find.FindProfileInputData;
import use_case.find.FindProfilesInputBoundary;
import use_case.find.FindProfilesOutputBoundary;

import java.util.Map;

public class FindProfilesController {

    private final FindProfilesInputBoundary findProfilesUseCase; // Interactor to perform the use case
    private final ViewManagerModel viewManagerModel; // Manages view state
    private final RemoteDataAccessObject remoteDataAccessObject;

    public FindProfilesController(FindProfilesInputBoundary findProfilesUseCase, ViewManagerModel viewManagerModel, RemoteDataAccessObject remoteDataAccessObject) {
        this.findProfilesUseCase = findProfilesUseCase;
        this.viewManagerModel = viewManagerModel;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }

    /**
     * Executes the Find Profiles Use Case.
     *
     *
     */
    public Map<String, Double> findProfiles(Map<String, Double> scores, Map<String, Boolean> matches) {
        final FindProfileInputData findProfileInputData = new FindProfileInputData(scores, matches, remoteDataAccessObject);
        return findProfilesUseCase.execute(findProfileInputData);
    }

//    private void findProfiles (Map<String, Double> scores, Map<String, Boolean> actions) {
//        final
//    }

//    public String getCurrentUserName() {
//        return findProfilesUseCase.execute(findProfilesUseCase).
//    }

    /**
     * Executes the "switch to a specific view" Use Case (e.g., Profile View).
     */
    public void switchToDashBoard() {
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }
    public void handleAction(String otherUserId, String action) {
        System.out.println("Handling action: " + action + " for " + otherUserId);

        // Determine the status based on the action
        boolean isAccepted = "Accept".equals(action);
        // Update Firestore or state using the use case
        remoteDataAccessObject.setRequestStatus(otherUserId, isAccepted);
    }
}