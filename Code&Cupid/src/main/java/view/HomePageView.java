package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.home.HomePageController;
import interface_adapter.home.HomePageState;
import interface_adapter.home.HomePageViewModel;
import mdlaf.utils.MaterialColors;

/**
 * The View for when the user is logging into the program.
 */
public class HomePageView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "home";
    private final HomePageViewModel homeViewModel;
    private HomePageController homePageController;

    private final JButton toLoginButton;
    private final JButton toSignupButton;
    private final JButton toResetPasswordButton;

    /**
     * Initialize Home View.
     * @param homeViewModel model for HomeView.
     * @param homePageController controller for Home page.
     */
    public HomePageView(HomePageViewModel homeViewModel, HomePageController homePageController) {
        this.homeViewModel = homeViewModel;
        this.homePageController = homePageController;

        // Register this view as a listener to the view model
        this.homeViewModel.addPropertyChangeListener(this);

        // Set the layout to BoxLayout with Y_AXIS for vertical alignment
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Title label
        final JLabel titleLabel = new JLabel(HomePageViewModel.TITLE_LABEL);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createVerticalStrut(50));
        this.add(titleLabel);

        // Add space after the title
        this.add(Box.createVerticalStrut(30));

        // Create the main panel with BoxLayout for vertical alignment
        final JPanel centeredPanel = new JPanel();
        centeredPanel.setLayout(new BoxLayout(centeredPanel, BoxLayout.Y_AXIS));
        centeredPanel.setOpaque(false);
        // Ensure the panel blends with its parent

        // Add the privacy label
        final JLabel privacyLabel = new JLabel(
                "<html><div align='center'>At Code & Cupid, we take your privacy seriously.<br>"
                        + "We are committed to protecting your personal information and ensuring transparency "
                        + "in how it is used.</body></html>"
        );
        privacyLabel.setFont(new Font("Roboto", Font.ITALIC, 12));
        privacyLabel.setForeground(MaterialColors.PINK_200);
        privacyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        privacyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        centeredPanel.add(privacyLabel);

        // Add spacing between the label and buttons
        centeredPanel.add(Box.createVerticalStrut(20));

        // Add the login button
        toLoginButton = new JButton(HomePageViewModel.LOGIN_BUTTON_LABEL);
        toLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centeredPanel.add(toLoginButton);

        // Add spacing between buttons
        centeredPanel.add(Box.createVerticalStrut(10));

        // Add the signup button
        toSignupButton = new JButton(HomePageViewModel.SIGNUP_BUTTON_LABEL);
        toSignupButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centeredPanel.add(toSignupButton);

        // Add spacing between buttons
        centeredPanel.add(Box.createVerticalStrut(10));

        // Add the reset password button
        toResetPasswordButton = new JButton(HomePageViewModel.RESET_PASSWORD_BUTTON_LABEL);
        toResetPasswordButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centeredPanel.add(toResetPasswordButton);

        // Add the centered panel to the NORTH region to align it at the top
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(centeredPanel);

        toLoginButton.addActionListener(evt -> homePageController.switchToLoginView());
        toSignupButton.addActionListener(evt -> homePageController.switchToSignupView());
        toResetPasswordButton.addActionListener(evt -> homePageController.switchToResetPasswordView());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final HomePageState state = (HomePageState) evt.getNewValue();
        if (state.getErrorMessage() != null) {
            JOptionPane.showMessageDialog(this, state.getErrorMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Get the action command to determine which button was clicked
        final String command = evt.getActionCommand();

        // Handle different button actions based on the command
        switch (command) {
            case "Log In":
                System.out.println("Navigating to Log In");
                homePageController.switchToLoginView();
                break;
            case "Sign Up":
                System.out.println("Navigating to Sign Up");
                homePageController.switchToSignupView();
                break;
            case "Reset Password":
                System.out.println("Navigating to Reset Password");
                homePageController.switchToResetPasswordView();
                break;
            default:
                System.out.println("Unknown action: " + command);
                JOptionPane.showMessageDialog(this, "Action not implemented yet.");
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setHomePageController(HomePageController controller) {
        this.homePageController = controller;
    }

    public JButton getToLoginButton() {
        return toLoginButton;
    }

    public JButton getToSignupButton() {
        return toSignupButton;
    }

    public JButton getToResetPasswordButton() {
        return toResetPasswordButton;
    }
}
