package view;

import data_access.RemoteDataAccessObject;
import entity.Profile;
import interface_adapter.login.LoginState;
import interface_adapter.manage_request.ManageRequestController;
import interface_adapter.manage_request.ManageRequestState;
import interface_adapter.manage_request.ManageRequestViewModel;
import interface_adapter.signup.SignupState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class ManageRequestView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "manage request";
    private final ManageRequestViewModel manageRequestViewModel;
    private RemoteDataAccessObject remoteDataAccessObject;
    private ManageRequestController manageRequestController;
    private JButton acceptButton;
    private JButton rejectButton;
    private JButton backButton;

    public ManageRequestView(ManageRequestViewModel manageRequestViewModel,
                             ManageRequestController manageRequestController,
                             RemoteDataAccessObject remoteDataAccessObject){
        this.manageRequestViewModel = manageRequestViewModel;
        this.manageRequestController = manageRequestController;
        this.remoteDataAccessObject = remoteDataAccessObject;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel("Manage the Request");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);


        final JPanel profilePanel = new JPanel();
        final ManageRequestState currentState = manageRequestViewModel.getState();
        Profile profile = remoteDataAccessObject.getProfile(currentState.getUsername());
        JLabel name = new JLabel("Name: " + profile.getName());
        JLabel gender = new JLabel("Gender: " + profile.getGender());
        JLabel sexualOrientation = new JLabel("Sexual orientation: " + profile.getSexualOrientation());
        JLabel age = new JLabel("Age: "+ profile.getAge());
        JLabel answer = new JLabel("Answer: "+ profile.getAnswer());

        profilePanel.add(name);
        profilePanel.add((gender));
        profilePanel.add(sexualOrientation);
        profilePanel.add(age);
        profilePanel.add(answer);
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));



        this.add(profilePanel);

        final JPanel reaction = new JPanel();
        acceptButton = new JButton(ManageRequestViewModel.ACCEPT_BUTTON_LABEL);
        rejectButton = new JButton(ManageRequestViewModel.REJECT_BUTTON_LABEL);
        backButton = new JButton(ManageRequestViewModel.BACK_BUTTON_LABEL);
        reaction.add(acceptButton);
        reaction.add(rejectButton);
        reaction.add(backButton);
        reaction.setLayout(new BoxLayout(reaction,BoxLayout.X_AXIS));
        this.add(reaction);

        // Add action listener for the "acceptButton" button
        acceptButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(acceptButton)) {
                            final ManageRequestState currentState = manageRequestViewModel.getState();

                            manageRequestController.accept(
                                    currentState.getUsername(),
                                    currentState.getScores(),
                                    currentState.isStatus()
                            );
                        }
                    }
                }
        );

        // Add action listener for the "rejectButton" button
        rejectButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(rejectButton)) {
                            final ManageRequestState currentState = manageRequestViewModel.getState();

                            manageRequestController.reject(
                                    currentState.getUsername(),
                                    currentState.getScores(),
                                    currentState.isStatus()
                            );
                        }
                    }
                }
        );

        // Add action listener for the "backButton" button
        backButton.addActionListener(e -> {
            if (manageRequestController != null) {
                manageRequestController.switchToRequestsView();
            }
        });



    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
