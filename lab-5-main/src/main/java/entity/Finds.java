package entity;

import java.util.HashMap;

/**
 * the finds entity includes a collection of finds, where the key is the name
 * of the find and the value is a boolean value indicating if the user would like
 * to send a request to the other user.
 */

public class Finds {
    private HashMap<String, Boolean> requests; // Key: Username, Value: Request Sent (true/false)
    private HashMap<String, Double> compatibilityScores; // Key: Username, Value: Compatibility Score


    public Finds(HashMap<String, Boolean> requests, HashMap<String, Double> scores) {
        this.requests = requests;
        this.compatibilityScores = scores;
    }

    public HashMap<String, Boolean> getFinds() {
        return requests;
    }

    public void setFinds(HashMap<String, Boolean> requests) {
        this.requests = requests;
    }

    public HashMap<String, Double> getScores() {
        return compatibilityScores;
    }

//    public void setScores(HashMap<String, Double> scores) {
//        this.compatibilityScores = scores;
//    }

    public void addRequest(String username, boolean requestStatus) {
        this.requests.put(username, requestStatus);
    }

    public void addScore(String username, double score) {
        this.compatibilityScores.put(username, score);
    }

    public boolean hasRequest(String username) {
        return this.requests.containsKey(username);
    }

    public boolean getRequestStatus(String username) {
        return this.requests.getOrDefault(username, false);
    }

    public double getScore(String username) {
        return this.compatibilityScores.getOrDefault(username, 0.0);
    }
    public void setScore(String username, double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Compatibility score must be between 0 and 100.");
        }
        this.compatibilityScores.put(username, score);
    }

}
