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

   void setSectionAnswers(List<List<String>> sectionAnswers);

    void setSectionWeights(Map<String, Integer> sectionWeights);

    String getGender();

    String getSexualOrientation();

    int getAgeValue();

    List<List<String>> getSectionAnswers();

    Map<String, Integer> getSectionWeights();




}
