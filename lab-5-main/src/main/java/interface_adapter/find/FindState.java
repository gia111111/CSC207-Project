package interface_adapter.find;

import java.util.HashMap;
import java.util.Map;

public class FindState {
    private Map<String, Double> scores; // Username -> Compatibility score
    private Map<String, Boolean> actions; // Username -> Accepted/Rejected
    private String errorMessage;

    public FindState() {
        this.scores = new HashMap<>();
        this.actions = new HashMap<>();
        this.errorMessage = null;
    }

    public Map<String, Double> getScores() {
        return scores;
    }

    public void setScores(Map<String, Double> scores) {
        this.scores = scores;
    }

    public Map<String, Boolean> getActions() {
        return actions;
    }

    public void setActions(Map<String, Boolean> actions) {
        this.actions = actions;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "FindState{" +
                "scores=" + scores +
                ", actions=" + actions +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
