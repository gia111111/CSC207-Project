package data_access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Matches;
import entity.Profile;
import entity.Requests;
import entity.User;
import use_case.changePassword.ChangePasswordUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.matches.MatchesDataAccessObject;
import use_case.requests.RequestsDataAccessInterface;
import use_case.signup.SignupDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing user data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryDataAccessObject implements SignupDataAccessInterface,
        LoginUserDataAccessInterface,
        ChangePasswordUserDataAccessInterface,
        LogoutUserDataAccessInterface, MatchesDataAccessObject, RequestsDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Matches> matches = new HashMap<>();
    private final Map<String, Requests> requests = new HashMap<>();

    private String currentUsername;

    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public void changePassword(User user) {
        // Replace the old entry with the new password
        users.put(user.getName(), user);
    }

    @Override
    public void setCurrentUsername(String name) {
        this.currentUsername = name;
    }

    @Override
    public List<String> getNames() throws Exception {
        return (List) requests.get(this.currentUsername).getRequests().keySet();
    }

    @Override
    public Boolean isValidRequest(String myname, String partnerName) {
        return null;
    }

    @Override
    public Map<String, Boolean> getFinds(String partnerName) {
        return Map.of();
    }

    @Override
    public Profile getProfile(String myname) {
        return null;
    }

    @Override
    public void updateSatus(String myName, String partnerName, Boolean requestAccpeted) {

    }

    @Override
    public HashMap<String, Boolean> getRequestsActionsMap(String myName) {
        return null;
    }

    @Override
    public void save(Requests requests1) {
        requests.put(this.currentUsername, requests1);

    }

    @Override
    public String getCurrentUsername() {
        return this.currentUsername;
    }

    @Override
    public void save(Matches matches1) {
        matches.put(matches1.getCurrentUsername(), matches1);
        System.out.println(matches);
    }

    @Override
    public List<String> getContactCard(String username) {
        return matches.get(username).getMatches().get(username);
    }

    @Override
    public List<String> getRequests(String username) {
        Requests myLikes = requests.get(username);
        List<String> myMatches = new ArrayList<>();
        if (myLikes == null || myLikes.getRequests() == null) {
            return myMatches; // Return an empty list if there are no requests
        }

        // Iterate over the requests and add matches
        Map<String, Boolean> userRequests = myLikes.getRequests();
        for (Map.Entry<String, Boolean> entry : userRequests.entrySet()) {
            if (Boolean.TRUE.equals(entry.getValue())) { // Safely check for true
                myMatches.add(entry.getKey());
            }
        }

        return myMatches;
    }
}
