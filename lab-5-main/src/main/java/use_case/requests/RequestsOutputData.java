package use_case.requests;

import java.util.HashMap;

public class RequestsOutputData {
    private final HashMap<String, Double> scoresMap;

    private final boolean useCaseFailed;

    public RequestsOutputData(boolean useCaseFailed, HashMap<String, Double> scoresMap) {
        this.useCaseFailed = useCaseFailed;
        this.scoresMap = scoresMap;
    }


    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public HashMap<String, Double> getScoresMap() {
        return scoresMap;
    }
}
