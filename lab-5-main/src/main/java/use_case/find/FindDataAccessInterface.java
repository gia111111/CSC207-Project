package use_case.find;

import java.util.List;

import entity.Finds;
import entity.Profile;

/**
 * An interface for data access operations related to the Find use case.
 */
public interface FindDataAccessInterface {
    /**
     * Fetches a profile for the given username.
     *
     * @param username The username of the profile to fetch.
     * @return The Profile object associated with the given username, or null if not found.
     */
    Profile getProfile(String username);

    /**
     * Fetches a list of profiles that match the given search criteria.
     * @param finds The search criteria to match.
     */
    void save(Finds finds);

    /**
     * Fetches a list of all document IDs (usernames) in the profiles collection.
     * @return A list of usernames in the profiles collection.
     * @throws Exception if there is an error during the fetch operation.
     */
    List<String> getNames() throws Exception;

    /**
     * Fetches the request status between the current user and another user.
     * @param otherUserId The username of the other user.
     * @param isAccepted The request status between the current user and the other user.
     */
    void setRequestStatus(String otherUserId, Boolean isAccepted);
}
