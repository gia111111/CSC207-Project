package interface_adapter.matches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchesState {
    private String name = "";
    private Map<String, List<String>> matchContacts = new HashMap<>();
    private String errorMessage = "Please try again!";

    public String getName() {return name;}

    public Map<String, List<String>> getMatchContacts() {return matchContacts;}

    public String getErrorMessage() {return errorMessage;}

    public void setName(String name) {this.name = name;}

    public void setErrorMessage(String errorMessage) {this.errorMessage = errorMessage;}

    public void setMatchContacts(Map<String, List<String>> matchContacts) {
        this.matchContacts = matchContacts;
    }

    public String toString() {
        return "ProfileState{"
                + ", name='" + name + '\''
                + ", contacts=" + matchContacts
                + '}';
    }
}
