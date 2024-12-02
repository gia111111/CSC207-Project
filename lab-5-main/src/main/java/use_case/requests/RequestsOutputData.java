package use_case.requests;

import java.util.HashMap;

public class RequestsOutputData {
    private final String name;
    private final boolean useCaseFailed;

    public RequestsOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {return name;}

    public boolean isUseCaseFailed() {return useCaseFailed;}

}
