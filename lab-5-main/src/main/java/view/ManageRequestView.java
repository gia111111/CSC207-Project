package view;

import data_access.RemoteDataAccessObject;
import interface_adapter.manage_request.ManageRequestController;
import interface_adapter.manage_request.ManageRequestViewModel;

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


        final JPanel Profile = new JPanel();
        remoteDataAccessObject.get();



        this.add(Profile);

        final JPanel reaction = new JPanel();
        acceptButton = new JButton(ManageRequestViewModel.ACCEPT_BUTTON_LABEL);
        rejectButton = new JButton(ManageRequestViewModel.REJECT_BUTTON_LABEL);
        backButton = new JButton(ManageRequestViewModel.BACK_BUTTON_LABEL);
        reaction.add(acceptButton);
        reaction.add(rejectButton);
        reaction.add(backButton);
        reaction.setLayout(new BoxLayout(reaction,BoxLayout.X_AXIS));
        this.add(reaction);



    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
