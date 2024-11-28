package view;

import interface_adapter.find.FindProfilesController;
import interface_adapter.find.FindState;
import interface_adapter.find.FindViewModel;
import interface_adapter.logout.LogoutController;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class FindView extends JPanel implements ActionListener, PropertyChangeListener {

    private final FindViewModel findViewModel;
    private FindProfilesController findProfilesController;
    private final DefaultTableModel tableModel;
    private final JTable table;

    public FindView(FindViewModel findViewModel, FindProfilesController findProfilesController) {
        this.findViewModel = findViewModel;
        this.findProfilesController = findProfilesController;

        // Register as a listener for property changes in the view model
        this.findViewModel.addPropertyChangeListener(this);

        // Set Material Look and Feel
        try {
            UIManager.setLookAndFeel(new mdlaf.MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Set layout
        setLayout(new BorderLayout());
        setBackground(MaterialColors.WHITE);

        // Create the table model
        tableModel = new DefaultTableModel(new String[]{"Username", "Score", "Actions"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make only the Actions column editable
                return column == 2;
            }
        };

        // Create the JTable
        table = new JTable(tableModel);
        table.setRowHeight(40);
        table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox()));

        // Customize table appearance
        table.setBackground(MaterialColors.WHITE);
        table.setSelectionBackground(MaterialColors.LIGHT_BLUE_400);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        // Add "Return to Dashboard" button at the bottom
        JButton returnButton = new JButton("Dashboard");
        returnButton.addActionListener(e -> findProfilesController.switchToDashBoard());
        returnButton.setBackground(MaterialColors.LIGHT_BLUE_400);
        returnButton.setForeground(MaterialColors.WHITE);
        add(returnButton, BorderLayout.SOUTH);

        // Populate the table with initial data
        refreshTable();
    }

    /**
     * Refresh the table data based on the current state in the view model.
     */
    private void refreshTable() {
        // Clear existing rows
        tableModel.setRowCount(0);
        final FindState currentState = findViewModel.getState();

        // Populate table with data from the model
        Map<String, Double> scores = findProfilesController.findProfiles(currentState.getScores(), currentState.getActions());
        if (scores != null) {
            for (Map.Entry<String, Double> entry : scores.entrySet()) {
                tableModel.addRow(new Object[]{entry.getKey(), entry.getValue(), "Actions"});
            }
        }
    }

//    private void refreshTable() {
//        tableModel.setRowCount(0);
//
//    }

    /**
     * Handles property change events from the view model.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            refreshTable(); // Refresh the table when the state changes
        }
    }

    /**
     * Handles button actions.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle global button actions if needed
        System.out.println("Button clicked: " + e.getActionCommand());
    }

    /**
     * Returns the name of this view.
     */
    public String getViewName() {
        return "find";
    }
    public void setFindProfilesController(FindProfilesController findProfilesController) {
        // TODO: save the logout controller in the instance variable.
        this.findProfilesController = findProfilesController;
    }
}