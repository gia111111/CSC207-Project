package use_case.requests;

public class RequestsOutputData {
    private final String requestName;

    private final boolean useCaseFailed;

    public RequestsOutputData(String name, boolean useCaseFailed) {
        this.requestName = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getRequestName(){
        return requestName;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
