package view;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import interface_adapter.find.FindProfilesController;
import interface_adapter.find.FindViewModel;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel;
    private final JButton acceptButton;
    private final JButton rejectButton;
    private final FindProfilesController findProfilesController; // Controller to handle actions
    private String currentUserId; // Current user ID (can be passed from FindView)
    private String otherUserId;  // ID of the other user (from table)
    private final FindViewModel findViewModel;

    public ButtonEditor(FindViewModel findViewModel, FindProfilesController findProfilesController) {
        this.findProfilesController = findProfilesController;
        this.findViewModel = findViewModel;

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        acceptButton = new JButton("Accept");
        rejectButton = new JButton("Reject");

        // Add listeners for buttons
        acceptButton.addActionListener(e -> handleAccept());
        rejectButton.addActionListener(e -> handleReject());

        panel.add(acceptButton);
        panel.add(rejectButton);
    }

    private void handleAccept() {
        if (otherUserId == null) {
            System.err.println("Error: otherUserId is null. Cannot perform Accept action.");
            return;
        }

        System.out.println("Accepted: " + otherUserId);
        findProfilesController.handleAction(otherUserId, "Accept"); // Notify the controller
        stopCellEditing();
    }

    private void handleReject() {
        if (otherUserId == null) {
            System.err.println("Error: otherUserId is null. Cannot perform Reject action.");
            return;
        }

        System.out.println("Rejected: " + otherUserId);
        findProfilesController.handleAction(otherUserId, "Reject"); // Notify the controller
        stopCellEditing();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Assuming currentUserId is provided by the FindView
        currentUserId = findViewModel.getState().getName(); // Retrieve from the view model

        // Get the other user's ID from the table (first column)
        otherUserId = (String) table.getValueAt(row, 0);
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
