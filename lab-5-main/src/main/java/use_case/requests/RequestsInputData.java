package use_case.requests;

public class RequestsInputData {
    private String requestName;

    public RequestsInputData(String requestName){
        this.requestName = requestName;
    }

    public String getRequestName() {
        return requestName;
    }
}
