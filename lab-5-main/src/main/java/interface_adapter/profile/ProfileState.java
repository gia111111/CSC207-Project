package interface_adapter.profile;

import java.util.List;
import java.util.Map;

/**
 * The state for the Profile View Model.
 */
public class ProfileState {
    
    private String name;
    private String gender;
    private String sexualOrientation;
    private int ageValue;
    private List<List<String>> sectionAnswers;
    private Map<String, Integer> sectionWeights;
    private String errorMessage = "Please fill in all fields.";

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getSexualOrientation() {
        return sexualOrientation;
    }

    public int getAgeValue() {
        return ageValue;
    }

    public List<List<String>> getSectionAnswers() {
        return sectionAnswers;
    }

    public Map<String, Integer> getSectionWeights() {
        return sectionWeights;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public void setAgeValue(int ageValue) {
        this.ageValue = ageValue;
    }

    public void setSectionAnswers(List<List<String>> sectionAnswers) {
        this.sectionAnswers = sectionAnswers;
    }

    public void setAnswers(Map<String, Integer> answers) {
        this.sectionWeights = answers;
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