package view;

import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;

public class MatchListRenderer extends JPanel implements ListCellRenderer<String> {
    private final JLabel matchLabel;
    public MatchListRenderer() {
        setLayout(new BorderLayout());
        matchLabel = new JLabel();
        matchLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        matchLabel.setForeground(MaterialColors.BLACK);
        add(matchLabel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        matchLabel.setText(value);

        if (isSelected) {
            setBackground(MaterialColors.LIGHT_BLUE_400);
            matchLabel.setForeground(MaterialColors.WHITE);
        } else {
            setBackground(MaterialColors.WHITE);
            matchLabel.setForeground(MaterialColors.BLACK);
        }

        return this;
    }
}
