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
    private RequestsViewModel requestsViewModel;
    private  RequestsController requestsController;
    private final JLabel profileErrorField = new JLabel();
    private final JButton back;

    public RequestsView(RequestsViewModel requestsViewModel, RequestsController requestsController) {
        this.requestsViewModel = requestsViewModel;
        this.requestsController = requestsController;
        this.requestsViewModel.addPropertyChangeListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//        JFrame frame = new JFrame("HashMap Display");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(300, 300);

        final JLabel title = new JLabel(requestsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 32));
        this.add(title);

        RequestsState requestsState = requestsViewModel.getState();
        String currentUserName = requestsState.getCurrentUserName();
//        JPanel test = new JPanel();
//        JLabel test1 = new JLabel("test");
//        test.add(test1);
//        this.add(test);


        JPanel requestsCollection = new JPanel();
        requestsCollection.setLayout(new BoxLayout(requestsCollection, BoxLayout.Y_AXIS));
        if (requestsController != null) {
            HashMap<String, Double> scoresMap = requestsController.execute(currentUserName);
            requestsViewModel.getState().setScoresMap(scoresMap);
            if(scoresMap != null){
                ArrayList<Map.Entry<String, Double>> entryList = new ArrayList<>(scoresMap.entrySet());
                for (Map.Entry<String, Double> entry : entryList) {
                    JPanel currentRequester = new JPanel();
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

                requestsCollection.add(currentRequester);
            }
        }
        }


        this.add(requestsCollection);

        // Add action listener for the "back" button
        back = new JButton(requestsViewModel.BACK_BUTTON_LABEL);
        this.add(back);

        back.addActionListener(e -> {
            if (requestsController != null) {
                requestsController.switchToDashboard();
            }
        });

    }


        @Override
        public void actionPerformed (ActionEvent e){
            System.out.println("Button clicked: " + e.getActionCommand());
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

//
//import interface_adapter.find.FindViewModel;
//import mdlaf.utils.MaterialColors;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableCellEditor;
//import javax.swing.table.TableCellRenderer;
//import java.awt.*;
//import java.awt.event.ActionListener;
//
//public class RequestsView extends JPanel implements ActionListener, PropertyChangeListener {
//
//    private final RequestsViewModel requestsViewModel; // ViewModel
//    private RequestsController requestsController; // Controller
//    private final DefaultTableModel tableModel;
//    private final JTable table;
//
//    public RequestsView(RequestsViewModel requestsViewModel) {
//        this.requestsViewModel = requestsViewModel;
//        this.requestsController = requestsController;
//
//        // Register as a listener for property changes in the ViewModel
//        this.requestsViewModel.addPropertyChangeListener(this);
//
//        // Set layout
//        setLayout(new BorderLayout());
//        setBackground(MaterialColors.WHITE);
//
//        // Create the table model
//        tableModel = new DefaultTableModel(new String[]{"Username", "Score", "Actions"}, 0) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                // Only the Actions column is editable
//                return column == 2;
//            }
//        };
//
//        // Create the JTable
//        table = new JTable(tableModel);
//        table.setRowHeight(40);
//
//        // Set custom renderer for the Actions column
//        table.getColumnModel().getColumn(2).setCellRenderer(new ActionsRenderer());
//        table.getColumnModel().getColumn(2).setCellEditor(new ActionsEditor());
//
//        // Customize table appearance
//        table.setBackground(MaterialColors.WHITE);
//        table.setSelectionBackground(MaterialColors.LIGHT_BLUE_400);
//
//        // Add the table to a scroll pane
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setBorder(BorderFactory.createEmptyBorder());
//        add(scrollPane, BorderLayout.CENTER);
//
//        // Add "Return to Dashboard" button at the bottom
//        JButton returnButton = new JButton("Dashboard");
//        returnButton.addActionListener(e -> requestsController.switchToDashboard());
//        returnButton.setBackground(MaterialColors.LIGHT_BLUE_400);
//        returnButton.setForeground(MaterialColors.WHITE);
//        add(returnButton, BorderLayout.SOUTH);
//
//        // Add a Load button at the top
//        JButton loadButton = new JButton("Press to start browsing!");
//        loadButton.setBackground(MaterialColors.PINK_100);
//        loadButton.setForeground(MaterialColors.WHITE);
//        add(loadButton, BorderLayout.NORTH);
//        loadButton.addActionListener(
//                evt -> {
//                    if (evt.getSource().equals(loadButton)) {
//                        refreshTable(); // Refresh the table on Load button click
//                    }
//                }
//        );
//    }
//
//    /**
//     * Refreshes the table with the latest data from the ViewModel.
//     */
//    private void refreshTable() {
//        // Clear existing rows
//        tableModel.setRowCount(0);
//
//        // Get current state from the ViewModel
//        final RequestsState currentState = requestsViewModel.getState();
//
//        // Populate table with data from the ViewModel's state
//        Map<String, Double> scores = requestsController.execute(currentState.getCurrentUserName());
//        if (scores != null) {
//            for (Map.Entry<String, Double> entry : scores.entrySet()) {
//                tableModel.addRow(new Object[]{entry.getKey(), entry.getValue(), "Actions"});
//            }
//        }
//    }
//
//    /**
//     * Handles property change events from the ViewModel.
//     */
//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        if ("state".equals(evt.getPropertyName())) {
//            refreshTable(); // Refresh the table whenever the state changes
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        System.out.println("Button clicked: " + e.getActionCommand());
//    }
//
//    /**
//     * Custom renderer for the Actions column.
//     */
//    private class ActionsRenderer extends JPanel implements TableCellRenderer {
//        public ActionsRenderer() {
//            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//        }
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
//            removeAll();
//
//            JButton acceptButton = new JButton("Accept");
//            JButton rejectButton = new JButton("Reject");
//
//            acceptButton.addActionListener(e -> handleAction(row, true));
//            rejectButton.addActionListener(e -> handleAction(row, false));
//
//            add(acceptButton);
//            add(rejectButton);
//
//            return this;
//        }
//    }
//
//    /**
//     * Custom editor for the Actions column.
//     */
//    private class ActionsEditor extends AbstractCellEditor implements TableCellEditor {
//        private final JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
//        private final JButton acceptButton = new JButton("Accept");
//        private final JButton rejectButton = new JButton("Reject");
//        private int currentRow;
//
//        public ActionsEditor() {
//            acceptButton.addActionListener(e -> handleAction(currentRow, true));
//            rejectButton.addActionListener(e -> handleAction(currentRow, false));
//
//            panel.add(acceptButton);
//            panel.add(rejectButton);
//        }
//
//        @Override
//        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//            currentRow = row; // Keep track of the row being edited
//            return panel;
//        }
//
//        @Override
//        public Object getCellEditorValue() {
//            return null;
//        }
//    }
//
//    /**
//     * Handles the "Accept" or "Reject" action for a specific row.
//     */
//    private void handleAction(int row, Boolean isAccepted) {
//        //String currentUserId = findViewModel.getState().getName(); // Get current user from ViewModel
//        String otherUserId = (String) table.getValueAt(row, 0); // Get other user's ID from the table
//
//        System.out.println(isAccepted + " button clicked for user: " + otherUserId);
//
//        String myName = requestsViewModel.getState().getCurrentUserName();
//
//        // Accept case
//        if(isAccepted){
//            requestsController.accept(myName,otherUserId);
//        }
//        // Reject case
//
//        if(!isAccepted){
//            requestsController.reject(myName,otherUserId);
//        }
//
//
//
//        // Stop editing (if needed)
//        table.editCellAt(row, -1);
//        firePropertyChange("state", null, null); // Optionally refresh the table
//    }
//
//    public String getViewName() {
//        return "requests";
//    }
//
//    public void setRequestsViewModel(RequestsController requestsController) {
//        this.requestsController = requestsController;
//    }
//}
