package use_case.requests;

public class RequestsOutputData {
    private final String myName;
    private final String partnerName;

    private final boolean useCaseFailed;

    public RequestsOutputData(String name, String partnername, boolean useCaseFailed) {
        this.myName = name;
        this.partnerName = partnername;
        this.useCaseFailed = useCaseFailed;
    }

    public String getMyName() {
        return myName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
