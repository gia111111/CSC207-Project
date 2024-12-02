package view;

import interface_adapter.find.FindProfilesController;
import interface_adapter.find.FindState;
import interface_adapter.find.FindViewModel;
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

    private final FindViewModel findViewModel; // ViewModel
    private FindProfilesController findProfilesController; // Controller
    private final DefaultTableModel tableModel;
    private final JTable table;

    public FindView(FindViewModel findViewModel) {
        this.findViewModel = findViewModel;
        this.findProfilesController = findProfilesController;

        // Register as a listener for property changes in the ViewModel
        this.findViewModel.addPropertyChangeListener(this);

        // Set layout
        setLayout(new BorderLayout());
        setBackground(MaterialColors.WHITE);

        // Create the table model
        tableModel = new DefaultTableModel(new String[]{"Username", "Score", "Actions"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only the Actions column is editable
                return column == 2;
            }
        };

        // Create the JTable
        table = new JTable(tableModel);
        table.setRowHeight(40);

        // Set custom renderer for the Actions column
        table.getColumnModel().getColumn(2).setCellRenderer(new ActionsRenderer());
        table.getColumnModel().getColumn(2).setCellEditor(new ActionsEditor());

        // Customize table appearancex
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
        returnButton.setForeground(MaterialColors.PINK_100);
        add(returnButton, BorderLayout.SOUTH);

        // Add a Load button at the top
        JButton loadButton = new JButton("Press to start browsing!");
        loadButton.setBackground(MaterialColors.PINK_100);
        loadButton.setForeground(MaterialColors.WHITE);
        add(loadButton, BorderLayout.NORTH);
        loadButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(loadButton)) {
                        refreshTable(); // Refresh the table on Load button click
                    }
                }
        );
    }

    /**
     * Refreshes the table with the latest data from the ViewModel.
     */
    private void refreshTable() {
        // Clear existing rows
        tableModel.setRowCount(0);

        // Get current state from the ViewModel
        final FindState currentState = findViewModel.getState();

        // Populate table with data from the ViewModel's state
        Map<String, Double> scores = findProfilesController.findProfiles(currentState.getScores(), currentState.getActions());
        if (scores != null) {
            for (Map.Entry<String, Double> entry : scores.entrySet()) {
                tableModel.addRow(new Object[]{entry.getKey(), entry.getValue(), "Actions"});
            }
        }
    }

    /**
     * Handles property change events from the ViewModel.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            refreshTable(); // Refresh the table whenever the state changes
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked: " + e.getActionCommand());
    }

    /**
     * Custom renderer for the Actions column.
     */
    private class ActionsRenderer extends JPanel implements TableCellRenderer {
        public ActionsRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            removeAll();

            JButton acceptButton = new JButton("Like");
            JButton rejectButton = new JButton("Dislike");

            acceptButton.addActionListener(e -> handleAction(row, "Like"));
            rejectButton.addActionListener(e -> handleAction(row, "Dislike"));

            add(acceptButton);
            add(rejectButton);

            return this;
        }
    }

    /**
     * Custom editor for the Actions column.
     */
    private class ActionsEditor extends AbstractCellEditor implements TableCellEditor {
        private final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        private final JButton acceptButton = new JButton("Like");
        private final JButton rejectButton = new JButton("Dislike");
        private int currentRow;

        public ActionsEditor() {
            acceptButton.addActionListener(e -> handleAction(currentRow, "Like"));
            rejectButton.addActionListener(e -> handleAction(currentRow, "Dislike"));

            panel.add(acceptButton);
            panel.add(rejectButton);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            currentRow = row; // Keep track of the row being edited
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }

    /**
     * Handles the "Accept" or "Reject" action for a specific row.
     */
    private void handleAction(int row, String action) {
        //String currentUserId = findViewModel.getState().getName(); // Get current user from ViewModel
        String otherUserId = (String) table.getValueAt(row, 0); // Get other user's ID from the table

        System.out.println(action + " button clicked for user: " + otherUserId);

        // Notify the controller to handle the action
        findProfilesController.handleAction(otherUserId, action);

        // Stop editing (if needed)
        table.editCellAt(row, -1);
        firePropertyChange("state", null, null); // Optionally refresh the table
    }

    public String getViewName() {
        return "find";
    }

    public void setFindProfilesController(FindProfilesController findProfilesController) {
        this.findProfilesController = findProfilesController;
    }
}
