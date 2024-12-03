package entity;

/**
 * The representation of a user in our program.
 */
public interface User {

    /**
     * Returns the username of the user.
     * @return the username of the user.
     */
    String getName();

    /**
     * Returns the password of the user.
     * @return the password of the user.
     */
    String getPassword();

    /**
     * Returns the security word of the user.
     * @return the security word of the user.
     */
    String getSecurityWord();

    /**
     * Sets the password of the user.
     * @param password the new password of the user.
     */
    void setPassword(String password);
}
