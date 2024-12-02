package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import interface_adapter.find.FindController;
import interface_adapter.find.FindState;
import interface_adapter.find.FindViewModel;
import mdlaf.utils.MaterialColors;

/**
 * Initiates Finds view.
 */
public class FindView extends JPanel implements ActionListener, PropertyChangeListener {

    private final FindViewModel findViewModel;
    private FindController findController;
    private final DefaultTableModel tableModel;
    private final JTable table;
    private final String like = "Like";
    private final String dislike = "Dislike";

    public FindView(FindViewModel findViewModel) {
        this.findViewModel = findViewModel;
        this.findController = findController;

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
        final JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        // Add "Return to Dashboard" button at the bottom
        final JButton returnButton = new JButton("Dashboard");
        returnButton.addActionListener(evt -> findController.switchToDashBoard());
        returnButton.setBackground(MaterialColors.PINK_100);
        returnButton.setForeground(MaterialColors.BLUE_800);
        add(returnButton, BorderLayout.SOUTH);

        // Add a Load button at the top
        final JButton loadButton = new JButton("Press to start browsing!");
        loadButton.setBackground(MaterialColors.PINK_100);
        loadButton.setForeground(MaterialColors.BLUE_800);
        add(loadButton, BorderLayout.NORTH);
        loadButton.addActionListener(
                evt -> {
                    if (evt.getSource().equals(loadButton)) {
                        refreshTable();
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
        final Map<String, Double> scores = findController.findProfiles(currentState.getScores(),
                currentState.getActions());
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
            refreshTable();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked: " + e.getActionCommand());
    }

    /**
     * Handles the "Accept" or "Reject" action for a specific row.
     * @param row in which action is being done.
     * @param action that is being done.
     */
    private void handleAction(int row, String action) {
        final String otherUserId = (String) table.getValueAt(row, 0);

        System.out.println(action + " button clicked for user: " + otherUserId);

        // Notify the controller to handle the action
        findController.handleAction(otherUserId, action);

        // Stop editing (if needed)
        table.editCellAt(row, -1);
        firePropertyChange("state", null, null);
    }

    public String getViewName() {
        return "find";
    }

    public void setFindProfilesController(FindController controller) {
        this.findController = controller;
    }

    /**
     * Custom renderer for the Actions column.
     */
    private class ActionsRenderer extends JPanel implements TableCellRenderer {
        ActionsRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        }

        @Override
        public Component getTableCellRendererComponent(JTable jTable, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            removeAll();

            final JButton acceptButton = new JButton(like);
            final JButton rejectButton = new JButton(dislike);

            acceptButton.addActionListener(evt -> handleAction(row, like));
            rejectButton.addActionListener(evt -> handleAction(row, dislike));

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
        private final JButton acceptButton = new JButton(like);
        private final JButton rejectButton = new JButton(dislike);
        private int currentRow;

        ActionsEditor() {
            acceptButton.addActionListener(evt -> handleAction(currentRow, like));
            rejectButton.addActionListener(evt -> handleAction(currentRow, dislike));

            panel.add(acceptButton);
            panel.add(rejectButton);
        }

        @Override
        public Component getTableCellEditorComponent(JTable jTable, Object value,
                                                     boolean isSelected, int row, int column) {
            currentRow = row;
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }
}
