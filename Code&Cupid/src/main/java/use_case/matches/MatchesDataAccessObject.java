package use_case.matches;

import entity.Matches;

import java.util.List;

public interface MatchesDataAccessObject {
    /**
     * Saves matches to document with the same name as the current Users username in the collections called
     * "matches".
     * @param matches
     */
    void save(Matches matches);

    /**
     * If User username exists, retrieves this users contactMethod and contactInfo from their profile.
     *
     * @param username
     * @return
     */
    List<String> getContactCard(String username);

    /**
     * Retrieves current Users requests from the collection titled "requests" in the document with the same
     * name as the current Users username.
     * @param username
     * @return List of other users' username for which current User liked during the request use case.
     */
    List<String> getRequests(String username);

}
