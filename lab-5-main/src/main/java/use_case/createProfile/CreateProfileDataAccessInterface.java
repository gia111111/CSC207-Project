package use_case.createProfile;

import entity.Profile;

/**
 * DAO for the Create Profile use case
 */
public interface CreateProfileDataAccessInterface {

    /**
     * Saves the profile.
     * @param profile the profile to save
     */
    void save(Profile profile);
}
