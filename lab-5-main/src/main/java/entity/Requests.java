package entity;

import java.util.HashMap;

/**
 * the requests entity includes a collection of requests, where the key is the name
 */
public class Requests {
    private HashMap<String, Boolean> requests;

    public Requests(HashMap<String, Boolean> requests) {
        this.requests = requests;
    }

    public HashMap<String, Boolean> getRequests() {
        return requests;
    }
}
