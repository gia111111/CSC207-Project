package entity;

import java.util.HashMap;
import java.util.List;

/**
 * the matches entity includes a collection of matches, where the key is the name
 * of the match and the value is a list of contact information
 */
public class Matches {
    private String currentUsername;
    private HashMap<String, List<String>> matches;

    public Matches() {
        this.matches = new HashMap<>();
    }

    public Matches(String currentUsername, HashMap<String, List<String>> matches) {
        this.matches = matches;
        this.currentUsername = currentUsername;
    }

    public String getCurrentUsername() {return currentUsername;}

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    public HashMap<String, List<String>> getMatches() {
        return matches;
    }

    public void setMatches(HashMap<String, List<String>> matches) {
        this.matches = matches;
    }

    public void addMatch(String matchName, List<String> contactInfo) {
        matches.put(matchName, contactInfo);
    }

    public boolean hasMatch(String matchName) {
        return matches.containsKey(matchName);
    }
}
