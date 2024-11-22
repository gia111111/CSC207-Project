package use_case.manageRequest;

public interface ManageRequestInputBoundary {

    /**
     * The user doesn't decide accept or reject the request yet
     * Executes the switch to request view use case.
     */
    void switchToProfileView();

    /**
     * The user decides to accept the reject.
     * Executes the save request to matches and switch to request view use case.
     */
    void accept();

    /**
     * The user decides to reject the reject.
     * Executes the delete request from requests and switch to request view use case.
     */
    void reject();
}
