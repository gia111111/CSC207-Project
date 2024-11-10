package use_case.change_password;

/**
 * The input data for the Change Password Use Case.
 */
public class ChangePasswordInputData {

    private final String password;
    private final String username;
    private String securityCode;

    public ChangePasswordInputData(String password, String username, String securityCode) {
        this.password = password;
        this.username = username;
        this.securityCode = securityCode;
    }

    String getPassword() {
        return password;
    }

    String getUsername() { return username;}

    String getSecurityCode() { return securityCode;}
}
