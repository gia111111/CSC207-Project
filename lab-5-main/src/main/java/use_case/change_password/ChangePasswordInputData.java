package use_case.change_password;

/**
 * The input data for the Change Password Use Case.
 */
public class ChangePasswordInputData {

    private final String password;
    private final String username;
    private final String repeatPassword;
    private final String securityWord;

    public ChangePasswordInputData(String password, String username, String repeatPassword, String securityWord) {
        this.password = password;
        this.username = username;
        this.repeatPassword = repeatPassword;
        this.securityWord = securityWord;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }


    String getSecurityWord() { return securityWord; }

    String getRepeatPassword() { return repeatPassword; }
}
