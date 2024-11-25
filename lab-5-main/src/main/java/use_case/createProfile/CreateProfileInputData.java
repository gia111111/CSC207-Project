package use_case.createProfile;

import data_access.InMemoryUserDataAccessObject;
import data_access.RemoteDataAccessObject;

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
    private final Map<String, List<String>> answers;
    private final Map<String, Integer> weights;
    private final String contactMethod;
    private final String contactInfo;
    private final RemoteDataAccessObject dataAccessObject;


    public CreateProfileInputData(String gender, String SexualOrientation, int age, Map<String, List<String>> answers, Map<String, Integer> weights, String contactMethod, String contactInfo, RemoteDataAccessObject dataAccessObject) {
        this.name = dataAccessObject.getCurrentUsername();
        this.gender = gender;
        this.sexualOrientation = SexualOrientation;
        this.age = age;
        this.answers = answers;
        this.weights = weights;
        this.contactMethod = contactMethod;
        this.contactInfo = contactInfo;
        this.dataAccessObject = dataAccessObject;

    }

    public String getName() { return name;}

    public String getGender() { return gender; }

    public String getSexualOrientation() { return sexualOrientation; }

    public int getAge() { return age; }

    public Map<String, Integer> getWeights() { return weights; }

    public Map<String, List<String>> getAnswers() { return answers;}

    public String getContactMethod() {return contactMethod;}

    public String getContactInfo() {return contactInfo;}

}
