package use_case.manageRequest;

public class ManageRequestOutputData {
    private String requestName;
    private boolean useCaseFailed;
    private boolean requestAccepted;


    public ManageRequestOutputData(String name, boolean useCaseFailed, boolean requestAccepted){
        this.requestName = name;
        this.useCaseFailed = useCaseFailed;
        this.requestAccepted = requestAccepted;
    }


    public String getName() {
        return requestName;
    }

    // Getter method to check if the use case failed
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public boolean isRequestAccepted(){
        return requestAccepted;
    }
}
