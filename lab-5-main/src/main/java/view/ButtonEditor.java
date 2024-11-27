package view;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel;
    private final JButton acceptButton;
    private final JButton rejectButton;

    public ButtonEditor(JCheckBox checkBox) {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        acceptButton = new JButton("Accept");
        rejectButton = new JButton("Reject");

        acceptButton.addActionListener(e -> handleAccept());
        rejectButton.addActionListener(e -> handleReject());

        panel.add(acceptButton);
        panel.add(rejectButton);
    }

    private void handleAccept() {
        System.out.println("Accepted!");
        stopCellEditing();
    }

    private void handleReject() {
        System.out.println("Rejected!");
        stopCellEditing();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
