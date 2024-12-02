package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.dashboard.DashBoardController;
import interface_adapter.dashboard.DashBoardViewModel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

/**
 * Initiates the Dashboard View.
 */
public class DashBoardView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "dashboard";

    private final DashBoardViewModel dashBoardViewModel;
    private final DashBoardController dashBoardController;

    private final JButton myProfile;
    private final JButton requests;
    private final JButton find;
    private final JButton matches;
    private final JButton logout;

    /**
     * Initiate Dashboard view.
     * @param dashboardViewModel model for view.
     * @param dashBoardController controller for view.
     */
    public DashBoardView(DashBoardViewModel dashboardViewModel, DashBoardController dashBoardController) {
        this.dashBoardController = dashBoardController;
        this.dashBoardViewModel = dashboardViewModel;

        dashboardViewModel.addPropertyChangeListener(this);

        // Set layout and title
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(MaterialColors.WHITE);

        // Add a title label
        final JLabel title = new JLabel(DashBoardViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Roboto", Font.BOLD, 20));
        title.setForeground(MaterialColors.BLUE_800);
        this.add(Box.createVerticalStrut(20));
        this.add(title);

        myProfile = createMaterialButton(DashBoardViewModel.PROFILE_BUTTON_LABEL);
        requests = createMaterialButton(DashBoardViewModel.REQUESTS_BUTTON_LABEL);
        find = createMaterialButton(DashBoardViewModel.COMPATIBILITY_BUTTON_LABEL);
        matches = createMaterialButton(DashBoardViewModel.MATCHES_BUTTON_LABEL);
        logout = createMaterialButton(DashBoardViewModel.LOGOUT_BUTTON_LABEL);

        // Set alignment for all buttons
        myProfile.setAlignmentX(Component.CENTER_ALIGNMENT);
        requests.setAlignmentX(Component.CENTER_ALIGNMENT);
        find.setAlignmentX(Component.CENTER_ALIGNMENT);
        matches.setAlignmentX(Component.CENTER_ALIGNMENT);
        logout.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons to the panel
        this.add(Box.createVerticalStrut(20));
        this.add(myProfile);
        this.add(find);
        this.add(requests);
        this.add(matches);
        this.add(Box.createVerticalStrut(20));
        this.add(logout);

        // Add action listener for the "Logout" button
        logout.addActionListener(evt -> {
            if (dashBoardController != null) {
                dashBoardController.switchToLogout();
            }
        });

        myProfile.addActionListener(evt -> {
            if (dashBoardController != null) {
                dashBoardController.switchToProfile();
            }
        });

        // Add action listener for the "requests" button
        requests.addActionListener(evt -> {
            if (dashBoardController != null) {
                dashBoardController.switchToRequestsView();
            }
        });

        find.addActionListener(evt -> {
            if (dashBoardController != null) {
                dashBoardController.switchToFindView();
            }
        });

        matches.addActionListener(evt -> {
            if (dashBoardController != null) {
                dashBoardController.switchToMatchesView();
            }
        });
    }

    private JButton createMaterialButton(String text) {
        final JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Roboto", Font.PLAIN, 14));
        button.setBackground(MaterialColors.LIGHT_BLUE_400);
        button.setForeground(MaterialColors.BLUE_800);

        // Add hover effect
        MaterialUIMovement.add(button, MaterialColors.BLUE_800);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("currentSection".equals(evt.getPropertyName())) {
            System.out.println("Dashboard section updated: " + dashBoardViewModel.getState().getCurrentSection());
        }
    }

    public String getViewName() {
        return viewName;
    }
}
