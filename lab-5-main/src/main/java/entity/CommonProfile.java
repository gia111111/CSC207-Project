package entity;

import java.util.List;
import java.util.Map;

public class CommonProfile implements Profile {

    private final String name;
    private final String gender;
    private final String SexualOrientation;
    private final int age;
    private final List<List<String>> answers;
    private final Map<String, Integer> weights;

    public CommonProfile(String name, String gender, String SexualOrientation, int age, List<List<String>> answers, Map<String, Integer> weights) {
        this.name = name;
        this.gender = gender;
        this.SexualOrientation = SexualOrientation;
        this.age = age;
        this.answers = answers;
        this.weights = weights;
    }

    @Override
    public String getName() { return name;}

    @Override
    public String getGender() { return gender; }

    @Override
    public String getSexualOrientation() { return SexualOrientation; }

    @Override
    public int getAge() { return age; }

    @Override
    public List<List<String>> getAnswer() { return answers; }

    @Override
    public List<Integer> getWeights() { return weights; }
}
