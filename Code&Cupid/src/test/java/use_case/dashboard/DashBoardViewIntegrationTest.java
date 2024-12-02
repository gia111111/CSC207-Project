package use_case.dashboard;

import interface_adapter.ViewManagerModel;
import interface_adapter.dashboard.DashBoardController;
import interface_adapter.dashboard.DashBoardViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.DashBoardView;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class DashBoardViewIntegrationTest {
    private DashBoardView dashBoardView;
    private DashBoardViewModel dashBoardViewModel;
    private DashBoardController dashBoardController;

    @BeforeEach
    public void setUp() {
        dashBoardViewModel = new DashBoardViewModel();
        dashBoardController = new DashBoardController(new ViewManagerModel());
        dashBoardView = new DashBoardView(dashBoardViewModel, dashBoardController);
    }

    @Test
    void testButtonsAreDisplayed() {
        assertNotNull(findButtonByName(dashBoardView, "My Profile"));
        assertNotNull(findButtonByName(dashBoardView, "Requests"));
        assertNotNull(findButtonByName(dashBoardView, "Compatibility"));
        assertNotNull(findButtonByName(dashBoardView, "Matches"));
        assertNotNull(findButtonByName(dashBoardView, "Logout"));
    }

    @Test
    void testLogoutButtonAction() {
        JButton logoutButton = findButtonByName(dashBoardView, "Logout");
        assert logoutButton != null;
        logoutButton.doClick();
        // Add assertions to check if the view was redirected to "home"
    }

    private JButton findButtonByName(JPanel panel, String name) {
        for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals(name)) {
                    return button;
                }
            }
        }
        return null;
    }
}
