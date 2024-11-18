package interface_adapter.requests;

public class RequestsState {
    private String currentState;

    public RequestsState() {
        this.currentState = "";
    }

    public String getCurrentState(){
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}
