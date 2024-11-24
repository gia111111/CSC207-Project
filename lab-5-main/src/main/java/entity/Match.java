package entity;

import java.time.LocalDateTime;

public class Match {
    private String name;
    private String contact_method;
    private String contact_info;
    private final String profileImageUrl;

    public Match(String name, String contact_method, String contact_info, String profileImageUrl) {
        this.name = name;
        this.contact_method = contact_method;
        this.contact_info = contact_info;
        this.profileImageUrl = profileImageUrl;
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

    public String getProfileImageUrl() { return profileImageUrl; }
}
