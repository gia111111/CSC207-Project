package interface_adapter.dashboard;

public class DashBoardState {
    private String currentSection;

    public DashBoardState() {
        this.currentSection = "";
    }

    public String getCurrentSection() {
        return currentSection;
    }

    public void setCurrentSection(String currentSection) {
        this.currentSection = currentSection;
    }
}
