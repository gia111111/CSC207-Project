package interface_adapter.find;

import data_access.RemoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.find.FindInputData;
import use_case.find.FindInputBoundary;

import java.util.Map;

public class FindController {

    private final FindInputBoundary findProfilesUseCase; // Interactor to perform the use case
    private final ViewManagerModel viewManagerModel; // Manages view state
    private final RemoteDataAccessObject remoteDataAccessObject;

    public FindController(FindInputBoundary findProfilesUseCase, ViewManagerModel viewManagerModel, RemoteDataAccessObject remoteDataAccessObject) {
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
        final FindInputData findInputData = new FindInputData(scores, matches, remoteDataAccessObject);
        return findProfilesUseCase.execute(findInputData);
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
        boolean isAccepted = "Like".equals(action);
        // Update Firestore or state using the use case
        remoteDataAccessObject.setRequestStatus(otherUserId, isAccepted);
    }
}