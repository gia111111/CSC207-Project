package use_case.matches;

import java.util.HashMap;
import java.util.List;

public class MatchInputData {
    private final String username; // The user performing the operation
    private final HashMap<String, List<String>> matches; // Map of matchName to contactInfo

    public MatchInputData(String username, HashMap<String, List<String>> matches) {
        this.username = username;
        this.matches = matches;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public HashMap<String, List<String>> getMatches() {
        return matches;
    }
}
