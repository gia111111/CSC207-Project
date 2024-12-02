package use_case.matches;

import java.util.List;

import entity.Matches;

/**
 * An interface for the Matches data access object use case.
 */
public interface MatchesDataAccessObject {
    /**
     * Saves matches to document with the same name as the current Users username in the collections called
     * "matches".
     * @param matches The matches to save.
     */
    void save(Matches matches);

    /**
     * If User username exists, retrieves users contactMethod and contactInfo from their profile.
     *
     * @param username The username of the User to retrieve contact info for.
     * @return List of Strings containing the contactMethod and contactInfo of the User.
     */
    List<String> getContactCard(String username);

    /**
     * Retrieves current Users requests from the collection titled "requests" in the document with the same
     * name as the current Users username.
     * @param username  The username of the User to retrieve requests for.
     * @return List of other users' username for which current User liked during the request use case.
     */
    List<String> getRequests(String username);

}
