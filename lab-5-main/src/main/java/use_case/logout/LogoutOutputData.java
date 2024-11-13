package use_case.logout;

/**
 * Output Data for the Logout Use Case.
 */
public class LogoutOutputData {

    private final String username;
    private final boolean useCaseFailed;

    // Constructor to initialize the instance variables with the provided parameters
    public LogoutOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    // Getter method to retrieve the username
    public String getUsername() {
        return username;
    }

    // Getter method to check if the use case failed
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
