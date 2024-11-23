package use_case.manageRequest;

import entity.Match;
import entity.Profile;
import entity.Request;

public interface ManageRequestUserDataAccessInterface {
    /**
     * The user accepts this request.
     * Saves this request into matches.
     */
    void save(Match match);

    /**
     * The user rejects this request.
     * Deletes this request from requests
     */
    void delete(Request request);

    String getContactMethod(String username);

    String getContactInfo(String username);

    Profile getProfile(String username);

    }

