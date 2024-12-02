package use_case.requests;

import java.util.HashMap;

/**
 * An interface for the Requests use case.
 */
public interface RequestsInputBoundary {

    /**
     * Executes the Requests Use case.
     *
     * @param requestsInputData The input data for the Requests use case.
     * @return A map of the requests.
     */
    HashMap<String, Double> execute(RequestsInputData requestsInputData);

    /**
     * Executes the accept request use case.
     * @param requestsInputData The input data for the Requests use case.
     * @return a map of users that requested current user and the status current user has towards them,
     *      or null if an error occurs
     */
    HashMap<String, Boolean> accept(RequestsInputData requestsInputData);

    /**
     * Executes the reject request use case.
     * @param requestsInputData The input data for the Requests use case.
     * @return A map of the requests.
     */
    HashMap<String, Boolean> reject(RequestsInputData requestsInputData);
}
