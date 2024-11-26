package use_case.Find;

import entity.Profile;

import java.util.List;

public interface FindUserDataAccessInterface {
    Profile getProfile(String username); // Fetch a single profile
    List<Profile> getAllProfiles(); // Fetch all profiles
}
