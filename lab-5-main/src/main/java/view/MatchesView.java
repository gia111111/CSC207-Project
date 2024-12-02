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
    private final JLabel profileErrorField = new JLabel();
    private final DefaultTableModel tableModel;
    private final JTable table;

    public MatchesView(MatchesViewModel matchesViewModel) {
        this.matchesViewModel = matchesViewModel;
        matchesViewModel.addPropertyChangeListener(this);

        setLayout(new BorderLayout());

        final JLabel title = new JLabel(matchesViewModel.TITLE_LABEL);
        this.add(title);

        tableModel = new DefaultTableModel(new String[]{"Match Username", "Contact Method", "Contact Information"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        table.setModel(tableModel);
        System.out.println(table.getModel() == tableModel);
        table.setRowHeight(30);
        table.setBackground(MaterialColors.WHITE);
        table.setSelectionBackground(MaterialColors.LIGHT_BLUE_400);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        JButton dashboard = new JButton("Dashboard");
        dashboard.addActionListener(evt -> matchesController.switchToDashBoardView());
        dashboard.setForeground(MaterialColors.BLUE_800);
        dashboard.setBackground(MaterialColors.PINK_100);
        add(dashboard, BorderLayout.SOUTH);

        JButton load = new JButton("Press to load all matches!");
        load.setBackground(MaterialColors.PINK_100);
        load.setForeground(MaterialColors.BLUE_800);
        load.addActionListener(evt -> {
                    if (evt.getSource().equals(load)) {
                        refreshTable(); // Refresh the table on Load button click
                    }
                }
        );
        add(load, BorderLayout.NORTH);

    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        final MatchesState currentState = matchesViewModel.getState();
        Map<String, List<String>> matchesContact = matchesController.execute(currentState.getMatchContacts());
        System.out.println("view" + matchesContact);
        if (matchesContact.size() != 0) {
            for(Map.Entry<String, List<String>> entry: matchesContact.entrySet()) {
                System.out.println(entry.getValue().get(0));
                System.out.println(entry.getValue().get(1));
                tableModel.addRow(new String[]{entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)});
                System.out.println("addRow");
            }
        } else {
            tableModel.addRow(new String[]{"Sorry", "No matches currently", "Go to Finds to search for matches."});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final MatchesState state = (MatchesState) evt.getNewValue();
        profileErrorField.setText(state.getErrorMessage());
    }

    public void setMatchesController(MatchesController matchesController) {
        this.matchesController = matchesController;
    }

    public String getViewName() {
        return viewName;
    }
}
