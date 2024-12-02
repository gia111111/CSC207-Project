package use_case.find;

import data_access.RemoteDataAccessObject;

import java.util.List;
import java.util.Map;

public class FindProfileInputData {
    private final String name;
    private final Map<String, Double> scores;
    private final Map<String, Boolean> matches;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public FindProfileInputData(Map<String, Double> scores, Map<String, Boolean> matches, RemoteDataAccessObject remoteDataAccessObject) {
        this.name = remoteDataAccessObject.getCurrentUsername();
        this.scores = scores;
        this.matches = matches;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }

    public String getName() { return name;}

    public Map<String, Double> getScores() {return scores;}

    public Map<String, Boolean> getMatches() {return matches;}

}
