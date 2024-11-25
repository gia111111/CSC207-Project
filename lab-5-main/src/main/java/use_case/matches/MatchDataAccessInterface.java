package use_case.matches;

import entity.Matches;

import java.util.HashMap;
import java.util.List;

public interface MatchDataAccessInterface {
    void saveMatch(String username, String matchName, List<String> contactInfo);
    HashMap<String, List<String>> getMatches(String username);
    boolean matchExists(String username, String matchName);
}
