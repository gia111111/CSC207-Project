package use_case.signup;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {

    private final String username;
    private final String password;
    private final String repeatPassword;
    private final String securityWord;

    public SignupInputData(String username, String password, String repeatPassword, String securityWord) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.securityWord = securityWord;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    String getSecurityWord() { return securityWord; }
}
