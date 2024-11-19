package view;

import interface_adapter.dashboard.DashBoardController;
import interface_adapter.dashboard.DashBoardViewModel;

import java.awt.Component;
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
    private final JButton compatibility;
    private final JButton matches;
    private final JButton logout;

    public DashBoardView(DashBoardViewModel dashboardViewModel, DashBoardController dashBoardController) {
        this.dashBoardController = dashBoardController;
        this.dashBoardViewModel = dashboardViewModel;

        dashboardViewModel.addPropertyChangeListener(this);

        // Set layout and title
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final JLabel title = new JLabel(DashBoardViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        myProfile = new JButton(DashBoardViewModel.PROFILE_BUTTON_LABEL);
        requests = new JButton(DashBoardViewModel.REQUESTS_BUTTON_LABEL);
        compatibility = new JButton(DashBoardViewModel.COMPATIBILITY_BUTTON_LABEL);
        matches = new JButton(DashBoardViewModel.MATCHES_BUTTON_LABEL);
        logout = new JButton(DashBoardViewModel.LOGOUT_BUTTON_LABEL);

        // Set alignment for all buttons
        myProfile.setAlignmentX(Component.CENTER_ALIGNMENT);
        requests.setAlignmentX(Component.CENTER_ALIGNMENT);
        compatibility.setAlignmentX(Component.CENTER_ALIGNMENT);
        matches.setAlignmentX(Component.CENTER_ALIGNMENT);
        logout.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add buttons to the panel
        this.add(Box.createVerticalStrut(20)); // Add space between components
        this.add(myProfile);
        this.add(requests);
        this.add(compatibility);
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
