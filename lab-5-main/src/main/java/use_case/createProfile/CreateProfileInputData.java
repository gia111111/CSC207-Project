package use_case.createProfile;

import java.util.List;
import java.util.Map;

/**
 * The input data for the Create Profile Use Case.
 */
public class CreateProfileInputData {

    private final String name;
    private final String gender;
    private final String sexualOrientation;
    private final int age;
    private final List<List<String>> answers;
    private final Map<String, Integer> weights;

    public CreateProfileInputData(String name, String gender, String SexualOrientation, int age, List<List<String>> answers, Map<String, Integer> weights) {
        this.name = name;
        this.gender = gender;
        this.sexualOrientation = SexualOrientation;
        this.age = age;
        this.answers = answers;
        this.weights = weights;
    }

    public String getName() { return name;}

    public String getGender() { return gender; }

    public String getSexualOrientation() { return sexualOrientation; }

    public int getAge() { return age; }

    public Map<String, Integer> getWeights() { return weights; }

    public List<List<String>> getAnswers() { return answers;}
}
