package use_case.requests;

public class RequestsOutputData {
    private final String name;
    private final String partnername;

    private final boolean useCaseFailed;

    public RequestsOutputData(String name, String partnername, boolean useCaseFailed) {
        this.name = name;
        this.partnername = partnername;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return name;
    }

    public String getPartnername() {
        return partnername;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
