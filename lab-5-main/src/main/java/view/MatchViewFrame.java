package view;

import entity.Matches;
import mdlaf.MaterialLookAndFeel;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MatchViewFrame extends JFrame {
    public MatchViewFrame(Matches matches) {
        // Set up the JFrame
        setTitle("Match List");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Convert Matches entity to JList data
        JList<String> matchList = new JList<>(convertMatchesToArray(matches));
        matchList.setCellRenderer(new MatchListRenderer());
        matchList.setBackground(MaterialColors.WHITE);
        matchList.setSelectionBackground(MaterialColors.LIGHT_BLUE_400);

        // Add to JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(matchList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        add(scrollPane, BorderLayout.CENTER);
    }

    // Convert Matches to a String array for the JList
    private String[] convertMatchesToArray(Matches matches) {
        return matches.getMatches().entrySet().stream()
                .map(entry -> entry.getKey() + " (" + entry.getValue().get(0) + ": " + entry.getValue().get(1) + ")")
                .toArray(String[]::new);
    }
}
