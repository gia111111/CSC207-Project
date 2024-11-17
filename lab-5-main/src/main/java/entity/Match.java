package entity;

public class Match {
    private String name;
    private String contact_method;
    private String contact_info;

    public Match(String name, String contact_method, String contact_info) {
        this.name = name;
        this.contact_method = contact_method;
        this.contact_info = contact_info;
    }

    public String getName() {
        return name;
    }

    public String getContactMethod() {
        return contact_method;
    }

    public String getContactInfo() {
        return contact_info;
    }
}
