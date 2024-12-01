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

//    @Override
//    public void switchToDashBoardView(){
//        userPresenter.switchToDashBoardView();
//    }

    @Override
    public HashMap<String, Double> execute(RequestsInputData requestsInputData) {
        System.out.println("interactor1");
        String username = requestsInputData.getUsername();
        HashMap<String, Double> scoresMap = new HashMap<>();
        //String username = requestsInputData.getUsername();
        // HashMap<String, Double> scoresMap = new HashMap<>();
        try {
            final List<String> names = requestsDataAccessInterface.getNames();
            System.out.println("Interactor2");
           // String username = "abby"; // debug test
            if (names.isEmpty()) {
                throw new IllegalArgumentException("No names found.");
            }
            names.remove(username);
            // HashMap<String, Double> scoresMap = new HashMap<>();
            HashMap<String, Boolean> matches = new HashMap<>();
            for (String partnerName: names) {
                System.out.println("interactor 4");
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
//            if (requestsDataAccessInterface.isValidRequest(username, partnerName)) {
//                Profile myProfile = requestsDataAccessInterface.getProfile(username);
//                Profile partnerProfile = requestsDataAccessInterface.getProfile(partnerName);
//                Double score = compatibilityAlgorithm2.calculateScore(myProfile, partnerProfile);
//                scoresMap.put(partnerName, score);
//                matches.put(partnerName, null);
//                }
//                System.out.println("interactor" + scoresMap);
//                System.out.println("interactor" + matches);
            }

        Requests requests = new Requests(matches,scoresMap);
            requestsDataAccessInterface.save(requests);
//        RequestsOutputData requestsOutputData = new RequestsOutputData(false,scoresMap, matches);
            RequestsOutputData requestsOutputData = new RequestsOutputData(requestsInputData.getUsername(), false);
            outputBoundary.prepareSuccessView(requestsOutputData);
            System.out.println("interactor3");
        return scoresMap;

    } catch (Exception evt) {
        // Handle exceptions and pass error messages to the presenter
        outputBoundary.prepareFailView("Error getting requests: " + evt.getMessage());
    }
        return scoresMap;
    }

    //        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


    @Override
    public HashMap<String,Boolean> accept(RequestsInputData requestsInputData) {
        String myName = requestsDataAccessInterface.getCurrentUsername();
        requestsDataAccessInterface.updateSatus(myName, requestsInputData.getPartnername(), true);
//        final RequestsOutputData requestsOutputData = new RequestsOutputData(myName, partnerName, false);
//        userPresenter.prepareSuccessView(requestsOutputData);

        return requestsDataAccessInterface.getRequestsActionsMap(myName);
    }


    @Override
    public HashMap<String, Boolean> reject(RequestsInputData requestsInputData) {
        String myName = requestsDataAccessInterface.getCurrentUsername();
        requestsDataAccessInterface.updateSatus(myName, requestsInputData.getPartnername(), false);
//        final RequestsOutputData requestsOutputData = new RequestsOutputData(myName, partnerName, false);
//        userPresenter.prepareSuccessView(requestsOutputData);

        return requestsDataAccessInterface.getRequestsActionsMap(myName);


        }
//    @Override
//    public void switchToDashBoardView() {
//        userPresenter.switchToDashBoardView();
//    }
}
