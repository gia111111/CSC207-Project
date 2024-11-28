package view;

import data_access.RemoteDataAccessObject;
import entity.Profile;
import interface_adapter.requests.RequestsController;
import interface_adapter.requests.RequestsState;
import interface_adapter.requests.RequestsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestsView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "requests";
    private final RequestsViewModel requestsViewModel;
    private RequestsController requestController;
    private final JButton back;

    public RequestsView(RequestsViewModel requestsViewModel,RemoteDataAccessObject remoteDataAccessObject,
                        BasicCompatibilityAlgorithm basicCompatibilityAlgorithm){
        this.requestsViewModel = requestsViewModel;
        this.requestsViewModel.addPropertyChangeListener(this);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        RequestsState currentState = requestsViewModel.getState();

        // Add title
        final JLabel title = new JLabel("Requests");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(title);

        HashMap<String, Boolean> requests = remoteDataAccessObject.getRequests(currentState.getUsername());
        List<Map.Entry<String, Boolean>> entryList = new ArrayList<>(requests.entrySet());


        final JPanel allRequestsPanel = new JPanel();


        for(int i = 1; i <= requests.size(); i++) {
            final JPanel curentRequest = new JPanel();
            Map.Entry<String, Boolean> entry = entryList.get(i);
            String partnername = entry.getKey();
            JLabel userNameLabel = new JLabel(partnername);
            Profile myProfile = remoteDataAccessObject.getProfile(currentState.getUsername());
            Profile partnerProfile = remoteDataAccessObject.getProfile(partnername);
            String myScore = String.valueOf(basicCompatibilityAlgorithm.calculateScore(myProfile,partnerProfile));
            JLabel score = new JLabel(myScore);
            curentRequest.add(userNameLabel);
            curentRequest.add(score);
            JButton acceptButton = new JButton("accept");
            JButton rejectButton = new JButton("reject");
            curentRequest.add(acceptButton);
            curentRequest.add(rejectButton);
            curentRequest.setLayout(new BoxLayout(curentRequest,BoxLayout.X_AXIS));

            acceptButton.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(acceptButton)) {

                                final RequestsState currentState = requestsViewModel.getState();

                                requestController.accept(currentState.getUsername(),partnername);
                                // requests.replace(partnername, true);

                            }
                        }
                    }
            );

            rejectButton.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            if (evt.getSource().equals(rejectButton)) {

                                final RequestsState currentState = requestsViewModel.getState();
                                // requests.replace(partnername, false);
                                requestController.reject(currentState.getUsername(), partnername);

                            }
                        }
                    }
            );



            allRequestsPanel.add(curentRequest);
        }

        this.add(allRequestsPanel);



        back = new JButton(requestsViewModel.BACK_BUTTON_LABEL);
        this.add(back);

        // Add action listener for the "back" button
        back.addActionListener(e -> {
            if (requestController != null) {
                requestController.switchToDashboard();
            }
        });


    }


    public String getViewName() {
        return viewName;
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        RequestsState state = (RequestsState) evt.getNewValue();
        if (state.getErrorMessage() != null) {
            JOptionPane.showMessageDialog(this, state.getErrorMessage());
        }
    }

    public void setRequestsController(RequestsController requestsController){
        this.requestController = requestsController;

    }
}
