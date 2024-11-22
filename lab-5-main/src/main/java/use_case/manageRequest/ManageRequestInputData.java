package use_case.manageRequest;

public class ManageRequestInputData {
    private String requestName;
    private double scores;
    private Boolean status;

    public ManageRequestInputData(String name, double scores, Boolean status){
        this.requestName = name;
        this.scores = scores;
        this.status = status;

    }

    public double getScores() {
        return scores;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getRequestName() {
        return requestName;
    }
}
