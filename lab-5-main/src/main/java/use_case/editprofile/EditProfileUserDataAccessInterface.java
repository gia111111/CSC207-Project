package use_case.editprofile;

/**
 * DAO for the Edit Profile Use Case.
 */
public interface EditProfileUserDataAccessInterface {

    /**
     * Saves the edited profile.
     * @param editProfileInputData the user to save
     */
    void save(EditProfileInputData editProfileInputData);
}
