package view;

import entity.Matches;
import interface_adapter.dashboard.DashBoardController;
import interface_adapter.matches.MatchesController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class MatchesView extends JPanel implements ActionListener, PropertyChangeListener {
    private final Matches matches;
    private final MatchesController controller;
    private final JList<String> matchList;
    private final JButton backButton;

    public MatchesView(Matches matches, MatchesController controller) {
        this.matches = matches;
        this.controller = controller;

        // Set layout and background
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Display match data in a list
        matchList = new JList<>(convertMatchesToArray(matches));
        matchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(matchList);

        add(scrollPane, BorderLayout.CENTER);

        // Add back button
        backButton = new JButton("Back to Dashboard");
        backButton.addActionListener(e -> controller.switchToDashboard());
        add(backButton, BorderLayout.SOUTH);
    }

    private String[] convertMatchesToArray(Matches matches) {
        return matches.getMatches().entrySet().stream()
                .map(entry -> entry.getKey() + " (" + entry.getValue().get(0) + ": " + entry.getValue().get(1) + ")")
                .toArray(String[]::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("back".equals(e.getActionCommand())) {
            // Navigate back to the dashboard
            controller.switchToDashboard();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("matchesUpdated".equals(evt.getPropertyName())) {
            // Update the match list dynamically when matches are updated
            matchList.setListData(convertMatchesToArray(matches));
        }
    }
}

