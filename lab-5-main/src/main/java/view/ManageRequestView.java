package view;

import data_access.RemoteDataAccessObject;
import interface_adapter.manage_request.ManageRequestController;
import interface_adapter.manage_request.ManageRequestViewModel;
import interface_adapter.profile.ProfileViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ManageRequestView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "manage request";
    private final ManageRequestViewModel manageRequestViewModel;
    private RemoteDataAccessObject remoteDataAccessObject;
    private ManageRequestController manageRequestController;
    private JButton accepet;
    private JButton reject;

    public ManageRequestView(ManageRequestViewModel manageRequestViewModel,
                             ManageRequestController manageRequestController){
        this.manageRequestViewModel = manageRequestViewModel;
        this.manageRequestController = manageRequestController;

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
