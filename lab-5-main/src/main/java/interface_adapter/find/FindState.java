package interface_adapter.find;

import java.util.HashMap;
import java.util.Map;

public class FindState {
    private String name = "";
    private Map<String, Double> scores; // Username -> Compatibility score
    private Map<String, Boolean> actions; // Username -> Accepted/Rejected
    private String errorMessage;

    public FindState() {
        this.scores = new HashMap<>();
        this.actions = new HashMap<>();
        this.errorMessage = null;
    }

    public Map<String, Double> getScores() {
//        final Map<String, Double> hello = new HashMap<>();
//        hello.put("hello", 1.0);
//        hello.put("world", 1.0);
//        return hello;
        System.out.println("Current scores: " + this.scores);
        return this.scores;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
