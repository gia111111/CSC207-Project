package entity;

import java.util.HashMap;

/**
 * the requests entity includes a collection of requests, where the key is the name
 */
public class Requests {
    private HashMap<String, Boolean> requests;
    private HashMap<String, Double> scoresMap;

    public Requests(HashMap<String, Boolean> requests, HashMap<String, Double> scoresMap) {
        this.requests = requests;
        this.scoresMap = scoresMap;
    }

    public HashMap<String, Boolean> getRequests() {
        return requests;
    }

    public HashMap<String, Double> getScoresMap() {
        return scoresMap;
    }
}
