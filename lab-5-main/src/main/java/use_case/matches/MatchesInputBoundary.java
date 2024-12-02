package use_case.matches;

import java.util.List;
import java.util.Map;

public interface MatchesInputBoundary {

    /**
     * Executes the Matches Use case.
     *
     * @param matchesInputData
     * @return
     */
    Map<String, List<String>> execute (MatchesInputData matchesInputData);

    /**
     * Executes the switch to dashboard view use case.
     */
    void switchToDashBoardView();

}