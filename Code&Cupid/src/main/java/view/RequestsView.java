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

import interface_adapter.requests.RequestsController;
import interface_adapter.requests.RequestsViewModel;
import mdlaf.utils.MaterialColors;

/**
 * Initializes Requests view.
 */
public class RequestsView extends JPanel implements ActionListener, PropertyChangeListener {

    private final RequestsViewModel requestsViewModel;
    private RequestsController requestsController;
    private final DefaultTableModel tableModel;
    private final JTable table;

    public RequestsView(RequestsViewModel requestsViewModel) {
        this.requestsViewModel = requestsViewModel;
        this.requestsController = requestsController;

        // Register as a listener for property changes in the ViewModel
        requestsViewModel.addPropertyChangeListener(this);

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
        table.setRowHeight(requestsViewModel.ROW_HEIGHT);

        // Set custom renderer for the Actions column
        table.getColumnModel().getColumn(2).setCellRenderer(new ActionsRenderer());
        table.getColumnModel().getColumn(2).setCellEditor(new ActionsEditor());

        // Customize table appearance
        table.setBackground(MaterialColors.WHITE);
        table.setSelectionBackground(MaterialColors.LIGHT_BLUE_400);

        // Add the table to a scroll pane
        final JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        // Add "Return to Dashboard" button at the bottom
        final JButton returnButton = new JButton("Dashboard");
        returnButton.addActionListener(evt -> requestsController.switchToDashboard());
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
                        // Refresh the table on Load button click
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
        System.out.println("view refresh table");

        // Populate table with data from the ViewModel's state
        final Map<String, Double> scores = requestsController.execute();
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
            // Refresh the table whenever the state changes
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Button clicked: " + evt.getActionCommand());
    }

    public void setRequestsController(RequestsController requestsController) {
        this.requestsController = requestsController;
    }

    /**
     * Handles the "Accept" or "Reject" action for a specific row.
     * @param row tells you row in which this action is happening.
     * @param isAccepted tells you if current user accepted request of other user.
     */
    private void handleAction(int row, Boolean isAccepted) {
        final String otherUserId = (String) table.getValueAt(row, 0);
        // Get other user's ID from the table

        System.out.println(isAccepted + " button clicked for user: " + otherUserId);

        // String myName = requestsViewModel.getState().getCurrentUserName();

        // Accept case
        if (isAccepted) {
            requestsController.accept(otherUserId);
        }
        // Reject case

        if (!isAccepted) {
            requestsController.reject(otherUserId);
        }

        // Stop editing (if needed)
        table.editCellAt(row, -1);
        firePropertyChange("state", null, null);
        // Optionally refresh the table
    }

    public String getViewName() {
        return "requests";
    }

    /**
     * Custom renderer for the Actions column.
     */
    private class ActionsRenderer extends JPanel implements TableCellRenderer {
        ActionsRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, requestsViewModel.FLOW_PARAMETER,
                    requestsViewModel.FLOW_PARAMETER));
        }

        @Override
        public Component getTableCellRendererComponent(JTable jTable, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            removeAll();

            final JButton acceptButton = new JButton("Accept");
            final JButton rejectButton = new JButton("Reject");

            acceptButton.addActionListener(evt -> handleAction(row, true));
            rejectButton.addActionListener(evt -> handleAction(row, false));

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
        private final JButton acceptButton = new JButton("Accept");
        private final JButton rejectButton = new JButton("Reject");
        private int currentRow;

        ActionsEditor() {
            acceptButton.addActionListener(evt -> handleAction(currentRow, true));
            rejectButton.addActionListener(evt -> handleAction(currentRow, false));

            panel.add(acceptButton);
            panel.add(rejectButton);
        }

        @Override
        public Component getTableCellEditorComponent(JTable jTable, Object value, boolean isSelected, int row,
                                                     int column) {
            currentRow = row;
            // Keep track of the row being edited
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }

}
