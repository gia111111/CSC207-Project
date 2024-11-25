package view;


import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfileState;
import interface_adapter.profile.ProfileViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "profile";

    private final ProfileViewModel profileViewModel;
    private ProfileController profileController;
    private final JTextField age = new JTextField(10);
    private final JTextField section1_weight = new JTextField(10);
    private final JTextField section2_weight = new JTextField(10);
    private final JTextField section3_weight = new JTextField(10);
    private final JTextField section4_weight = new JTextField(10);
    private final JTextField section5_weight = new JTextField(10);
    private final JTextField contactMethod = new JTextField(10);
    private final JTextField contactInfo = new JTextField(10);
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
    private final JRadioButton a1_3;
    private final JRadioButton b1_3;
    private final JRadioButton c1_3;
    private final JRadioButton d1_3;
    private final JRadioButton e1_3;
    private final JRadioButton a1_4;
    private final JRadioButton b1_4;
    private final JRadioButton c1_4;
    private final JRadioButton d1_4;
    private final JRadioButton e1_4;
    private final JRadioButton a1_5;
    private final JRadioButton b1_5;
    private final JRadioButton c1_5;
    private final JRadioButton d1_5;
    private final JRadioButton e1_5;

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
    private final JRadioButton a2_3;
    private final JRadioButton b2_3;
    private final JRadioButton c2_3;
    private final JRadioButton d2_3;
    private final JRadioButton e2_3;
    private final JRadioButton a2_4;
    private final JRadioButton b2_4;
    private final JRadioButton c2_4;
    private final JRadioButton d2_4;
    private final JRadioButton e2_4;
    private final JRadioButton a2_5;
    private final JRadioButton b2_5;
    private final JRadioButton c2_5;
    private final JRadioButton d2_5;
    private final JRadioButton e2_5;

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
    private final JRadioButton a3_3;
    private final JRadioButton b3_3;
    private final JRadioButton c3_3;
    private final JRadioButton d3_3;
    private final JRadioButton e3_3;
    private final JRadioButton a3_4;
    private final JRadioButton b3_4;
    private final JRadioButton c3_4;
    private final JRadioButton d3_4;
    private final JRadioButton e3_4;
    private final JRadioButton a3_5;
    private final JRadioButton b3_5;
    private final JRadioButton c3_5;
    private final JRadioButton d3_5;
    private final JRadioButton e3_5;

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
    private final JRadioButton a4_3;
    private final JRadioButton b4_3;
    private final JRadioButton c4_3;
    private final JRadioButton d4_3;
    private final JRadioButton e4_3;
    private final JRadioButton a4_4;
    private final JRadioButton b4_4;
    private final JRadioButton c4_4;
    private final JRadioButton d4_4;
    private final JRadioButton e4_4;
    private final JRadioButton a4_5;
    private final JRadioButton b4_5;
    private final JRadioButton c4_5;
    private final JRadioButton d4_5;
    private final JRadioButton e4_5;

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
    private final JRadioButton a5_3;
    private final JRadioButton b5_3;
    private final JRadioButton c5_3;
    private final JRadioButton d5_3;
    private final JRadioButton e5_3;
    private final JRadioButton a5_4;
    private final JRadioButton b5_4;
    private final JRadioButton c5_4;
    private final JRadioButton d5_4;
    private final JRadioButton e5_4;
    private final JRadioButton a5_5;
    private final JRadioButton b5_5;
    private final JRadioButton c5_5;
    private final JRadioButton d5_5;
    private final JRadioButton e5_5;

    private final JRadioButton female;
    private final JRadioButton male;
    private final JRadioButton other;
    private final JRadioButton female_so;
    private final JRadioButton male_so;
    private final JRadioButton both;

    private String gender;
    private String sexualOrientation;
    private int ageValue;

    private List<List<String>> sectionAnswers;
    private Map<String, Integer> sectionWeights;
//    private List<String> section1Answers;
//    private List<String> section2Answers;
//    private List<String> section3Answers;
//    private List<String> section4Answers;
//    private List<String> section5Answers;


    public ProfileView(ProfileViewModel profileViewModel) {
        this.profileViewModel = profileViewModel;
        profileViewModel.addPropertyChangeListener(this);

        this.sectionAnswers = new ArrayList<>();

        final JPanel content = new JPanel();

        final JLabel title = new JLabel(ProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 32));
        content.add(title);
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));
        content.setAlignmentX(Component.LEFT_ALIGNMENT);

        save = new JButton(ProfileViewModel.SAVE_BUTTON_LABEL);

        final JPanel basic_info = new JPanel();
        basic_info.setLayout(new BoxLayout(basic_info, BoxLayout.PAGE_AXIS));
        basic_info.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel basic_label = new JLabel(ProfileViewModel.BASIC_INFORMATION);
        basic_label.setFont(new Font(basic_label.getFont().getName(), basic_label.getFont().getStyle(), 18));
        basic_info.add(basic_label);
        final JLabel b_gender = new JLabel(ProfileViewModel.BQ_GENDER);
        female = new JRadioButton("Female");
        male = new JRadioButton("Male");
        other = new JRadioButton("other");
        final ButtonGroup basic_gender = new ButtonGroup();
        basic_info.add(b_gender);
        basic_gender.add(female);
        basic_gender.add(male);
        basic_gender.add(other);
        basic_info.add(female);
        basic_info.add(male);
        basic_info.add(other);
        final ProfileState currentState1 = profileViewModel.getState();
        female.addActionListener(evt -> {
            if (female.isSelected() == true) {
                this.gender = female.getText();
                currentState1.setGender(female.getText());
                profileViewModel.setState(currentState1);
            }
        });
        male.addActionListener(evt -> {
            if (male.isSelected() == true) {
                this.gender = male.getText();
                currentState1.setGender(male.getText());
                profileViewModel.setState(currentState1);
            }
        });
        other.addActionListener(evt -> {
            if (other.isSelected() == true) {
                this.gender = other.getText();
                currentState1.setGender(other.getText());
                profileViewModel.setState(currentState1);
            }
        });

        final JLabel b_sexualOrientation = new JLabel(ProfileViewModel.BQ_SEXUAL_ORIENTATION);
        basic_info.add(b_sexualOrientation);
        female_so = new JRadioButton("Female");
        male_so = new JRadioButton("Male");
        both = new JRadioButton("Both");
        final ButtonGroup basic_so = new ButtonGroup();
        basic_so.add(female_so);
        basic_so.add(male_so);
        basic_so.add(both);
        basic_info.add(female_so);
        basic_info.add(male_so);
        basic_info.add(both);
        final ProfileState currentState2 = profileViewModel.getState();
        female_so.addActionListener(evt -> {
            if (female_so.isSelected() == true) {
                this.sexualOrientation = female_so.getText();
                currentState2.setSexualOrientation(female_so.getText());
                profileViewModel.setState(currentState2);
            }
        });
        male_so.addActionListener(evt -> {
            if (male_so.isSelected() == true) {
                this.sexualOrientation = male_so.getText();
                currentState2.setSexualOrientation(male_so.getText());
                profileViewModel.setState(currentState2);
            }
        });
        both.addActionListener(evt -> {
            if (both.isSelected() == true) {
                this.sexualOrientation = both.getText();
                currentState2.setSexualOrientation(both.getText());
                profileViewModel.setState(currentState2);
            }
        });
        final LabelTextPanel basic_age = new LabelTextPanel(
                new JLabel(ProfileViewModel.BQ_AGE), age);
        basic_age.setLayout(new BoxLayout(basic_age, BoxLayout.X_AXIS));
        basic_age.setAlignmentX(Component.LEFT_ALIGNMENT);
        basic_info.add(basic_age);
        content.add(basic_info);

        final LabelTextPanel contact_method = new LabelTextPanel(new JLabel(ProfileViewModel.CONTACT_METHOD), contactMethod);
        final LabelTextPanel contact_info = new LabelTextPanel(new JLabel(ProfileViewModel.CONTACT_INFO), contactInfo);
        contact_method.setLayout(new BoxLayout(contact_method, BoxLayout.X_AXIS));
        contact_info.setLayout(new BoxLayout(contact_info, BoxLayout.X_AXIS));
        contact_method.setAlignmentX(Component.LEFT_ALIGNMENT);
        contact_info.setAlignmentX(Component.LEFT_ALIGNMENT);
        basic_info.add(contact_method);
        basic_info.add(contact_info);
        content.add(contact_method);
        content.add(contact_info);

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
        a1_3 = new JRadioButton(ProfileViewModel.MC_A);
        b1_3 = new JRadioButton(ProfileViewModel.MC_B);
        c1_3 = new JRadioButton(ProfileViewModel.MC_C);
        d1_3 = new JRadioButton(ProfileViewModel.MC_D);
        e1_3 = new JRadioButton(ProfileViewModel.MC_E);
        a1_4 = new JRadioButton(ProfileViewModel.MC_A);
        b1_4 = new JRadioButton(ProfileViewModel.MC_B);
        c1_4 = new JRadioButton(ProfileViewModel.MC_C);
        d1_4 = new JRadioButton(ProfileViewModel.MC_D);
        e1_4 = new JRadioButton(ProfileViewModel.MC_E);
        a1_5 = new JRadioButton(ProfileViewModel.MC_A);
        b1_5 = new JRadioButton(ProfileViewModel.MC_B);
        c1_5 = new JRadioButton(ProfileViewModel.MC_C);
        d1_5 = new JRadioButton(ProfileViewModel.MC_D);
        e1_5 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section1 = new JPanel();
        section1.setLayout(new BoxLayout(section1, BoxLayout.PAGE_AXIS));
        section1.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section1_label = new JLabel(ProfileViewModel.SECTION_ONE);
        section1_label.setFont(new Font(section1.getFont().getName(), section1.getFont().getStyle(), 18));
        section1.add(section1_label);
//        this.section1Answers = new ArrayList<>();
        section1.add(questionMcq(ProfileViewModel.ONE_QONE, a1_1, b1_1, c1_1, d1_1, e1_1, 0));
        section1.add(questionMcq(ProfileViewModel.ONE_QTWO, a1_2, b1_2, c1_2, d1_2, e1_2, 0));
        section1.add(questionMcq(ProfileViewModel.ONE_QTHREE, a1_3, b1_3, c1_3, d1_3, e1_3, 0));
        section1.add(questionMcq(ProfileViewModel.ONE_QFOUR, a1_4, b1_4, c1_4, d1_4, e1_4, 0));
        section1.add(questionMcq(ProfileViewModel.ONE_QFIVE, a1_5, b1_5, c1_5, d1_5, e1_5,0));

        content.add(section1);
//        sectionAnswers.add(section1Answers);


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
        a2_3 = new JRadioButton(ProfileViewModel.MC_A);
        b2_3 = new JRadioButton(ProfileViewModel.MC_B);
        c2_3 = new JRadioButton(ProfileViewModel.MC_C);
        d2_3 = new JRadioButton(ProfileViewModel.MC_D);
        e2_3 = new JRadioButton(ProfileViewModel.MC_E);
        a2_4 = new JRadioButton(ProfileViewModel.MC_A);
        b2_4 = new JRadioButton(ProfileViewModel.MC_B);
        c2_4 = new JRadioButton(ProfileViewModel.MC_C);
        d2_4 = new JRadioButton(ProfileViewModel.MC_D);
        e2_4 = new JRadioButton(ProfileViewModel.MC_E);
        a2_5 = new JRadioButton(ProfileViewModel.MC_A);
        b2_5 = new JRadioButton(ProfileViewModel.MC_B);
        c2_5 = new JRadioButton(ProfileViewModel.MC_C);
        d2_5 = new JRadioButton(ProfileViewModel.MC_D);
        e2_5 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section2 = new JPanel();
        section2.setLayout(new BoxLayout(section2, BoxLayout.PAGE_AXIS));
        section2.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section2_label = new JLabel(ProfileViewModel.SECTION_TWO);
        section2_label.setFont(new Font(section2.getFont().getName(), section2.getFont().getStyle(), 18));
        section2.add(section2_label);
//        this.section2Answers = new ArrayList<>();
        section2.add(questionMcq(ProfileViewModel.TWO_QONE, a2_1, b2_1, c2_1, d2_1, e2_1, 1));
        section2.add(questionMcq(ProfileViewModel.TWO_QTWO, a2_2, b2_2, c2_2, d2_2, e2_2, 1));
        section2.add(questionMcq(ProfileViewModel.TWO_QTHREE, a2_3, b2_3, c2_3, d2_3, e2_3, 1));
        section2.add(questionMcq(ProfileViewModel.TWO_QFOUR, a2_4, b2_4, c2_4, d2_4, e2_4, 1));
        section2.add(questionMcq(ProfileViewModel.TWO_QFIVE, a2_5, b2_5, c2_5, d2_5, e2_5, 1));

        content.add(section2);
//        sectionAnswers.add(section2Answers);

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
        a3_3 = new JRadioButton(ProfileViewModel.MC_A);
        b3_3 = new JRadioButton(ProfileViewModel.MC_B);
        c3_3 = new JRadioButton(ProfileViewModel.MC_C);
        d3_3 = new JRadioButton(ProfileViewModel.MC_D);
        e3_3 = new JRadioButton(ProfileViewModel.MC_E);
        a3_4 = new JRadioButton(ProfileViewModel.MC_A);
        b3_4 = new JRadioButton(ProfileViewModel.MC_B);
        c3_4 = new JRadioButton(ProfileViewModel.MC_C);
        d3_4 = new JRadioButton(ProfileViewModel.MC_D);
        e3_4 = new JRadioButton(ProfileViewModel.MC_E);
        a3_5 = new JRadioButton(ProfileViewModel.MC_A);
        b3_5 = new JRadioButton(ProfileViewModel.MC_B);
        c3_5 = new JRadioButton(ProfileViewModel.MC_C);
        d3_5 = new JRadioButton(ProfileViewModel.MC_D);
        e3_5 = new JRadioButton(ProfileViewModel.MC_E);


        final JPanel section3 = new JPanel();
        section3.setLayout(new BoxLayout(section3, BoxLayout.PAGE_AXIS));
        section3.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section3_label = new JLabel(ProfileViewModel.SECTION_THREE);
        section3_label.setFont(new Font(section3.getFont().getName(), section3.getFont().getStyle(), 18));
        section3.add(section3_label);
//        this.section3Answers = new ArrayList<>();
        section3.add(questionMcq(ProfileViewModel.THREE_QONE, a3_1, b3_1, c3_1, d3_1, e3_1, 2));
        section3.add(questionMcq(ProfileViewModel.THREE_QTWO, a3_2, b3_2, c3_2, d3_2, e3_2, 2));
        section3.add(questionMcq(ProfileViewModel.THREE_QTHREE, a3_3, b3_3, c3_3, d3_3, e3_3, 2));
        section3.add(questionMcq(ProfileViewModel.THREE_QFOUR, a3_4, b3_4, c3_4, d3_4, e3_4, 2));
        section3.add(questionMcq(ProfileViewModel.THREE_QFIVE, a3_5, b3_5, c3_5, d3_5, e3_5, 2));

        content.add(section3);
//        sectionAnswers.add(section3Answers);

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
        a4_3 = new JRadioButton(ProfileViewModel.MC_A);
        b4_3 = new JRadioButton(ProfileViewModel.MC_B);
        c4_3 = new JRadioButton(ProfileViewModel.MC_C);
        d4_3 = new JRadioButton(ProfileViewModel.MC_D);
        e4_3 = new JRadioButton(ProfileViewModel.MC_E);
        a4_4 = new JRadioButton(ProfileViewModel.MC_A);
        b4_4 = new JRadioButton(ProfileViewModel.MC_B);
        c4_4 = new JRadioButton(ProfileViewModel.MC_C);
        d4_4 = new JRadioButton(ProfileViewModel.MC_D);
        e4_4 = new JRadioButton(ProfileViewModel.MC_E);
        a4_5 = new JRadioButton(ProfileViewModel.MC_A);
        b4_5 = new JRadioButton(ProfileViewModel.MC_B);
        c4_5 = new JRadioButton(ProfileViewModel.MC_C);
        d4_5 = new JRadioButton(ProfileViewModel.MC_D);
        e4_5 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section4 = new JPanel();
        section4.setLayout(new BoxLayout(section4, BoxLayout.PAGE_AXIS));
        section4.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section4_label = new JLabel(ProfileViewModel.SECTION_FOUR);
        section4_label.setFont(new Font(section4.getFont().getName(), section4.getFont().getStyle(), 18));
        section4.add(section4_label);
//        this.section4Answers = new ArrayList<>();
        section4.add(questionMcq(ProfileViewModel.FOUR_QONE, a4_1, b4_1, c4_1, d4_1, e4_1, 3));
        section4.add(questionMcq(ProfileViewModel.FOUR_QTWO, a4_2, b4_2, c4_2, d4_2, e4_2, 3));
        section4.add(questionMcq(ProfileViewModel.FOUR_QTHREE, a4_3, b4_3, c4_3, d4_3, e4_3, 3));
        section4.add(questionMcq(ProfileViewModel.FOUR_QFOUR, a4_4, b4_4, c4_4, d4_4, e4_4, 3));
        section4.add(questionMcq(ProfileViewModel.FOUR_QFIVE, a4_5, b4_5, c4_5, d4_5, e4_5, 3));

        content.add(section4);
//        sectionAnswers.add(section4Answers);

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
        a5_3 = new JRadioButton(ProfileViewModel.MC_A);
        b5_3 = new JRadioButton(ProfileViewModel.MC_B);
        c5_3 = new JRadioButton(ProfileViewModel.MC_C);
        d5_3 = new JRadioButton(ProfileViewModel.MC_D);
        e5_3 = new JRadioButton(ProfileViewModel.MC_E);
        a5_4 = new JRadioButton(ProfileViewModel.MC_A);
        b5_4 = new JRadioButton(ProfileViewModel.MC_B);
        c5_4 = new JRadioButton(ProfileViewModel.MC_C);
        d5_4 = new JRadioButton(ProfileViewModel.MC_D);
        e5_4 = new JRadioButton(ProfileViewModel.MC_E);
        a5_5 = new JRadioButton(ProfileViewModel.MC_A);
        b5_5 = new JRadioButton(ProfileViewModel.MC_B);
        c5_5 = new JRadioButton(ProfileViewModel.MC_C);
        d5_5 = new JRadioButton(ProfileViewModel.MC_D);
        e5_5 = new JRadioButton(ProfileViewModel.MC_E);


        final JPanel section5 = new JPanel();
        section5.setLayout(new BoxLayout(section5, BoxLayout.PAGE_AXIS));
        section5.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section5_label = new JLabel(ProfileViewModel.SECTION_FIVE);
        section5_label.setFont(new Font(section5.getFont().getName(), section5.getFont().getStyle(), 18));
        section5.add(section5_label);
//        this.section5Answers = new ArrayList<>();
        section5.add(questionMcq(ProfileViewModel.FIVE_QONE, a5_1, b5_1, c5_1, d5_1, e5_1, 4));
        section5.add(questionMcq(ProfileViewModel.FIVE_QTWO, a5_2, b5_2, c5_2, d5_2, e5_2, 4));
        section5.add(questionMcq(ProfileViewModel.FIVE_QTHREE, a5_3, b5_3, c5_3, d5_3, e5_3, 4));
        section5.add(questionMcq(ProfileViewModel.FIVE_QFOUR, a5_4, b5_4, c5_4, d5_4, e5_4, 4));
        section5.add(questionMcq(ProfileViewModel.FIVE_QFIVE, a5_5, b5_5, c5_5, d5_5, e5_5, 4));

        content.add(section5);
//        sectionAnswers.add(section5Answers);


        final JPanel weight = new JPanel();
        weight.setLayout(new BoxLayout(weight, BoxLayout.PAGE_AXIS));
        weight.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.sectionWeights = new HashMap<>();

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

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(save);
        save.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(buttonsPanel);

        save.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(save)) {

                            final ProfileState currentState = profileViewModel.getState();

                            profileController.execute(
                                    currentState.getGender(),
                                    currentState.getSexualOrientation(),
                                    currentState.getAgeValue(),
                                    currentState.getSectionAnswers(),
                                    currentState.getSectionWeights(),
                                    currentState.getContactMethod(),
                                    currentState.getContactInfo()
                            );
                            System.out.println("view" + getGender());
                        }
                    }
                }
        );

        addContactInfoListener();
        addContactMethodListener();
        addSection1WeightListener();
        addSection2WeightListener();
        addSection3WeightListener();
        addSection4WeightListener();
        addSection5WeightListener();
        addAgeListener();

        this.add(content);
        this.setVisible(true);

    }

    private void addContactMethodListener() {
        contactMethod.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final ProfileState currentState = profileViewModel.getState();
                currentState.setContactMethod(contactMethod.getText());
                profileViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addContactInfoListener() {
        contactInfo.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final ProfileState currentState = profileViewModel.getState();
                currentState.setContactMethod(contactInfo.getText());
                profileViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addAgeListener() {
        age.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                ageValue = Integer.parseInt(age.getText());
                final ProfileState currentState = profileViewModel.getState();
                currentState.setAgeValue(Integer.parseInt(age.getText()));
                profileViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addSection1WeightListener() {
        section1_weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section1", Integer.parseInt(section1_weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section1", Integer.parseInt(section1_weight.getText()));
                profileViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addSection2WeightListener() {
        section2_weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section2", Integer.parseInt(section2_weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section2", Integer.parseInt(section2_weight.getText()));
                profileViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addSection3WeightListener() {
        section3_weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section3", Integer.parseInt(section3_weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section3", Integer.parseInt(section3_weight.getText()));
                profileViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addSection4WeightListener() {
        section4_weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section4", Integer.parseInt(section4_weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section4", Integer.parseInt(section4_weight.getText()));
                profileViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    private void addSection5WeightListener() {
        section5_weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section5", Integer.parseInt(section5_weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section5", Integer.parseInt(section5_weight.getText()));
                profileViewModel.setState(currentState);
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public String getViewName() {
        return viewName;

    }


    public List<List<String>> getSectionAnswers() {
        return sectionAnswers;
    }

    public String getGender() {
        return gender;
    }

    public String getSexualOrientation() {
        return sexualOrientation;
    }
    public int getAgeValue() {
        return ageValue;
    }
    public Map<String, Integer> getSectionWeights() {
        return sectionWeights;
    }

    public JPanel questionMcq(String question, JRadioButton a, JRadioButton b, JRadioButton c, JRadioButton d, JRadioButton e, int i) {
        final JPanel questionMcq = new JPanel();
        questionMcq.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        questionMcq.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel questionText = new JLabel(question);
        questionMcq.add(questionText);
        ButtonGroup questionOptions = new ButtonGroup();
        questionOptions.add(a);
        questionOptions.add(b);
        questionOptions.add(c);
        questionOptions.add(d);
        questionOptions.add(e);
        questionMcq.add(a);
        questionMcq.add(b);
        questionMcq.add(c);
        questionMcq.add(d);
        questionMcq.add(e);
        final ProfileState currentState = profileViewModel.getState();
        a.addActionListener(evt -> {
            if (a.isSelected() == true) {
                currentState.getSectionAnswers().get(i).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        b.addActionListener(evt -> {
            if (b.isSelected() == true) {
                currentState.getSectionAnswers().get(i).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        c.addActionListener(evt -> {
            if (c.isSelected() == true) {
                currentState.getSectionAnswers().get(i).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        d.addActionListener(evt -> {
            if (d.isSelected() == true) {
                currentState.getSectionAnswers().get(i).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        e.addActionListener(evt -> {
            if (e.isSelected() == true) {
                currentState.getSectionAnswers().get(i).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        return questionMcq;
    }

    private void extracted1(JRadioButton a, JRadioButton b, JRadioButton c, JRadioButton d, JRadioButton e) {
        final ProfileState currentState = profileViewModel.getState();

        a.addActionListener(evt -> {
            if (a.isSelected() == true) {
                currentState.getSectionAnswers().get(0).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        b.addActionListener(evt -> {
            if (b.isSelected() == true) {
                currentState.getSectionAnswers().get(0).add(b.getText());
                profileViewModel.setState(currentState);
            }
        });

        c.addActionListener(evt -> {
            if (c.isSelected() == true) {
                currentState.getSectionAnswers().get(0).add(c.getText());
                profileViewModel.setState(currentState);
            }
        });

        d.addActionListener(evt -> {
            if (d.isSelected() == true) {
                currentState.getSectionAnswers().get(0).add(d.getText());
                profileViewModel.setState(currentState);
            }
        });

        e.addActionListener(evt -> {
            if (e.isSelected() == true) {
                currentState.getSectionAnswers().get(0).add(e.getText());
                profileViewModel.setState(currentState);
            }
        });
    }

    private void extracted2(JRadioButton a, JRadioButton b, JRadioButton c, JRadioButton d, JRadioButton e) {
        final ProfileState currentState = profileViewModel.getState();

        a.addActionListener(evt -> {
            if (a.isSelected() == true) {
                currentState.getSectionAnswers().get(1).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        b.addActionListener(evt -> {
            if (b.isSelected() == true) {
                currentState.getSectionAnswers().get(1).add(b.getText());
                profileViewModel.setState(currentState);
            }
        });

        c.addActionListener(evt -> {
            if (c.isSelected() == true) {
                currentState.getSectionAnswers().get(1).add(c.getText());
                profileViewModel.setState(currentState);
            }
        });

        d.addActionListener(evt -> {
            if (d.isSelected() == true) {
                currentState.getSectionAnswers().get(1).add(d.getText());
                profileViewModel.setState(currentState);
            }
        });

        e.addActionListener(evt -> {
            if (e.isSelected() == true) {
                currentState.getSectionAnswers().get(1).add(e.getText());
                profileViewModel.setState(currentState);
            }
        });
    }

    private void extracted3(JRadioButton a, JRadioButton b, JRadioButton c, JRadioButton d, JRadioButton e) {
        final ProfileState currentState = profileViewModel.getState();

        a.addActionListener(evt -> {
            if (a.isSelected() == true) {
                currentState.getSectionAnswers().get(2).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        b.addActionListener(evt -> {
            if (b.isSelected() == true) {
                currentState.getSectionAnswers().get(2).add(b.getText());
                profileViewModel.setState(currentState);
            }
        });

        c.addActionListener(evt -> {
            if (c.isSelected() == true) {
                currentState.getSectionAnswers().get(2).add(c.getText());
                profileViewModel.setState(currentState);
            }
        });

        d.addActionListener(evt -> {
            if (d.isSelected() == true) {
                currentState.getSectionAnswers().get(2).add(d.getText());
                profileViewModel.setState(currentState);
            }
        });

        e.addActionListener(evt -> {
            if (e.isSelected() == true) {
                currentState.getSectionAnswers().get(2).add(e.getText());
                profileViewModel.setState(currentState);
            }
        });
    }

    private void extracted4(JRadioButton a, JRadioButton b, JRadioButton c, JRadioButton d, JRadioButton e) {
        final ProfileState currentState = profileViewModel.getState();

        a.addActionListener(evt -> {
            if (a.isSelected() == true) {
                currentState.getSectionAnswers().get(3).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        b.addActionListener(evt -> {
            if (b.isSelected() == true) {
                currentState.getSectionAnswers().get(3).add(b.getText());
                profileViewModel.setState(currentState);
            }
        });

        c.addActionListener(evt -> {
            if (c.isSelected() == true) {
                currentState.getSectionAnswers().get(3).add(c.getText());
                profileViewModel.setState(currentState);
            }
        });

        d.addActionListener(evt -> {
            if (d.isSelected() == true) {
                currentState.getSectionAnswers().get(3).add(d.getText());
                profileViewModel.setState(currentState);
            }
        });

        e.addActionListener(evt -> {
            if (e.isSelected() == true) {
                currentState.getSectionAnswers().get(3).add(e.getText());
                profileViewModel.setState(currentState);
            }
        });
    }

    private void extracted5(JRadioButton a, JRadioButton b, JRadioButton c, JRadioButton d, JRadioButton e) {
        final ProfileState currentState = profileViewModel.getState();

        a.addActionListener(evt -> {
            if (a.isSelected() == true) {
                currentState.getSectionAnswers().get(4).add(a.getText());
                profileViewModel.setState(currentState);
            }
        });

        b.addActionListener(evt -> {
            if (b.isSelected() == true) {
                currentState.getSectionAnswers().get(4).add(b.getText());
                profileViewModel.setState(currentState);
            }
        });

        c.addActionListener(evt -> {
            if (c.isSelected() == true) {
                currentState.getSectionAnswers().get(4).add(c.getText());
                profileViewModel.setState(currentState);
            }
        });

        d.addActionListener(evt -> {
            if (d.isSelected() == true) {
                currentState.getSectionAnswers().get(4).add(d.getText());
                profileViewModel.setState(currentState);
            }
        });

        e.addActionListener(evt -> {
            if (e.isSelected() == true) {
                currentState.getSectionAnswers().get(4).add(e.getText());
                profileViewModel.setState(currentState);
            }
        });
    }

    public void extractGender(JRadioButton female, JRadioButton male, JRadioButton other) {
        final ProfileState currentState = profileViewModel.getState();

        female.addActionListener(evt -> {
            if (female.isSelected() == true) {
                currentState.setGender(female.getText());
                this.gender = female.getText();
                profileViewModel.setState(currentState);
            }
        });
        male.addActionListener(evt -> {
            if (male.isSelected() == true) {
                currentState.setGender(male.getText());
                this.gender = male.getText();
                profileViewModel.setState(currentState);
            }
        });
        other.addActionListener(evt -> {
            if (other.isSelected() == true) {
                currentState.setGender(other.getText());
                this.gender = other.getText();
                profileViewModel.setState(currentState);
            }
        });
    }

    public void extractSexualOrientation(JRadioButton female_so, JRadioButton male_so, JRadioButton both) {
        final ProfileState currentState = profileViewModel.getState();

        female_so.addActionListener(evt -> {
            if (female_so.isSelected() == true) {
                currentState.setSexualOrientation(female_so.getText());
                this.sexualOrientation = female_so.getText();
                profileViewModel.setState(currentState);
            }
        });
        male_so.addActionListener(evt -> {
            if (male_so.isSelected() == true) {
                currentState.setSexualOrientation(male_so.getText());
                this.sexualOrientation = male_so.getText();
                profileViewModel.setState(currentState);
            }
        });
        both.addActionListener(evt -> {
            if (both.isSelected() == true) {
                currentState.setSexualOrientation(both.getText());
                this.sexualOrientation = both.getText();
                profileViewModel.setState(currentState);
            }
        });
    }

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;

    }
}
