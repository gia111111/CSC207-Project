package use_case.find;

import entity.Finds;

/**
 * An interface for the Find use case.
 */
public interface FindOutputBoundary {

    /**
     * Presents the list of profiles that match the given search criteria.
     * @param finds The search criteria to match.
     */
    void presentFinds(Finds finds);

    /**
     * Presents an error message.
     * @param error The error message to present.
     */
    void presentError(String error);
}
