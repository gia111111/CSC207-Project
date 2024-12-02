package use_case.requests;

import java.util.HashMap;

public interface RequestsInputBoundary {
    HashMap<String, Double> execute(RequestsInputData requestsInputData);

    HashMap<String,Boolean> accept(RequestsInputData requestsInputData);

    HashMap<String,Boolean> reject(RequestsInputData requestsInputData);
}
