package use_case.find;

import data_access.RemoteDataAccessObject;
import entity.Finds;
import entity.Profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeRemoteDataAccessObject extends RemoteDataAccessObject {
    private String currentUsername;
    private final Map<String, Profile> profiles = new HashMap<>();

    public FakeRemoteDataAccessObject() throws IOException {
    }

    public void setCurrentUsername(String username) {
        this.currentUsername = username;
    }

    public void addProfile(Profile profile) {
        profiles.put(profile.getName(), profile);
    }

    @Override
    public String getCurrentUsername() {
        return currentUsername;
    }

    @Override
    public Profile getProfile(String username) {
        return profiles.get(username);
    }

    @Override
    public List<String> getNames() {
        return new ArrayList<>(profiles.keySet());
    }

    @Override
    public void save(Finds finds) {
        // Fake implementation, do nothing
    }
}
