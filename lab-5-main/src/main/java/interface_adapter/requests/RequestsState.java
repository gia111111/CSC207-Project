package interface_adapter.requests;

public class RequestsState {
    private String requestName;
    private String errorMessage;

//   // public RequestsState() {
//        this.currentState = "";
//    }

    public String getRequestName(){
        return requestName;
    }

    public void setRequestName(String name) {
        this.requestName = name;
    }

    public void setErrorMessage(String error) {
        this.errorMessage = error;

    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
