package view;

import interface_adapter.dashboard.DashBoardViewModel;
import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.requests.RequestsController;
import interface_adapter.requests.RequestsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class RequestsView extends JPanel implements ActionListener, PropertyChangeListener{
    private final String viewName = "requests";
    private final RequestsViewModel requestsViewModel;
    private final RequestsController requestController;

    private final JButton viewProfile;
    private final JButton back;

    public RequestsView(RequestsController requestController, RequestsViewModel requestsViewModel){
        this.requestsViewModel = requestsViewModel;
        this.requestController = requestController;
        this.requestsViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Requests");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        final JPanel buttons = new JPanel();
        viewProfile = new JButton(requestsViewModel.VIEW_PROFILE_BUTTON_LABEL);
        buttons.add(viewProfile);

        back = new JButton(requestsViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);
        buttons.setLayout(new BoxLayout(buttons,BoxLayout.X_AXIS));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);

        this.add(buttons);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }
}
