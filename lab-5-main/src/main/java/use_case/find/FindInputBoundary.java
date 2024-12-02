package use_case.find;

import java.util.Map;

public interface FindInputBoundary {
    Map<String, Double> execute(FindInputData findInputData);
    void setRequestStatus(String otherUserId, Boolean isAccepted);
}
