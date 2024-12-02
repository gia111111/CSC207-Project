package use_case.dashboard;
import interface_adapter.dashboard.DashBoardController;
import interface_adapter.ViewManagerModel;

public class DashBoardControllerTest {
    public static void main(String[] args) {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        DashBoardController dashBoardController = new DashBoardController(viewManagerModel);

        // Test handleLogout()
        dashBoardController.switchToLogout();
        if ("home".equals(viewManagerModel.getState())) {
            System.out.println("Test Passed: switchToLogout sets state to home");
        } else {
            System.out.println("Test Failed: switchToLogout did not set state to home");
        }
    }
}
