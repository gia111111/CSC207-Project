package use_case.requests;

import data_access.RemoteDataAccessObject;

public class RequestsInputData {
    private final String username;
    private final String partnername;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public RequestsInputData(RemoteDataAccessObject remoteDataAccessObject, String partnername) {
        this.remoteDataAccessObject = remoteDataAccessObject;
        this.username = remoteDataAccessObject.getCurrentUsername();
        this.partnername = partnername;
    }


    public String getUsername() {
        return username;
    }

    public String getPartnername() {
        return partnername;
    }
}
