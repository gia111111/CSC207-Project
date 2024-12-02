package use_case.requests;

/**
 * The output data for the Requests use case.
 */
public class RequestsOutputData {
    private final String name;
    private final boolean useCaseFailed;

    public RequestsOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return name;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
