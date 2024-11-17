package use_case.change_password;

/**
 * The input data for the Change Password Use Case.
 */
public class ChangePasswordInputData {
    private final String username;
    private final String password;
    private final String repeatPassword;
    private final String security;

    public ChangePasswordInputData(String username, String password, String repeatPassword, String security) {
        this.password = password;
        this.username = username;
        this.repeatPassword = repeatPassword;
        this.security = security;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

    String getRepeatPassword() {return repeatPassword; }

    String getSecurity() {return security;}
}
