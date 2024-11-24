package use_case.match;

import entity.Match;

public class SaveMatch {
    private final MatchDataAccessInterface matchDataAccess;

    public SaveMatch(MatchDataAccessInterface matchDataAccess) {
        this.matchDataAccess = matchDataAccess;
    }

    public void execute(String username, Match match) {
        if (username == null || username.isEmpty() || match == null) {
            throw new IllegalArgumentException("Username or match cannot be null/empty");
        }

        matchDataAccess.saveMatch(username, match);

        // Check if reverse match already exists
        boolean reverseMatchExists = matchDataAccess.getMatches(match.getName()).stream()
                .anyMatch(existingMatch -> existingMatch.getName().equals(username));

        if (!reverseMatchExists) {
            Match reverseMatch = new Match(username, match.getContactMethod(), match.getContactInfo(), match.getProfileImageUrl());
            matchDataAccess.saveMatch(match.getName(), reverseMatch);
        }
    }
}
