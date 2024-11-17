package entity;

import java.util.List;

/**
 * Factory for creating profile objects.
 */
public class CommonProfileFactory implements ProfileFactory {

    @Override
    public CommonProfile create(String name, String gender, String SexualOrientation, int age, List<List<String>> answers, List<Integer> weights) {
        return new CommonProfile(name, gender, SexualOrientation, age, answers, weights);
    }
}
