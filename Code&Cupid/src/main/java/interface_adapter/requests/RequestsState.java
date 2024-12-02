package interface_adapter.requests;

import java.util.HashMap;
import java.util.Map;

public class RequestsState {
    private String currentUserName = "";
    private HashMap<String, Double> scoresMap; // Username -> Compatibility score
    private HashMap<String, Boolean> actionsToRequests; // Username -> Accepted/Rejected
    private String errorMessage;

    public RequestsState(){
        this.scoresMap = new HashMap<>();
        this.actionsToRequests = new HashMap<>();
        this.errorMessage = null;

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HashMap<String, Boolean> getActionsToRequests() {
        return actionsToRequests;
    }

    public Map<String, Double> getScoresMap() {
        return scoresMap;
    }

    public void setScoresMap(HashMap<String, Double> scoresMap) {
        this.scoresMap = scoresMap;
    }

    public void setActionsToRequests(HashMap<String, Boolean> actionsToRequests) {
        this.actionsToRequests = actionsToRequests;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }

    @Override
    public String toString() {
        return "RequestsState{"
                + "currentUserName='" + currentUserName + '\''
                + ", scoresMap='" + scoresMap + '\''
                + ", actionsToRequest='" + actionsToRequests + '\''
                + ", errorMessage='" +errorMessage + '\''
                + '}';
    }
}
