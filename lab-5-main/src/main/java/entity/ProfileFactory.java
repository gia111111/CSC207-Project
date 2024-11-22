package entity;

import java.util.List;
import java.util.Map;

public interface ProfileFactory {

    /**
     * Creates a new profile object.
     * @param name the name of the user
     * @param gender the gender of the user
     *               three choices: Male, Female and Others
     * @param SexualOrientation the sexual orientation of the user
     *                          three choices: Male, Female, or Both
     * @param age the age of the user
     *            must be greater than 0
     * @param answers the answers of the user
     * @param weights the weights of the answers by sections for the user
     * @return the new profile object
     */

    CommonProfile create(String name, String gender, String SexualOrientation, int age, List<List<String>> answers, Map<String, Integer> weights);
}
