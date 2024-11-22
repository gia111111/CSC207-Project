package entity;

import java.util.List;
import java.util.Map;

/**
 * Factory for creating profile objects.
 */
public class CommonProfileFactory implements ProfileFactory {

    @Override
    public CommonProfile create(String name, String gender, String SexualOrientation, int age, List<List<String>> answers, Map<String, Integer> weights) {
        return new CommonProfile(name, gender, SexualOrientation, age, answers, weights);
    }
}
