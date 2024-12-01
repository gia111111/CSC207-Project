package use_case.profile;

import entity.CommonProfile;
import entity.Profile;
import entity.ProfileFactory;

import java.util.List;
import java.util.Map;

public class FakeProfileFactory implements ProfileFactory {
    @Override
    public CommonProfile create(String name, String gender, String sexualOrientation, int age,
                                Map<String, List<String>> answers, Map<String, Integer> weights,
                                String contactInfo, String contactMethod) {
        // Directly create and return a CommonProfile for testing purposes
        return new CommonProfile(name, gender, sexualOrientation, age, answers, weights, contactInfo, contactMethod);
    }
}
