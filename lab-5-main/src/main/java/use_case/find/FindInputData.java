package use_case.find;

import java.util.Map;

import data_access.RemoteDataAccessObject;

/**
 * An interface for the Find use case.
 */
public class FindInputData {
    private final String name;
    private final Map<String, Double> scores;
    private final Map<String, Boolean> matches;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public FindInputData(Map<String, Double> scores, Map<String, Boolean> matches,
                         RemoteDataAccessObject remoteDataAccessObject) {
        this.name = remoteDataAccessObject.getCurrentUsername();
        this.scores = scores;
        this.matches = matches;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getScores() {
        return scores;
    }

    public Map<String, Boolean> getMatches() {
        return matches;
    }

}
