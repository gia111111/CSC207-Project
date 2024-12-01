package use_case.profile;

import entity.Profile;
import use_case.createProfile.CreateProfileDataAccessInterface;

import java.util.List;
import java.util.Map;

public class FakeProfileDataAccessObject implements CreateProfileDataAccessInterface {
    private Profile savedProfile;

    @Override
    public void save(Profile profile) {
        this.savedProfile = profile;
    }

    @Override
    public String getCurrentUsername() {
        return "";
    }

    @Override
    public void setGender(String gender) {

    }

    @Override
    public void setSexualOrientation(String sexualOrientation) {

    }

    @Override
    public void setAgeValue(int age) {

    }

    @Override
    public void setSectionAnswers(Map<String, List<String>> sectionAnswers) {

    }

    @Override
    public void setSectionWeights(Map<String, Integer> sectionWeights) {

    }

    @Override
    public String getGender() {
        return "";
    }

    @Override
    public String getSexualOrientation() {
        return "";
    }

    @Override
    public int getAgeValue() {
        return 0;
    }

    @Override
    public Map<String, List<String>> getSectionAnswers() {
        return Map.of();
    }

    @Override
    public Map<String, Integer> getSectionWeights() {
        return Map.of();
    }

    @Override
    public void setContactMethod(String contactMethod) {

    }

    @Override
    public void setContactInfo(String contactInfo) {

    }

    @Override
    public String getContactMethod() {
        return "";
    }

    @Override
    public String getContactInfo() {
        return "";
    }

    public Profile getSavedProfile() {
        return savedProfile;
    }
}
