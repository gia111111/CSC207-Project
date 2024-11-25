package use_case.matches;

import java.util.HashMap;
import java.util.List;

public class MatchOutputData {
    private final String username; // The user whose matches are being processed
    private final HashMap<String, List<String>> matches; // The user's matches
    private final boolean success; // Whether the operation was successful
    private final String message; // Additional information

    public MatchOutputData(String username, HashMap<String, List<String>> matches, boolean success, String message) {
        this.username = username;
        this.matches = matches;
        this.success = success;
        this.message = message;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public HashMap<String, List<String>> getMatches() {
        return matches;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
