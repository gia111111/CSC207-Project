package interface_adapter.profile;

import data_access.InMemoryUserDataAccessObject;
import data_access.RemoteDataAccessObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The state for the Profile View Model.
 */
public class ProfileState {
    
    private String name;
    private String gender = "";
    private String sexualOrientation = "";
    private int ageValue = 0;
    private List<List<String>> sectionAnswers = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>(),
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
    private Map<String, Integer> sectionWeights = new HashMap<>();
    private RemoteDataAccessObject dataAccessObject;
    private String errorMessage = "Please fill in all fields.";

    public String getName() {return name;}


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

    public void setSectionAnswers(List<List<String>> sectionAnswers) {
        this.sectionAnswers = sectionAnswers;
    }

    public void setSectionWeights(Map<String, Integer> answers) {
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