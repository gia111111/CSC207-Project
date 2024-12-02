package use_case.requests;

import data_access.RemoteDataAccessObject;
import entity.Profile;
import entity.Requests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestsInteractor implements RequestsInputBoundary{
    private final RequestsOutputBoundary outputBoundary;
    private final RequestsDataAccessInterface requestsDataAccessInterface;
    private final CompatibilityAlgorithm2 compatibilityAlgorithm2;

    public RequestsInteractor(RequestsOutputBoundary outputBoundary, RequestsDataAccessInterface requestsDataAccessInterface,
                              CompatibilityAlgorithm2 compatibilityAlgorithm2) {
        this.outputBoundary= outputBoundary;
        this.requestsDataAccessInterface = requestsDataAccessInterface;
        this.compatibilityAlgorithm2 = compatibilityAlgorithm2;
    }

    @Override
    public HashMap<String, Double> execute(RequestsInputData requestsInputData) {
        String username = requestsInputData.getUsername();
        HashMap<String, Double> scoresMap = new HashMap<>();
        try {
            final List<String> names = requestsDataAccessInterface.getNames();
            if (names.isEmpty()) {
                throw new IllegalArgumentException("No names found.");
            }
            names.remove(username);
            HashMap<String, Boolean> matches = new HashMap<>();
            for (String partnerName: names) {
                Map<String, Boolean> partnerFindResults = requestsDataAccessInterface.getFinds(partnerName);
                if (partnerFindResults.containsKey(username)) {
                    if (!partnerFindResults.containsKey(username) || !Boolean.TRUE.equals(partnerFindResults.get(username))) {
                        continue;
                    }
                        matches.put(partnerName, null);
                        Profile myProfile = requestsDataAccessInterface.getProfile(username);
                        Profile partnerProfile = requestsDataAccessInterface.getProfile(partnerName);
                        Double score = compatibilityAlgorithm2.calculateScore(myProfile, partnerProfile);
                        scoresMap.put(partnerName, score);
                }
            }

        Requests requests = new Requests(matches,scoresMap);
            requestsDataAccessInterface.save(requests);
            RequestsOutputData requestsOutputData = new RequestsOutputData(requestsInputData.getUsername(), false);
            outputBoundary.prepareSuccessView(requestsOutputData);
        return scoresMap;

    } catch (Exception evt) {
        // Handle exceptions and pass error messages to the presenter
        outputBoundary.prepareFailView("Error getting requests: " + evt.getMessage());
    }
        return scoresMap;
    }



    @Override
    public HashMap<String,Boolean> accept(RequestsInputData requestsInputData) {
        String myName = requestsDataAccessInterface.getCurrentUsername();
        requestsDataAccessInterface.updateSatus(myName, requestsInputData.getPartnername(), true);
        return requestsDataAccessInterface.getRequestsActionsMap(myName);
    }


    @Override
    public HashMap<String, Boolean> reject(RequestsInputData requestsInputData) {
        String myName = requestsDataAccessInterface.getCurrentUsername();
        requestsDataAccessInterface.updateSatus(myName, requestsInputData.getPartnername(), false);
        return requestsDataAccessInterface.getRequestsActionsMap(myName);


        }
}
