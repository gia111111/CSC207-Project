package use_case.requests;

public class RequestsInputData {
    private final String username;

    public RequestsInputData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
