package use_case.requests;

import entity.Profile;
import entity.Requests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RequestsDataAccessInterface {
    List<String> getNames() throws Exception;

    Boolean isValidRequest(String myname, String partnerName);

    Map<String, Boolean> getFinds(String partnerName);

    Profile getProfile(String myname);

    void updateSatus(String myName, String partnerName, Boolean requestAccpeted);

    HashMap<String, Boolean> getRequestsActionsMap(String myName);

    void save(Requests requests);

    String getCurrentUsername();


}
