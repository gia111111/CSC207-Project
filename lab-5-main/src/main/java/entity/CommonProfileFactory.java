package entity;

import java.util.List;
import java.util.Map;

/**
 * Factory for creating profile objects.
 */
public class CommonProfileFactory implements ProfileFactory {

    @Override
    public CommonProfile create(String name, String gender, String SexualOrientation, int age, Map<String, List<String>> answers, Map<String, Integer> weights, String contactInfo, String contactMethod) {
        return new CommonProfile(name, gender, SexualOrientation, age, answers, weights, contactInfo, contactMethod);
    }
}
