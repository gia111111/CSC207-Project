package use_case.matches;

public interface MatchInputBoundary {
    void saveMatch(MatchInputData inputData);

    MatchOutputData getMatches(String username);
}
