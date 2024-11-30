package view;

import entity.Profile;
import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfileState;
import interface_adapter.profile.ProfileViewModel;
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
import java.util.Map;

public class RequestsView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "requests";
    private  RequestsViewModel requestsViewModel;
    private RequestsController requestsController;
    private final JLabel profileErrorField = new JLabel();
    private final JButton back;

    public RequestsView(RequestsViewModel requestsViewModel) {
        this.requestsViewModel = requestsViewModel;
        this.requestsViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final JLabel title = new JLabel(requestsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 32));
        this.add(title);

        RequestsState requestsState = requestsViewModel.getState();
        String currentUserName = requestsState.getCurrentUserName();

        if(!(requestsController == null)) {
            HashMap<String, Double> scoresMap = requestsController.execute(currentUserName);
            ArrayList<Map.Entry<String, Double>> entryList = new ArrayList<>(scoresMap.entrySet());
            JPanel requestsCollection = new JPanel();
            requestsCollection.setLayout(new BoxLayout(requestsCollection, BoxLayout.Y_AXIS));
            JPanel currentRequester = null;
            for (int i = 1; i <= scoresMap.size(); i++) {
                currentRequester = new JPanel();
                Map.Entry<String, Double> entry = entryList.get(i);
                String partnername = entry.getKey();
                Double myScore = entry.getValue();
                JLabel partner = new JLabel(partnername);
                JLabel score = new JLabel(String.valueOf(myScore));
                JButton acceptButton = new JButton("accept");
                JButton rejectButton = new JButton("reject");
                currentRequester.add(partner);
                currentRequester.add(score);
                currentRequester.add(acceptButton);
                currentRequester.add(rejectButton);
                currentRequester.setLayout(new BoxLayout(currentRequester, BoxLayout.X_AXIS));
                acceptButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                if (evt.getSource().equals(acceptButton)) {
                                    final RequestsState currentState = requestsViewModel.getState();

                                    HashMap<String, Boolean> newActionsMap =
                                            requestsController.accept(currentState.getCurrentUserName(), partnername);
                                    currentState.setActionsToRequests(newActionsMap);
                                    requestsViewModel.setState(currentState);




                                }
                            }
                        });
                rejectButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                if (evt.getSource().equals(rejectButton)) {

                                    final RequestsState currentState = requestsViewModel.getState();

                                    HashMap<String, Boolean> newActionsMap =
                                            requestsController.reject(currentState.getCurrentUserName(), partnername);
                                    currentState.setActionsToRequests(newActionsMap);
                                    requestsViewModel.setState(currentState);
                                }
                            }
                        });
            }
            requestsCollection.add(currentRequester);
        }


        // Add action listener for the "back" button
        back = new JButton(requestsViewModel.BACK_BUTTON_LABEL);
        this.add(back);


        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
                            final RequestsState currentState = requestsViewModel.getState();
                            if (requestsController != null) {
                                requestsController.switchToDashboard();
                            }


                        }
                    }
                });
//        back.addActionListener(e -> {
//            if (requestsController != null) {
//                requestsController.switchToDashboard();
//            }
//        });

    }


        @Override
        public void actionPerformed (ActionEvent e){

        }

        @Override
        public void propertyChange (PropertyChangeEvent evt){
            RequestsState state = (RequestsState) evt.getNewValue();
            if (state.getErrorMessage() != null) {
                JOptionPane.showMessageDialog(this, state.getErrorMessage());
            }

        }

    public void setRequestsController(RequestsController requestsController) {
        this.requestsController = requestsController;
    }

    public String getViewName() {
        return viewName;
    }
}
