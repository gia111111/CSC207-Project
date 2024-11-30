package use_case.requests;

import entity.Profile;

import java.util.HashMap;
import java.util.List;

public interface RequestsDataAccessInterface {
    List<String> getNames() throws Exception;

    Boolean isValidRequest(String myname, String partnerName);

    Profile getProfile(String myname);

    void updateSatus(String myName, String partnerName, Boolean requestAccpeted);

    HashMap<String, Boolean> getRequestsActionsMap(String myName);
}
