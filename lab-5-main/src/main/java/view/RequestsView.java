package view;

import entity.Request;
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
import java.util.List;

public class RequestsView extends JPanel implements ActionListener, PropertyChangeListener{
    private final String viewName = "requests";
    private final RequestsViewModel requestsViewModel;
    private final RequestsController requestController;
    private final List<Request> requests;
    private JButton viewProfile;
    private final JButton back;

    public RequestsView(RequestsController requestController, RequestsViewModel requestsViewModel, List<Request> requests){
        this.requestsViewModel = requestsViewModel;
        this.requestController = requestController;
        this.requests =requests;
        this.requestsViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JLabel title = new JLabel("Requests");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(title);

        for(int i = 1; i <= requests.size(); i++) {
            final JPanel request = new JPanel();
            Request requesti = requests.get(i);
            JLabel username = new JLabel(requesti.getName());
            JLabel score = new JLabel(String.valueOf(requesti.getScores()));
            JLabel status = new JLabel(String.valueOf(requesti.getStatus()));
            viewProfile = new JButton(requestsViewModel.VIEW_PROFILE_BUTTON_LABEL);
            request.add(username);
            request.add(score);
            request.add(status);
            request.add(viewProfile);
            request.setLayout(new BoxLayout(request,BoxLayout.X_AXIS));
            this.add(request);
        }

        back = new JButton(requestsViewModel.BACK_BUTTON_LABEL);
        this.add(back);
        // Add action listener for the "View profile" button



        // Add action listener for the "back" button
        back.addActionListener(e -> {
            if (requestController != null) {
                requestController.switchToDashboard();
            }
        });

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
