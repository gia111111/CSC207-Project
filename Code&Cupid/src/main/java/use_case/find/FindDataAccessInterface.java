package use_case.find;

import entity.Finds;
import entity.Profile;

import java.util.List;

public interface FindDataAccessInterface {
    /**
     * Fetches a profile for the given username.
     *
     * @param username The username of the profile to fetch.
     * @return The Profile object associated with the given username, or null if not found.
     */
    Profile getProfile(String username);

    void save(Finds finds);

    /**
     * Fetches a list of all document IDs (usernames) in the profiles collection.
     *
     * @return A list of usernames in the profiles collection.
     * @throws Exception if there is an error during the fetch operation.
     */
    List<String> getNames() throws Exception;
    void setRequestStatus(String otherUserId, Boolean isAccepted);
}
