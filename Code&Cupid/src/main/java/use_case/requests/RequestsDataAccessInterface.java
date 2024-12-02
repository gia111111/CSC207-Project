package use_case.requests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Profile;
import entity.Requests;

/**
 * An interface for the Requests data access use case.
 */
public interface RequestsDataAccessInterface {

    /**
     * Retrieves a list of all the names of the users in the database.
     * @return A list of all the names of the users in the database.
     */
    List<String> getNames() throws Exception;

    /**
     * Determines if the request is valid.
     * @param myname The name of the current user.
     * @param partnerName The name of the partner user.
     * @return True if the request is valid, false otherwise.
     */
    Boolean isValidRequest(String myname, String partnerName);

    /**
     * Retrieves the finds of the partner user.
     * @param partnerName The name of the partner user.
     * @return A map of the partner user's finds.
     */
    Map<String, Boolean> getFinds(String partnerName);

    /**
     * Retrieves the profile of the user.
     * @param myname The name of the user.
     * @return The profile of the user.
     */
    Profile getProfile(String myname);

    /**
     * Updates the status of the request.
     * @param myName The name of the current user.
     * @param partnerName The name of the partner user.
     * @param requestAccpeted True if the request is accepted, false otherwise.
     */
    void updateSatus(String myName, String partnerName, Boolean requestAccpeted);

    /**
     * Retrieves the requests of the user.
     * @param myName The name of the user.
     * @return A list of the user's requests.
     */
    HashMap<String, Boolean> getRequestsActionsMap(String myName);

    /**
     * Saves the requests.
     * @param requests The requests to save.
     */
    void save(Requests requests);

    /**
     * Retrieves the current user's username.
     * @return The current user's username.
     */
    String getCurrentUsername();

}
