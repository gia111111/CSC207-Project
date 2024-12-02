package use_case.requests;

import java.util.HashMap;

public class RequestsOutputData {
    private final String name;
    private final boolean useCaseFailed;

    public RequestsOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {return name;}

    public boolean isUseCaseFailed() {return useCaseFailed;}
//    private final HashMap<String, Double> scoresMap;
//    private final HashMap<String, Boolean> statusMap;
//    private final boolean useCaseFailed;
//
//    public RequestsOutputData(boolean useCaseFailed, HashMap<String, Double> scoresMap, HashMap<String,Boolean> statusMap) {
//        this.useCaseFailed = useCaseFailed;
//        this.scoresMap = scoresMap;
//        this.statusMap = statusMap;
//    }
//
//
//    public boolean isUseCaseFailed() {
//        return useCaseFailed;
//    }
//
//    public HashMap<String, Double> getScoresMap() {
//        return scoresMap;
//    }
//
//    public HashMap<String, Boolean> getStatusMap() {
//        return statusMap;
//    }

}
