package entity;

import java.util.HashMap;

/**
 * the finds entity includes a collection of finds, where the key is the name
 * of the find and the value is a boolean value indicating if the user would like
 * to send a request to the other user.
 */

public class Finds {
    private HashMap<String, Boolean> finds;

    public Finds(HashMap<String, Boolean> finds) {
        this.finds = finds;
    }

    public HashMap<String, Boolean> getFinds() {
        return finds;
    }
}
