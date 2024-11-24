package view;

import entity.Matches;
import entity.Requests;
import interface_adapter.matches.MatchesViewModel;
import interface_adapter.matches.MatchesController;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class MatchesView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "matches";
    private final MatchesViewModel matchesViewModel;
    private final MatchesController matchesController;
    private final List<Matches> matchess;
    private final JButton back;

    public MatchesView(MatchesController matchesControllerr, MatchesViewModel matchesViewModel, List<Matches> matches){
            this.matchesViewModel = matchesViewModel;
            this.matchesController = matchesControllerr;
            this.matchess = matches;
            this.matchesViewModel.addPropertyChangeListener(this);
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            final JLabel title = new JLabel("Matches");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);

            this.add(title);

            for(int i = 1; i <= matchess.size(); i++) {
                final JPanel match = new JPanel();
                Matches matchi = matches.get(i);
                JLabel username = new JLabel(matchi.getName());
                JLabel contactMethod = new JLabel(String.valueOf(matchi.getContactMethod()));
                JLabel contactInfo = new JLabel(String.valueOf(matchi.getContactInfo()));
                match.add(username);
                match.add(contactMethod);
                match.add(contactInfo);
                match.setLayout(new BoxLayout(match,BoxLayout.X_AXIS));
                this.add(match);
            }

            back = new JButton(matchesViewModel.BACK_BUTTON_LABEL);
            this.add(back);
            // Add action listener for the "View profile" button



            // Add action listener for the "back" button
            back.addActionListener(e -> {
                if (matchesController != null) {
                    matchesController.switchToDashboard();
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


