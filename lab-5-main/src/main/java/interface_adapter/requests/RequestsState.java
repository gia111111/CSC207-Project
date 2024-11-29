package interface_adapter.requests;

import java.util.Map;

public class RequestsState {
    private Map<String, Double> scoresMap; // Username -> Compatibility score
    private Map<String, Boolean> actionsToRequests; // Username -> Accepted/Rejected
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public Map<String, Boolean> getActionsToRequests() {
        return actionsToRequests;
    }

    public Map<String, Double> getScoresMap() {
        return scoresMap;
    }
}
