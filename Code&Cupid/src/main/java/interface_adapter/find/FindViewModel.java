package interface_adapter.find;

import interface_adapter.ViewModel;
import interface_adapter.dashboard.DashBoardState;

import java.util.Map;

public class FindViewModel extends ViewModel<FindState> {
    // Labels for the FindView buttons or title
    public static final String TITLE_LABEL = "Find Compatibility";

    public FindViewModel() {
        super("find");
        setState(new FindState());
    }

    /**
     * Updates the scores in the state.
     *
     * @param scores Map of usernames to their compatibility scores.
     */
    public void updateScores(Map<String, Double> scores) {
        FindState currentState = getState();
        currentState.setScores(scores);
        firePropertyChanged(); // Notify UI components of state changes
    }

    /**
     * Updates the actions (accepted/rejected) in the state.
     *
     * @param username The username whose action is being updated.
     * @param accepted True if accepted, False if rejected.
     */
    public void updateAction(String username, boolean accepted) {
        FindState currentState = getState();
        currentState.getActions().put(username, accepted);
        firePropertyChanged(); // Notify UI components of state changes
    }

    /**
     * Sets an error message in the state.
     *
     * @param errorMessage The error message to display.
     */
    public void setErrorMessage(String errorMessage) {
        FindState currentState = getState();
        currentState.setErrorMessage(errorMessage);
        firePropertyChanged(); // Notify UI components of state changes
    }
}
