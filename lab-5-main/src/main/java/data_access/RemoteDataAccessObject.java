package data_access;

import entity.Request;
import entity.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONObject;

import java.io.IOException;

public class RemoteDataAccessObject {
    private static final String BASE_URL = "http://your-remote-server.com/api";
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();

    public void saveUser(User user) throws IOException {
        JSONObject json = new JSONObject();
        json.put("name", user.getName());
        json.put("password", user.getPassword());
        json.put("securityWord", user.getSecurityWord());
    }

}
