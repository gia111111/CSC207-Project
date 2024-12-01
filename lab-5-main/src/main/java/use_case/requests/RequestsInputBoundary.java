package use_case.requests;

import java.util.HashMap;

public interface RequestsInputBoundary {
//    void switchToDashBoardView();
    HashMap<String, Double> execute(String username);

    HashMap<String,Boolean> accept(RequestsInputData requestsInputData);

    HashMap<String,Boolean> reject(RequestsInputData requestsInputData);
}
