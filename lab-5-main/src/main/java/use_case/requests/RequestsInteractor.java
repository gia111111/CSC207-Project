package use_case.requests;

import entity.Profile;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class RequestsInteractor implements RequestsInputBoundary{
    private final RequestsOutputBoundary userPresenter;
    private final RequestsDataAccessInterface requestsDataAccessInterface;
    private final CompatibilityAlgorithm compatibilityAlgorithm;

    public RequestsInteractor(RequestsOutputBoundary outputBoundary, RequestsDataAccessInterface requestsDataAccessInterface,
                              CompatibilityAlgorithm compatibilityAlgorithm) {
        this.userPresenter = outputBoundary;
        this.requestsDataAccessInterface = requestsDataAccessInterface;
        this.compatibilityAlgorithm = compatibilityAlgorithm;
    }

//    @Override
//    public void switchToDashBoardView(){
//        userPresenter.switchToDashBoardView();
//    }

    @Override
    public HashMap<String, Double> execute(String username) {
        HashMap<String, Double> scoresMap = new HashMap<>();
        try {
            String myname = username;
            List<String> names = requestsDataAccessInterface.getNames();
            names.remove(myname);
            // HashMap<String, Double> scoresMap = new HashMap<>();
           // HashMap<String, Boolean> matches = new HashMap<>();
            for (int i = 1; i <= names.size(); i++) {
                String partnerName = names.get(i);
                if (requestsDataAccessInterface.isValidRequest(myname, partnerName)) {
                    Profile myProfile = requestsDataAccessInterface.getProfile(myname);
                    Profile partnerProfile = requestsDataAccessInterface.getProfile(partnerName);
                    Double score = compatibilityAlgorithm.calculateScore(myProfile, partnerProfile);
                    scoresMap.put(partnerName, score);
                }
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return scoresMap;
    }


    @Override
    public HashMap<String,Boolean> accept(RequestsInputData inputData) {
        String myName = inputData.getUsername();
        String partnerName = inputData.getPartnername();
        requestsDataAccessInterface.updateSatus(myName, partnerName, true);
        final RequestsOutputData requestsOutputData = new RequestsOutputData(myName, partnerName, false);
        userPresenter.prepareSuccessView(requestsOutputData);

        return requestsDataAccessInterface.getRequestsActionsMap(myName);
    }


    @Override
    public HashMap<String, Boolean> reject(RequestsInputData requestsInputData) {
        String myName = requestsInputData.getUsername();
        String partnerName = requestsInputData.getPartnername();
        requestsDataAccessInterface.updateSatus(myName, partnerName, false);
        final RequestsOutputData requestsOutputData = new RequestsOutputData(myName, partnerName, false);
        userPresenter.prepareSuccessView(requestsOutputData);

        return requestsDataAccessInterface.getRequestsActionsMap(myName);


        }
    @Override
    public void switchToDashBoardView() {
        userPresenter.switchToDashBoardView();
    }
}
