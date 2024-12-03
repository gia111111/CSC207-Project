package use_case.createProfile;

import java.util.List;
import java.util.Map;

import entity.Profile;

/**
 * DAO for the Create Profile use case.
 */
public interface CreateProfileDataAccessInterface {

    /**
     * Saves the profile.
     * @param profile the profile to save
     */
    void save(Profile profile);

    /**
     * Returns the profile with the given username.
     * @return the profile with the given username
     */
    String getCurrentUsername();

    /**
     * Sets the profile's gender.
     * @param gender the username to set
     */
    void setGender(String gender);

    /**
     * Sets the profile's sexual orientation.
     * @param sexualOrientation the sexual orientation to set
     */
    void setSexualOrientation(String sexualOrientation);

    /**
     * Sets the profile's age.
     * @param age the age to set
     */
    void setAgeValue(int age);

    /**
     * Sets the profile's section answers.
     * @param sectionAnswers the section answers to set
     */
    void setSectionAnswers(Map<String, List<String>> sectionAnswers);

    /**
     * Sets the profile's section weights.
     * @param sectionWeights the section weights to set
     */
    void setSectionWeights(Map<String, Integer> sectionWeights);

    /**
     * Returns the user's gender.
     * @return the gender of the user
     */
    String getGender();

    /**
     * Returns the user's sexual orientation.
     * @return the sexual orientation of the user
     */
    String getSexualOrientation();

    /**
     * Returns the user's age.
     * @return the age of the user
     */
    int getAgeValue();

    /**
     * Returns the user's section answers.
     * @return the section answers of the user
     */
    Map<String, List<String>> getSectionAnswers();

    /**
     * Returns the user's section weights.
     * @return the section weights of the user
     */
    Map<String, Integer> getSectionWeights();

    /**
     * Sets the profile's contact method.
     * @param contactMethod the contact method to set
     */
    void setContactMethod(String contactMethod);

    /**
     * Sets the profile's contact info.
     * @param contactInfo the contact info to set
     */
    void setContactInfo(String contactInfo);

    /**
     * Returns the user's contact method.
     * @return the contact method of the user
     */
    String getContactMethod();

    /**
     * Returns the user's contact info.
     * @return the contact info of the user
     */
    String getContactInfo();

    /**
     * Checks if the given username exists.
     * @param username the username to look for
     * @return true if a user with the given username exists; false otherwise
     */
    boolean existsByUsername(String username);

}
