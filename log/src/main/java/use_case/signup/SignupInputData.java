package use_case.signup;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {

    private final String username;
    private final String password;
    private final String repeatPassword;
    private final String securityCode;

    public SignupInputData(String username, String password, String repeatPassword, String securityCode) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.securityCode = securityCode;
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

    public String getSecurityCode() { return securityCode;}
}
