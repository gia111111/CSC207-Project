package entity;

import java.util.HashMap;
import java.util.List;

/**
 * the matches entity includes a collection of matches, where the key is the name
 * of the match and the value is a list of contact information
 */
public class Matches {
    private HashMap<String, List<String>> matches;

    public Matches(HashMap<String, List<String>> matches) {
        this.matches = matches;
    }

    public HashMap<String, List<String>> getMatches() {
        return matches;
    }
}
