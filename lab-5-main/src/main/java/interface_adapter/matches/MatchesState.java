package interface_adapter.matches;

public class MatchesState {
    private String currentState;

    public MatchesState() {
        this.currentState = "";
    }

    public String getCurrentState(){
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }
}

