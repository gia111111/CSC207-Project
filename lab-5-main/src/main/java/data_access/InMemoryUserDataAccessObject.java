package data_access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Match;
import entity.User;
import use_case.change_password.ChangePasswordUserDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.match.MatchDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing user data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryUserDataAccessObject implements SignupUserDataAccessInterface,
        LoginUserDataAccessInterface,
        ChangePasswordUserDataAccessInterface,
        MatchDataAccessInterface,
        LogoutUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    private final Map<String, List<Match>> matchStorage = new HashMap<>();

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
    public String getCurrentUsername() {
        return this.currentUsername;
    }

    @Override
    public void saveMatch(String username, Match match) {
        matchStorage.putIfAbsent(username, new ArrayList<>());
        matchStorage.get(username).add(match);
    }

    @Override
    public List<Match> getMatches(String username) {
        return matchStorage.getOrDefault(username, new ArrayList<>());
    }
}
