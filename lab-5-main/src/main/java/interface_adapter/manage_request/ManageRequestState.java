package interface_adapter.manage_request;

public class ManageRequestState {
    private String errorMessage;

    public  ManageRequestState(){
        this.errorMessage = "";
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
