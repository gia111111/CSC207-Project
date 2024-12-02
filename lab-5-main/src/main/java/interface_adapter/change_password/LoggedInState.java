package interface_adapter.change_password;

/**
 * The State information representing the logged-in user.
 */
public class LoggedInState {
    private String username = "";

    private String password = "";
    private String repeatPassword = "";
//    private String security = "";
    // private String userNotExistError;
    private String passwordError;
     private String securityWord = "";

//    public LoggedInState(LoggedInState copy) {
//        username = copy.username;
//        password = copy.password;
//        security = copy.security;
//        // userNotExistError = copy.userNotExistError;
//        passwordError = copy.passwordError;
//        securityWord = copy.securityWord;
//    }

    // Because of the previous copy constructor, the default constructor must be explicit.
//    public LoggedInState() {
//
//    }


    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

//    public void setSecurityWord(String securityWord) {
//        this.securityWord = securityWord;
//    }


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


//    public String getSecurityWord() { return securityWord; }

//    public String getUserNotExistError() {
//        return userNotExistError;
//    }

//    public String getSecurity() {
//        return security;
//    }
//
//    public void setSecurity(String security) {
//        this.security = security;
//    }

    public String toString() {
        return "LoggedInState{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
//                + ", security='" + security + '\''
                + ", passwordError='" + passwordError + '\''
                + ", securityWord='" + securityWord + '\''
                + '}';
    }

    

//    public String getRepeatPasswordError() {
//        return passwordError;
//    }

//    public void setUserNotExistError(String userNotExistError) {
//        this.userNotExistError = userNotExistError;
//    }

}
