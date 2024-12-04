package entity;

import java.util.HashMap;

/**
 * the requests entity includes a collection of requests, where the key is the name
 */
public class Requests {
    private HashMap<String, Boolean> actionsToRequests;
    private HashMap<String, Double> scoresMap;

    public Requests(HashMap<String, Boolean> requests, HashMap<String, Double> scoresMap) {
        this.actionsToRequests = requests;
        this.scoresMap = scoresMap;
    }

    public HashMap<String, Boolean> getRequests() {
        return actionsToRequests;
    }

    public HashMap<String, Double> getScoresMap() {
        return scoresMap;
    }

    public void setActionsToRequests(HashMap<String, Boolean> actionsToRequests) {
        this.actionsToRequests = actionsToRequests;
    }

    public void setScoresMap(HashMap<String, Double> scoresMap) {
        this.scoresMap = scoresMap;
    }
}
