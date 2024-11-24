package interface_adapter.manage_request;

public class ManageRequestState {
    private String errorMessage;
    private String username = "";
    private double scores;
    private boolean status;

    public  ManageRequestState(){
        this.errorMessage = "";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUsername() {
        return  username;
    }

    public double getScores() {
        return scores;
    }

    public boolean isStatus() {
        return status;
    }
}
