package interface_adapter.profile;

import data_access.RemoteDataAccessObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The state for the Profile View Model.
 */
public class ProfileState {
    
    private String name = "";
    private String gender = "";
    private String sexualOrientation = "";
    private int ageValue = 0;
    private Map<String, List<String>> sectionAnswers = new HashMap<>();
    private Map<String, Integer> sectionWeights = new HashMap<>();
    private String contactMethod = "";
    private String contactInfo = "";
    private RemoteDataAccessObject dataAccessObject;
    private String errorMessage = "Please fill in all fields.";

    public String getName() { return name; }

    public String getGender() {
        return gender;
    }

    public String getSexualOrientation() {
        return sexualOrientation;
    }

    public int getAgeValue() {
        return ageValue;
    }

    public Map<String, List<String>> getSectionAnswers() {
        return sectionAnswers;
    }

    public Map<String, Integer> getSectionWeights() {
        return sectionWeights;
    }

    public String getContactMethod() {return contactMethod;}

    public String getContactInfo() {return contactInfo;}

    public RemoteDataAccessObject getDataAccessObject() {return dataAccessObject;}

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDataAccessObject(RemoteDataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public void setAgeValue(int ageValue) {
        this.ageValue = ageValue;
    }

    public void setSectionAnswers(Map<String, List<String>> sectionAnswers) {
        this.sectionAnswers = sectionAnswers;
    }

    public void setSectionWeights(Map<String, Integer> answers) {
        this.sectionWeights = answers;
    }

    public void setContactMethod(String contactMethod) {
        this.contactMethod = contactMethod;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ProfileState{"
                + ", name='" + name + '\''
                + ", gender=" + gender
                + ", sexualOrientation='" + sexualOrientation + '\''
                + ", age=" + ageValue
                + ", questions=" + sectionAnswers
                + ", answers=" + sectionWeights
                + '}';
    }
} 