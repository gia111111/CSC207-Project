package use_case.find;

import java.util.Map;

/**
 * An interface for the Find use case.
 */
public interface FindInputBoundary {

    /**
     * Fetches a list of profiles that match the given search criteria.
     * @param findInputData The search criteria to match.
     * @return A list of profiles that match the search criteria.
     */
    Map<String, Double> execute(FindInputData findInputData);

    /**
     * Fetches the request status between the current user and another user.
     * @param otherUserId The username of the other user.
     * @param isAccepted The request status between the current user and the other user.
     */
    void setRequestStatus(String otherUserId, Boolean isAccepted);
}
