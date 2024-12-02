package use_case.matches;

import java.util.List;
import java.util.Map;

import data_access.RemoteDataAccessObject;

/**
 * An interface for the Matches use case.
 */
public class MatchesInputData {
    private final String name;
    private final Map<String, List<String>> matches;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public MatchesInputData(Map<String, List<String>> matches, RemoteDataAccessObject remoteDataAccessObject) {
        this.name = remoteDataAccessObject.getCurrentUsername();
        this.matches = matches;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }

    public String getName() {
        return name;
    }

    public Map<String, List<String>> getMatches() {
        return matches;
    }
}
