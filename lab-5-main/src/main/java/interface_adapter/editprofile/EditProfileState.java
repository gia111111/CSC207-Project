package interface_adapter.editprofile;

import java.util.List;

/**
 * The state for the EditProfile View Model.
 */
public class EditProfileState {
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
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<String> getAnswers() {
        return answers;
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
        return "EditProfileState{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", sexualOrientation='" + sexualOrientation + '\'' +
                ", age=" + age +
                ", questions=" + questions +
                ", answers=" + answers +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}

