package view;

import interface_adapter.matches.MatchesState;
import interface_adapter.matches.MatchesController;
import interface_adapter.matches.MatchesViewModel;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchesView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "matches";
    private final MatchesViewModel matchesViewModel;
    private MatchesController matchesController;
    private final DefaultTableModel tableModel;
    private final JTable table;

    public MatchesView(MatchesViewModel matchesViewModel) {
        this.matchesViewModel = matchesViewModel;
        matchesViewModel.addPropertyChangeListener(this);

        setLayout(new BorderLayout());

        final JLabel title = new JLabel(matchesViewModel.TITLE_LABEL);
        this.add(title);
        tableModel = new DefaultTableModel(new String[]{"Match Username", "Contact Method", "Contact Information"}, 0);
        table = new JTable(tableModel);
        table.setRowHeight(30);
        table.setBackground(MaterialColors.PINK_100);
        table.setSelectionBackground(MaterialColors.PINK_500);
        this.add(table);

        JButton dashboard = new JButton("Dashboard");
        dashboard.addActionListener(evt -> matchesController.switchToDashBoardView());
        dashboard.setForeground(MaterialColors.WHITE);
        dashboard.setBackground(MaterialColors.PINK_100);
        this.add(dashboard, BorderLayout.SOUTH);

        JButton load = new JButton("Press to load all matches!");
        load.setBackground(MaterialColors.PINK_100);
        load.setForeground(MaterialColors.WHITE);
        load.addActionListener(evt -> {
                    if (evt.getSource().equals(load)) {
                        refreshTable(); // Refresh the table on Load button click
                    }
                }
        );
        this.add(load, BorderLayout.NORTH);
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        final MatchesState currentState = matchesViewModel.getState();
        Map<String, List<String>> matchesContact = matchesController.execute(currentState.getMatchContacts());
        if (matchesContact != null) {
            for(Map.Entry<String, List<String>> entry: matchesContact.entrySet()) {
                tableModel.addRow(new Object[]{entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)});
            }
        }
//        Map<String, List<String>> matchesContact = new HashMap<>();
//        List<String> contact1 = new ArrayList<>();
//        contact1.add("instagram");
//        contact1.add("@blub");
//        List<String> contact2 = new ArrayList<>();
//        contact2.add("Wechat");
//        contact2.add("@bloop");
//        matchesContact.put("hello", contact1);
//        matchesContact.put("hi", contact2);
//        for (Map.Entry<String, List<String>> entry : matchesContact.entrySet()) {
//            tableModel.addRow(new Object[]{entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        final MatchesState state = (MatchesState) evt.getNewValue();
//        profileErrorField.setText(state.getErrorMessage());
    }

    public void setMatchesController(MatchesController matchesController) {
        this.matchesController = matchesController;
    }

    public String getViewName() {
        return viewName;
    }
}
