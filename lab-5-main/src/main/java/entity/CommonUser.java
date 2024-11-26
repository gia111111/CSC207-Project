package entity;

/**
 * A simple implementation of the User interface.
 */
public class CommonUser implements User {

    private final String name;
    private String password;
    private final String securityCode;

    public CommonUser(String name, String password, String securityCode) {
        this.name = name;
        this.password = password;
        this.securityCode = securityCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getSecurityWord() { return securityCode; }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
