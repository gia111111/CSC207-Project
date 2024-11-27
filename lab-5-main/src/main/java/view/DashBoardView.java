package view;

import interface_adapter.dashboard.DashBoardController;
import interface_adapter.dashboard.DashBoardViewModel;

import mdlaf.utils.MaterialColors;
import mdlaf.animation.MaterialUIMovement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class DashBoardView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "dashboard";

    private final DashBoardViewModel dashBoardViewModel;
    private final DashBoardController dashBoardController;

    private final JButton myProfile;
    private final JButton requests;
    private final JButton find;
    private final JButton matches;
    private final JButton logout;

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
        this.add(Box.createVerticalStrut(20)); // Add spacing
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
        this.add(Box.createVerticalStrut(20)); // Add space between components
        this.add(myProfile);
        this.add(requests);
        this.add(find);
        this.add(matches);
        this.add(Box.createVerticalStrut(20)); // Add space before logout
        this.add(logout);

        // Add action listener for the "Logout" button
        logout.addActionListener(e -> {
            if (dashBoardController != null) {
                dashBoardController.switchToLogout();
            }
        });

        myProfile.addActionListener(e -> {
            if (dashBoardController != null) {
                dashBoardController.switchToProfile();
            }
        });

        find.addActionListener(e -> {
            if (dashBoardController != null) {
                dashBoardController.switchToFindView();
            }
        });
        matches.addActionListener(e -> dashBoardController.switchToMatchView()); // Switch to MatchViewFrame
    }

    private JButton createMaterialButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Roboto", Font.PLAIN, 14));
        button.setBackground(MaterialColors.LIGHT_BLUE_400);
        button.setForeground(MaterialColors.WHITE);

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
