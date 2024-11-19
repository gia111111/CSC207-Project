package view;


import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfileState;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "profile";

    private final ProfileViewModel profileViewModel;
    private final ProfileController profileController;
    private final JTextField age = new JTextField(10);
    private final JTextField section1_weight = new JTextField(10);
    private final JTextField section2_weight = new JTextField(10);
    private final JTextField section3_weight = new JTextField(10);
    private final JTextField section4_weight = new JTextField(10);
    private final JTextField section5_weight = new JTextField(10);
    private final JButton cancel;
    private final JButton save;
    private final JRadioButton a1_1;
    private final JRadioButton b1_1;
    private final JRadioButton c1_1;
    private final JRadioButton d1_1;
    private final JRadioButton e1_1;
    private final JRadioButton a1_2;
    private final JRadioButton b1_2;
    private final JRadioButton c1_2;
    private final JRadioButton d1_2;
    private final JRadioButton e1_2;
    private final JRadioButton a2_1;
    private final JRadioButton b2_1;
    private final JRadioButton c2_1;
    private final JRadioButton d2_1;
    private final JRadioButton e2_1;
    private final JRadioButton a2_2;
    private final JRadioButton b2_2;
    private final JRadioButton c2_2;
    private final JRadioButton d2_2;
    private final JRadioButton e2_2;
    private final JRadioButton a3_1;
    private final JRadioButton b3_1;
    private final JRadioButton c3_1;
    private final JRadioButton d3_1;
    private final JRadioButton e3_1;
    private final JRadioButton a3_2;
    private final JRadioButton b3_2;
    private final JRadioButton c3_2;
    private final JRadioButton d3_2;
    private final JRadioButton e3_2;
    private final JRadioButton a4_1;
    private final JRadioButton b4_1;
    private final JRadioButton c4_1;
    private final JRadioButton d4_1;
    private final JRadioButton e4_1;
    private final JRadioButton a4_2;
    private final JRadioButton b4_2;
    private final JRadioButton c4_2;
    private final JRadioButton d4_2;
    private final JRadioButton e4_2;
    private final JRadioButton a5_1;
    private final JRadioButton b5_1;
    private final JRadioButton c5_1;
    private final JRadioButton d5_1;
    private final JRadioButton e5_1;
    private final JRadioButton a5_2;
    private final JRadioButton b5_2;
    private final JRadioButton c5_2;
    private final JRadioButton d5_2;
    private final JRadioButton e5_2;

    public ProfileView(ProfileViewModel profileViewModel, ProfileController profileController) {
        this.profileController = profileController;
        this.profileViewModel = profileViewModel;
        profileViewModel.addPropertyChangeListener(this);

        final JPanel content = new JPanel();

        final JLabel title = new JLabel(ProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 32));
        content.add(title);
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        content.setAlignmentX(Component.LEFT_ALIGNMENT);

        save = new JButton(ProfileViewModel.SAVE_BUTTON_LABEL);
        cancel = new JButton(ProfileViewModel.CANCEL_BUTTON_LABEL);

        // Add action listener for the cancel button
        cancel.addActionListener(e -> {
            if (profileController != null) {
                profileController.handleCancel();
            }
        });

        final JPanel basic_info = new JPanel();
        basic_info.setLayout(new BoxLayout(basic_info, BoxLayout.PAGE_AXIS));
        basic_info.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel basic_label = new JLabel(ProfileViewModel.BASIC_INFORMATION);
        basic_label.setFont(new Font(basic_label.getFont().getName(), basic_label.getFont().getStyle(), 18));
        basic_info.add(basic_label);
        final JLabel b_gender = new JLabel(ProfileViewModel.BQ_GENDER);
        final JButton female = new JButton("Female");
        final JButton male = new JButton("Male");
        final JButton other = new JButton("other");
        final ButtonGroup basic_gender = new ButtonGroup();
        basic_info.add(b_gender);
        basic_gender.add(female);
        basic_gender.add(male);
        basic_gender.add(other);
        basic_info.add(female);
        basic_info.add(male);
        basic_info.add(other);
        final JLabel b_sexualOrientation = new JLabel(ProfileViewModel.BQ_SEXUAL_ORIENTATION);
        basic_info.add(b_sexualOrientation);
        final JButton female_so = new JButton("Female");
        final JButton male_so = new JButton("Male");
        final JButton both = new JButton("Both");
        final ButtonGroup basic_so = new ButtonGroup();
        basic_so.add(female_so);
        basic_so.add(male_so);
        basic_so.add(both);
        basic_info.add(female_so);
        basic_info.add(male_so);
        basic_info.add(both);
        final LabelTextPanel basic_age = new LabelTextPanel(
                new JLabel(ProfileViewModel.BQ_AGE), age);
        basic_age.setLayout(new BoxLayout(basic_age, BoxLayout.X_AXIS));
        basic_age.setAlignmentX(Component.LEFT_ALIGNMENT);
        basic_info.add(basic_age);
        content.add(basic_info);

        a1_1 = new JRadioButton(ProfileViewModel.MC_A);
        b1_1 = new JRadioButton(ProfileViewModel.MC_B);
        c1_1 = new JRadioButton(ProfileViewModel.MC_C);
        d1_1 = new JRadioButton(ProfileViewModel.MC_D);
        e1_1 = new JRadioButton(ProfileViewModel.MC_E);
        a1_2 = new JRadioButton(ProfileViewModel.MC_A);
        b1_2 = new JRadioButton(ProfileViewModel.MC_B);
        c1_2 = new JRadioButton(ProfileViewModel.MC_C);
        d1_2 = new JRadioButton(ProfileViewModel.MC_D);
        e1_2 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section1 = new JPanel();
        section1.setLayout(new BoxLayout(section1, BoxLayout.PAGE_AXIS));
        section1.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section1_label = new JLabel(ProfileViewModel.SECTION_ONE);
        section1_label.setFont(new Font(section1.getFont().getName(), section1.getFont().getStyle(), 18));
        section1.add(section1_label);
        final JLabel one_one = new JLabel(ProfileViewModel.ONE_QONE);
        section1.add(one_one);
        ButtonGroup question1_1 = new ButtonGroup();
        question1_1.add(a1_1);
        question1_1.add(b1_1);
        question1_1.add(c1_1);
        question1_1.add(d1_1);
        question1_1.add(e1_1);
        final JPanel mcq1_1 = new JPanel();
        mcq1_1.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq1_1.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq1_1.add(a1_1);
        mcq1_1.add(b1_1);
        mcq1_1.add(c1_1);
        mcq1_1.add(d1_1);
        mcq1_1.add(e1_1);
        section1.add(mcq1_1);
        final JLabel one_two = new JLabel(ProfileViewModel.ONE_QTWO);
        section1.add(one_two);
        ButtonGroup question1_2 = new ButtonGroup();
        question1_2.add(a1_2);
        question1_2.add(b1_2);
        question1_2.add(c1_2);
        question1_2.add(d1_2);
        question1_2.add(e1_2);
        final JPanel mcq1_2 = new JPanel();
        mcq1_2.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq1_2.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq1_2.add(a1_2);
        mcq1_2.add(b1_2);
        mcq1_2.add(c1_2);
        mcq1_2.add(d1_2);
        mcq1_2.add(e1_2);
        section1.add(mcq1_2);
        content.add(section1);

        a2_1 = new JRadioButton(ProfileViewModel.MC_A);
        b2_1 = new JRadioButton(ProfileViewModel.MC_B);
        c2_1 = new JRadioButton(ProfileViewModel.MC_C);
        d2_1 = new JRadioButton(ProfileViewModel.MC_D);
        e2_1 = new JRadioButton(ProfileViewModel.MC_E);
        a2_2 = new JRadioButton(ProfileViewModel.MC_A);
        b2_2 = new JRadioButton(ProfileViewModel.MC_B);
        c2_2 = new JRadioButton(ProfileViewModel.MC_C);
        d2_2 = new JRadioButton(ProfileViewModel.MC_D);
        e2_2 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section2 = new JPanel();
        section2.setLayout(new BoxLayout(section2, BoxLayout.PAGE_AXIS));
        section2.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section2_label = new JLabel(ProfileViewModel.SECTION_TWO);
        section2_label.setFont(new Font(section2.getFont().getName(), section2.getFont().getStyle(), 18));
        section2.add(section2_label);
        final JLabel two_one = new JLabel(ProfileViewModel.TWO_QONE);
        section2.add(two_one);
        ButtonGroup question2_1 = new ButtonGroup();
        question2_1.add(a2_1);
        question2_1.add(b2_1);
        question2_1.add(c2_1);
        question2_1.add(d2_1);
        question2_1.add(e2_1);
        final JPanel mcq2_1 = new JPanel();
        mcq2_1.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq2_1.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq2_1.add(a2_1);
        mcq2_1.add(b2_1);
        mcq2_1.add(c2_1);
        mcq2_1.add(d2_1);
        mcq2_1.add(e2_1);
        section2.add(mcq2_1);
        final JLabel two_two = new JLabel(ProfileViewModel.TWO_QTWO);
        section2.add(two_two);
        ButtonGroup question2_2 = new ButtonGroup();
        question2_2.add(a2_2);
        question2_2.add(b2_2);
        question2_2.add(c2_2);
        question2_2.add(d2_2);
        question2_2.add(e2_2);
        final JPanel mcq2_2 = new JPanel();
        mcq2_2.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq2_2.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq2_2.add(a2_2);
        mcq2_2.add(b2_2);
        mcq2_2.add(c2_2);
        mcq2_2.add(d2_2);
        mcq2_2.add(e2_2);
        section2.add(mcq2_2);
        content.add(section2);

        a3_1 = new JRadioButton(ProfileViewModel.MC_A);
        b3_1 = new JRadioButton(ProfileViewModel.MC_B);
        c3_1 = new JRadioButton(ProfileViewModel.MC_C);
        d3_1 = new JRadioButton(ProfileViewModel.MC_D);
        e3_1 = new JRadioButton(ProfileViewModel.MC_E);
        a3_2 = new JRadioButton(ProfileViewModel.MC_A);
        b3_2 = new JRadioButton(ProfileViewModel.MC_B);
        c3_2 = new JRadioButton(ProfileViewModel.MC_C);
        d3_2 = new JRadioButton(ProfileViewModel.MC_D);
        e3_2 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section3 = new JPanel();
        section3.setLayout(new BoxLayout(section3, BoxLayout.PAGE_AXIS));
        section3.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section3_label = new JLabel(ProfileViewModel.SECTION_THREE);
        section3_label.setFont(new Font(section3.getFont().getName(), section3.getFont().getStyle(), 18));
        section3.add(section3_label);
        final JLabel three_one = new JLabel(ProfileViewModel.THREE_QONE);
        section3.add(three_one);
        ButtonGroup question3_1 = new ButtonGroup();
        question3_1.add(a3_1);
        question3_1.add(b3_1);
        question3_1.add(c3_1);
        question3_1.add(d3_1);
        question3_1.add(e3_1);
        final JPanel mcq3_1 = new JPanel();
        mcq3_1.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq3_1.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq3_1.add(a3_1);
        mcq3_1.add(b3_1);
        mcq3_1.add(c3_1);
        mcq3_1.add(d3_1);
        mcq3_1.add(e3_1);
        section3.add(mcq3_1);
        final JLabel three_two = new JLabel(ProfileViewModel.THREE_QTWO);
        section3.add(three_two);
        ButtonGroup question3_2 = new ButtonGroup();
        question3_2.add(a3_2);
        question3_2.add(b3_2);
        question3_2.add(c3_2);
        question3_2.add(d3_2);
        question3_2.add(e3_2);
        final JPanel mcq3_2 = new JPanel();
        mcq3_2.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq3_2.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq3_2.add(a3_2);
        mcq3_2.add(b3_2);
        mcq3_2.add(c3_2);
        mcq3_2.add(d3_2);
        mcq3_2.add(e3_2);
        section3.add(mcq3_2);
        content.add(section3);

        a4_1 = new JRadioButton(ProfileViewModel.MC_A);
        b4_1 = new JRadioButton(ProfileViewModel.MC_B);
        c4_1 = new JRadioButton(ProfileViewModel.MC_C);
        d4_1 = new JRadioButton(ProfileViewModel.MC_D);
        e4_1 = new JRadioButton(ProfileViewModel.MC_E);
        a4_2 = new JRadioButton(ProfileViewModel.MC_A);
        b4_2 = new JRadioButton(ProfileViewModel.MC_B);
        c4_2 = new JRadioButton(ProfileViewModel.MC_C);
        d4_2 = new JRadioButton(ProfileViewModel.MC_D);
        e4_2 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section4 = new JPanel();
        section4.setLayout(new BoxLayout(section4, BoxLayout.PAGE_AXIS));
        section4.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section4_label = new JLabel(ProfileViewModel.SECTION_FOUR);
        section4_label.setFont(new Font(section4.getFont().getName(), section4.getFont().getStyle(), 18));
        section4.add(section4_label);
        final JLabel four_one = new JLabel(ProfileViewModel.FOUR_QONE);
        section4.add(four_one);
        ButtonGroup question4_1 = new ButtonGroup();
        question4_1.add(a4_1);
        question4_1.add(b4_1);
        question4_1.add(c4_1);
        question4_1.add(d4_1);
        question4_1.add(e4_1);
        final JPanel mcq4_1 = new JPanel();
        mcq4_1.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq4_1.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq4_1.add(a4_1);
        mcq4_1.add(b4_1);
        mcq4_1.add(c4_1);
        mcq4_1.add(d4_1);
        mcq4_1.add(e4_1);
        section4.add(mcq4_1);
        final JLabel four_two = new JLabel(ProfileViewModel.FOUR_QTWO);
        section4.add(four_two);
        ButtonGroup question4_2 = new ButtonGroup();
        question4_2.add(a4_2);
        question4_2.add(b4_2);
        question4_2.add(c4_2);
        question4_2.add(d4_2);
        question4_2.add(e4_2);
        final JPanel mcq4_2 = new JPanel();
        mcq4_2.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq4_2.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq4_2.add(a4_2);
        mcq4_2.add(b4_2);
        mcq4_2.add(c4_2);
        mcq4_2.add(d4_2);
        mcq4_2.add(e4_2);
        section4.add(mcq4_2);
        content.add(section4);

        a5_1 = new JRadioButton(ProfileViewModel.MC_A);
        b5_1 = new JRadioButton(ProfileViewModel.MC_B);
        c5_1 = new JRadioButton(ProfileViewModel.MC_C);
        d5_1 = new JRadioButton(ProfileViewModel.MC_D);
        e5_1 = new JRadioButton(ProfileViewModel.MC_E);
        a5_2 = new JRadioButton(ProfileViewModel.MC_A);
        b5_2 = new JRadioButton(ProfileViewModel.MC_B);
        c5_2 = new JRadioButton(ProfileViewModel.MC_C);
        d5_2 = new JRadioButton(ProfileViewModel.MC_D);
        e5_2 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section5 = new JPanel();
        section5.setLayout(new BoxLayout(section5, BoxLayout.PAGE_AXIS));
        section5.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section5_label = new JLabel(ProfileViewModel.SECTION_FIVE);
        section5_label.setFont(new Font(section5.getFont().getName(), section5.getFont().getStyle(), 18));
        section5.add(section5_label);
        final JLabel five_one = new JLabel(ProfileViewModel.FIVE_QONE);
        section5.add(five_one);
        ButtonGroup question5_1 = new ButtonGroup();
        question5_1.add(a5_1);
        question5_1.add(b5_1);
        question5_1.add(c5_1);
        question5_1.add(d5_1);
        question5_1.add(e5_1);
        final JPanel mcq5_1 = new JPanel();
        mcq5_1.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq5_1.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq5_1.add(a5_1);
        mcq5_1.add(b5_1);
        mcq5_1.add(c5_1);
        mcq5_1.add(d5_1);
        mcq5_1.add(e5_1);
        section5.add(mcq5_1);
        final JLabel five_two = new JLabel(ProfileViewModel.FIVE_QTWO);
        section5.add(five_two);
        ButtonGroup question5_2 = new ButtonGroup();
        question5_2.add(a5_2);
        question5_2.add(b5_2);
        question5_2.add(c5_2);
        question5_2.add(d5_2);
        question5_2.add(e5_2);
        final JPanel mcq5_2 = new JPanel();
        mcq5_2.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        mcq5_2.setAlignmentX(Component.LEFT_ALIGNMENT);
        mcq5_2.add(a5_2);
        mcq5_2.add(b5_2);
        mcq5_2.add(c5_2);
        mcq5_2.add(d5_2);
        mcq5_2.add(e5_2);
        section5.add(mcq5_2);
        content.add(section5);

        final JPanel weight = new JPanel();
        weight.setLayout(new BoxLayout(weight, BoxLayout.PAGE_AXIS));
        weight.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel weight_label = new JLabel(ProfileViewModel.SECTION_WEIGHT);
        weight_label.setFont(new Font(weight.getFont().getName(), weight.getFont().getStyle(), 18));
        weight.add(weight_label);
        final JLabel weight_question = new JLabel(ProfileViewModel.Q_WEIGHT);
        weight.add(weight_question);
        final LabelTextPanel s1_weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_ONE), section1_weight);
        final LabelTextPanel s2_weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_TWO), section2_weight);
        final LabelTextPanel s3_weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_THREE), section3_weight);
        final LabelTextPanel s4_weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_FOUR), section4_weight);
        final LabelTextPanel s5_weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_FIVE), section5_weight);
        weight.add(s1_weight);
        weight.add(s2_weight);
        weight.add(s3_weight);
        weight.add(s4_weight);
        weight.add(s5_weight);
        content.add(weight);

        //save.setAlignmentX(Component.CENTER_ALIGNMENT);
        //this.add(save);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(save);
        buttonsPanel.add(cancel);
        save.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(buttonsPanel);

        JScrollPane scrollPane = new JScrollPane(content); // Create scroll pane
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        int currentValue = verticalScrollBar.getValue();
        verticalScrollBar.setValue(currentValue + 100);// Set policy

        this.add(content);
    }



//    private static String getSelectedButtonText(ButtonGroup group) {
//        for (AbstractButton button : group.getElements()) {
//            if (button.isSelected()) {
//                return button.getText();
//            }
//        }
//        return "No selection";
//    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;
    }
}
