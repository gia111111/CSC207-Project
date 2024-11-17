package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "profile";

    private final JButton submit;

    public ProfileView() {
        final JLabel title = new JLabel("Profile");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        // Example question and multiple choice answer
        JLabel questionLabel = new JLabel("Question 1:");
        gbc.gridx = 0;
        add(questionLabel, gbc);

        JComboBox<String> answerComboBox = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
        gbc.gridx = 1;
        add(answerComboBox, gbc);

        gbc.gridy++;
        submit = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(submit, gbc);

        add(title);
        add(submit);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        // TODO Auto-generated method stub
    }

}
