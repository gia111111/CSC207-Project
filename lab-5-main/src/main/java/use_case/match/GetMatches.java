package use_case.match;

import entity.Match;

import java.util.List;

public class GetMatches {
    private final MatchDataAccessInterface matchDataAccess;

    public GetMatches(MatchDataAccessInterface matchDataAccess) {
        this.matchDataAccess = matchDataAccess;
    }

    public List<Match> execute(String username) {
        return matchDataAccess.getMatches(username);
    }
}
