package use_case.requests;

public class RequestsInputData {
    private final String username;
    private final String partnername;

    public RequestsInputData(String username, String partnername) {
        this.username = username;
        this.partnername = partnername;
    }

    public String getUsername() {
        return username;
    }

    public String getPartnername() {
        return partnername;
    }
}
