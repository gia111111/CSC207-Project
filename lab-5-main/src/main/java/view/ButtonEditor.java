package view;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel;
    private final JButton acceptButton;
    private final JButton rejectButton;
    private Firestore db;
    private String currentUserId;
    private String otherUserId;

    public ButtonEditor(JCheckBox checkBox) {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        acceptButton = new JButton("Accept");
        rejectButton = new JButton("Reject");

        acceptButton.addActionListener(e -> handleButtonClick("Accept"));
        rejectButton.addActionListener(e -> handleButtonClick("Reject"));
        db = FirestoreClient.getFirestore();

        panel.add(acceptButton);
        panel.add(rejectButton);
    }

//    private void handleAccept() {
//        System.out.println("Accepted!");
//
//        stopCellEditing();
//    }
//
//    private void handleReject() {
//        System.out.println("Rejected!");
//        stopCellEditing();
//    }

    private void handleButtonClick(String status) {
        if (currentUserId == null || otherUserId == null) {
            System.err.println("Error: Missing user IDs. Cannot update Firestore.");
            return;
        }

        // Update Firestore with the new status
        updateFirestore(status);

        // Optionally, provide visual feedback
        System.out.println("Button clicked: " + status);

        stopCellEditing();
    }

    private void updateFirestore(String status) {
        // Reference to the current user's Firestore document
        DocumentReference docRef = db.collection("finds").document();

        // Path to the specific field in the nested map
        String fieldPath = "requestStatus." + otherUserId;

        // Update the Firestore document
        docRef.update(fieldPath, status);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Assuming `currentUserId` is constant for the session
        currentUserId = "current_user_id"; // Replace with actual logic to get the current user's ID

        // Get the other user's ID from the table
        otherUserId = table.getValueAt(row, 0).toString(); // Assuming the first column contains the other user's ID
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
