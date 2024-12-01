package use_case.requests;

import entity.Finds;
import entity.Profile;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RequestsInteractor implements RequestsInputBoundary{
    private final RequestsOutputBoundary userPresenter;
    private final RequestsDataAccessInterface requestsDataAccessInterface;
    private final CompatibilityAlgorithm2 compatibilityAlgorithm2;

    public RequestsInteractor(RequestsOutputBoundary outputBoundary, RequestsDataAccessInterface requestsDataAccessInterface,
                              CompatibilityAlgorithm2 compatibilityAlgorithm2) {
        this.userPresenter = outputBoundary;
        this.requestsDataAccessInterface = requestsDataAccessInterface;
        this.compatibilityAlgorithm2 = compatibilityAlgorithm2;
    }

//    @Override
//    public void switchToDashBoardView(){
//        userPresenter.switchToDashBoardView();
//    }

    @Override
    public HashMap<String, Double> execute(String username) {
        HashMap<String, Double> scoresMap = new HashMap<>();
        try {
            List<String> names = requestsDataAccessInterface.getNames();
             username = "abby"; // debug test
            names.remove(username);
            // HashMap<String, Double> scoresMap = new HashMap<>();
           // HashMap<String, Boolean> matches = new HashMap<>();
            for (String partnerName: names) {
                if (requestsDataAccessInterface.isValidRequest(username, partnerName)) {
                    Profile myProfile = requestsDataAccessInterface.getProfile(username);
                    Profile partnerProfile = requestsDataAccessInterface.getProfile(partnerName);
                    Double score = compatibilityAlgorithm2.calculateScore(myProfile, partnerProfile);
                    scoresMap.put(partnerName, score);
                }
            }
            RequestsOutputData requestsOutputData = new RequestsOutputData(false,scoresMap);
            userPresenter.prepareSuccessView(requestsOutputData);
//            return scoresMap;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return scoresMap;
    }

    //        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


    @Override
    public HashMap<String,Boolean> accept(RequestsInputData inputData) {
        String myName = inputData.getUsername();
        String partnerName = inputData.getPartnername();
        requestsDataAccessInterface.updateSatus(myName, partnerName, true);
//        final RequestsOutputData requestsOutputData = new RequestsOutputData(myName, partnerName, false);
//        userPresenter.prepareSuccessView(requestsOutputData);

        return requestsDataAccessInterface.getRequestsActionsMap(myName);
    }


    @Override
    public HashMap<String, Boolean> reject(RequestsInputData requestsInputData) {
        String myName = requestsInputData.getUsername();
        String partnerName = requestsInputData.getPartnername();
        requestsDataAccessInterface.updateSatus(myName, partnerName, false);
//        final RequestsOutputData requestsOutputData = new RequestsOutputData(myName, partnerName, false);
//        userPresenter.prepareSuccessView(requestsOutputData);

        return requestsDataAccessInterface.getRequestsActionsMap(myName);


        }
//    @Override
//    public void switchToDashBoardView() {
//        userPresenter.switchToDashBoardView();
//    }
}
