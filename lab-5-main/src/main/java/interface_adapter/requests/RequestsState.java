package interface_adapter.requests;

import java.util.HashMap;

public class RequestsState {
    private String username = "";
    HashMap<String, Boolean> finds = new HashMap<>();
    private String errorMessage;

//    public RequestsState() {
//        this.currentState = "";
//    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String usename){
        this.username = usename;
    }

    public HashMap<String, Boolean> getFinds() {
        return finds;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
