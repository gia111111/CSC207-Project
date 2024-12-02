package entity;

import data_access.RemoteDataAccessObject;

import java.util.List;
import java.util.Map;

public class CommonProfile implements Profile {

    private final String name;
    private final String gender;
    private final String SexualOrientation;
    private final int age;
    private final Map<String, List<String>> answers;
    private final Map<String, Integer> weights;
    private final String contactInfo;
    private final String contactMethod;

    public CommonProfile(String name, String gender, String SexualOrientation, int age, Map<String, List<String>> answers, Map<String, Integer> weights, String contactInfo, String contactMethod) {
        this.name = name;
        this.gender = gender;
        this.SexualOrientation = SexualOrientation;
        this.age = age;
        this.answers = answers;
        this.weights = weights;
        this.contactInfo = contactInfo;
        this.contactMethod = contactMethod;
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
    public Map<String, List<String>> getAnswer() { return answers; }

    @Override
    public Map<String, Integer> getWeights() { return weights; }

    @Override
    public String getContactInfo() { return contactInfo; }

    @Override
    public String getContactMethod() { return contactMethod; }
}
