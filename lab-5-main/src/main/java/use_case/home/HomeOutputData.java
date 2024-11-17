package use_case.home;

public class HomeOutputData {
    private final boolean useCaseFailed;
    private final String actionType; // The type of action (login, signup, resetPassword)
    private final String username; // The username involved in the action (if applicable)
    private final String errorMessage; // Error message if useCaseFailed is true

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
