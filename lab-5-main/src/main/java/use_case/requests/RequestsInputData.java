package use_case.requests;

import java.util.HashMap;

public class RequestsInputData {
    private String myName;
    private String partnerName;
//    private HashMap<String, Boolean> finds;

    public RequestsInputData(String myName, String pertnerName){
        this.myName = myName;
        this.partnerName = pertnerName;
    }

    public String getMyName() {
        return myName;
    }

    public String getPartnerName() {
        return partnerName;
    }
}
