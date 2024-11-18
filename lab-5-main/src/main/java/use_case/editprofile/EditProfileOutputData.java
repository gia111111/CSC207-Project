package use_case.editprofile;

import java.util.List;

/**
 * The Output Data for the Edit Profile Use Case.
 */
public class EditProfileOutputData {

    private final String name;
    private final String gender;
    private final String SexualOrientation;
    private final int age;
    private final List<List<String>> answers;
    private final List<Integer> weights;

    public EditProfileOutputData(String name, String gender, String SexualOrientation, int age, List<List<String>> answers, List<Integer> weights) {
        this.name = name;
        this.gender = gender;
        this.SexualOrientation = SexualOrientation;
        this.age = age;
        this.answers = answers;
        this.weights = weights;
    }

    public String getName() { return name;}

    public String getGender() { return gender; }

    public String getSexualOrientation() { return SexualOrientation; }

    public int getAge() { return age; }

    public List<List<String>> getAnswers() { return answers; }

    public List<Integer> getWeights() { return weights; }
}
