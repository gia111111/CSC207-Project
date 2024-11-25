package use_case.createProfile;

import entity.Profile;

import java.util.List;
import java.util.Map;

/**
 * DAO for the Create Profile use case
 */
public interface CreateProfileDataAccessInterface {

    /**
     * Saves the profile.
     * @param profile the profile to save
     */
    void save(Profile profile);

    String getCurrentUsername();

    void setGender(String gender);

    void setSexualOrientation(String sexualOrientation);

    void setAgeValue(int age);

   void setSectionAnswers(Map<String, List<String>> sectionAnswers);

    void setSectionWeights(Map<String, Integer> sectionWeights);

    String getGender();

    String getSexualOrientation();

    int getAgeValue();

    Map<String, List<String>> getSectionAnswers();

    Map<String, Integer> getSectionWeights();

    void setContactMethod(String contactMethod);

    void setContactInfo(String contactInfo);

    String getContactMethod();

    String getContactInfo();




}
