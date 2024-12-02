package use_case.matches;

import java.util.List;
import java.util.Map;

/**
 * An interface for the Matches use case.
 */
public interface MatchesInputBoundary {

    /**
     * Executes the Matches Use case.
     *
     * @param matchesInputData The input data for the Matches use case.
     * @return A map of the matches.
     */
    Map<String, List<String>> execute(MatchesInputData matchesInputData);

    /**
     * Executes the switch to dashboard view use case.
     */
    void switchToDashBoardView();

}
