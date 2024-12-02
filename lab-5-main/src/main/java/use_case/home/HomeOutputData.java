package use_case.home;

/**
 * The output data for the Home use case.
 */
public class HomeOutputData {
    private final boolean useCaseFailed;
    // The type of action (login, signup, resetPassword)
    private final String actionType;
    // The username involved in the action (if applicable)
    private final String username;
    // Error message if useCaseFailed is true
    private final String errorMessage;

    // Constructor to initialize all fields
    public HomeOutputData(boolean useCaseFailed, String actionType, String username, String errorMessage) {
        this.useCaseFailed = useCaseFailed;
        this.actionType = actionType;
        this.username = username;
        this.errorMessage = errorMessage;
    }

    // Getters for all fields
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public String getActionType() {
        return actionType;
    }

    public String getUsername() {
        return username;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
