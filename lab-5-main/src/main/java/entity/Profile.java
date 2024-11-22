package entity;

import java.util.List;
import java.util.Map;

/**
 * The representation of a profile in our program.
 */
public interface Profile {

    /**
     * Returns the username of the user.
     * @return the username of the user.
     */
    String getName();

    /**
     * Returns the gender of the user.
     * @return the gender of the user( three options: Male, Female, and Others).
     */
    String getGender();

    /**
     * Returns the sexual orientation of the user.
     * @return the sexual orientation of the user(three choices Male, Female, or Both).
     */
    String getSexualOrientation();

    /**
     * Returns the age of the user.
     * @return the age of the user.
     */
    int getAge();

    /**
     * Returns the answers of the user.
     * @return the answers of the user by sections.
     */
    List<List<String>> getAnswer();

    /**
     * Returns the weights of the answers by sections for the user.
     * @return the weights of the answers by sections for the user.
     */
    Map<String, Integer> getWeights();
}
