package use_case.match;

import entity.Match;

import java.util.List;

public interface MatchDataAccessInterface {
    void saveMatch(String username, Match match);
    List<Match> getMatches(String username);
}
