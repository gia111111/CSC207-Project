package interface_adapter.change_password;

/**
 * The State information representing the logged-in user.
 */
public class ChangedPasswordState {
    private String username = "";

    private String password = "";
    private String repeatPassword = "";
    private String passwordError;
    private String securityWord = "";

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }


    public String getSecurityWord() {
        return securityWord;
    }

    public void setSecurityWord(String securityWord) {
        this.securityWord = securityWord;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "LoggedInState{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
//                + ", security='" + security + '\''
                + ", passwordError='" + passwordError + '\''
                + ", securityWord='" + securityWord + '\''
                + '}';
    }
}
