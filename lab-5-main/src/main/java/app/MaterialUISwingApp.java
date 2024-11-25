package app;

import entity.Matches;
import mdlaf.MaterialLookAndFeel;
import view.MatchViewFrame;

import javax.swing.*;
import java.util.List;

public class MaterialUISwingApp {
    public static void main(String[] args) {
        try {
            // Set the Material Look-and-Feel
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Create and display the MatchViewFrame
        SwingUtilities.invokeLater(() -> {
            Matches matches = new Matches();
            matches.addMatch("John Doe", List.of("Phone", "123-456-7890"));
            matches.addMatch("Jane Smith", List.of("Email", "jane@example.com"));

            MatchViewFrame matchViewFrame = new MatchViewFrame(matches);
            matchViewFrame.setVisible(true);
        });
    }
}
