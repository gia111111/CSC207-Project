package use_case.requests;

import java.util.HashMap;

public interface RequestsInputBoundary {
    void switchToDashBoardView();
    HashMap<String, Double> execute(RequestsInputData requestsInputData);
}
