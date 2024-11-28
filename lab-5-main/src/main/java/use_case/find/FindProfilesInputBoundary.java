package use_case.find;

import java.util.Map;

public interface FindProfilesInputBoundary {
    Map<String, Double> execute(FindProfileInputData findProfileInputData);
}
