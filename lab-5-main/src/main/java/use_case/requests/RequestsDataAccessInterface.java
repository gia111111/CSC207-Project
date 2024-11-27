package use_case.requests;

import entity.Matches;
import entity.Requests;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public interface RequestsDataAccessInterface {
    HashMap<String, Boolean> getRequests(String username) throws ExecutionException, InterruptedException;
    // void saveMatches(String myName, String partnerName);
    void updateSatus(String myName, String partnerName, Boolean requestAccpeted);
;

}
