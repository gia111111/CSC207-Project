package interface_adapter.profile;

import java.util.List;

/**
 * The state for the Profile View Model.
 */
public class ProfileState {
    
    private String name;
    private String gender;
    private String sexualOrientation;
    private int age;
    private List<String> questions;
    private List<String> answers;
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

    public int getAge() {
        return age;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getAnswers() {
        return answers;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
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
                + ", age=" + age
                + ", questions=" + questions
                + ", answers=" + answers
                + '}';
    }
} 