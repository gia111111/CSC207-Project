package use_case.requests;

import entity.Matches;
import entity.Requests;

import java.util.HashMap;

public interface RequestsDataAccessInterface {
    HashMap<String, Boolean> getRequests(String username);
    void saveMatches(String myName, String partnerName);
//    void deleteRequest();

}
