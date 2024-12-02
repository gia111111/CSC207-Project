package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfileState;
import interface_adapter.profile.ProfileViewModel;

/**
 * Initializes profile view.
 */
public class ProfileView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "profile";

    private final ProfileViewModel profileViewModel;
    private ProfileController profileController;
    private final JLabel profileErrorField = new JLabel();
    private final JTextField age = new JTextField(10);
    private final JTextField section1Weight = new JTextField(10);
    private final JTextField section2Weight = new JTextField(10);
    private final JTextField section3Weight = new JTextField(10);
    private final JTextField section4Weight = new JTextField(10);
    private final JTextField section5Weight = new JTextField(10);
    private final JTextField contactMethod = new JTextField(10);
    private final JTextField contactInfo = new JTextField(10);
    private final JButton save;
    private final JRadioButton a11;
    private final JRadioButton b11;
    private final JRadioButton c11;
    private final JRadioButton d11;
    private final JRadioButton e11;
    private final JRadioButton a12;
    private final JRadioButton b12;
    private final JRadioButton c12;
    private final JRadioButton d12;
    private final JRadioButton e12;
    private final JRadioButton a13;
    private final JRadioButton b13;
    private final JRadioButton c13;
    private final JRadioButton d13;
    private final JRadioButton e13;
    private final JRadioButton a14;
    private final JRadioButton b14;
    private final JRadioButton c14;
    private final JRadioButton d14;
    private final JRadioButton e14;
    private final JRadioButton a15;
    private final JRadioButton b15;
    private final JRadioButton c15;
    private final JRadioButton d15;
    private final JRadioButton e15;

    private final JRadioButton a21;
    private final JRadioButton b21;
    private final JRadioButton c21;
    private final JRadioButton d21;
    private final JRadioButton e21;
    private final JRadioButton a22;
    private final JRadioButton b22;
    private final JRadioButton c22;
    private final JRadioButton d22;
    private final JRadioButton e22;
    private final JRadioButton a23;
    private final JRadioButton b23;
    private final JRadioButton c23;
    private final JRadioButton d23;
    private final JRadioButton e23;
    private final JRadioButton a24;
    private final JRadioButton b24;
    private final JRadioButton c24;
    private final JRadioButton d24;
    private final JRadioButton e24;
    private final JRadioButton a25;
    private final JRadioButton b25;
    private final JRadioButton c25;
    private final JRadioButton d25;
    private final JRadioButton e25;

    private final JRadioButton a31;
    private final JRadioButton b31;
    private final JRadioButton c31;
    private final JRadioButton d31;
    private final JRadioButton e31;
    private final JRadioButton a32;
    private final JRadioButton b32;
    private final JRadioButton c32;
    private final JRadioButton d32;
    private final JRadioButton e32;
    private final JRadioButton a33;
    private final JRadioButton b33;
    private final JRadioButton c33;
    private final JRadioButton d33;
    private final JRadioButton e33;
    private final JRadioButton a34;
    private final JRadioButton b34;
    private final JRadioButton c34;
    private final JRadioButton d34;
    private final JRadioButton e34;
    private final JRadioButton a35;
    private final JRadioButton b35;
    private final JRadioButton c35;
    private final JRadioButton d35;
    private final JRadioButton e35;

    private final JRadioButton a41;
    private final JRadioButton b41;
    private final JRadioButton c41;
    private final JRadioButton d41;
    private final JRadioButton e41;
    private final JRadioButton a42;
    private final JRadioButton b42;
    private final JRadioButton c42;
    private final JRadioButton d42;
    private final JRadioButton e42;
    private final JRadioButton a43;
    private final JRadioButton b43;
    private final JRadioButton c43;
    private final JRadioButton d43;
    private final JRadioButton e43;
    private final JRadioButton a44;
    private final JRadioButton b44;
    private final JRadioButton c44;
    private final JRadioButton d44;
    private final JRadioButton e44;
    private final JRadioButton a45;
    private final JRadioButton b45;
    private final JRadioButton c45;
    private final JRadioButton d45;
    private final JRadioButton e45;

    private final JRadioButton a51;
    private final JRadioButton b51;
    private final JRadioButton c51;
    private final JRadioButton d51;
    private final JRadioButton e51;
    private final JRadioButton a52;
    private final JRadioButton b52;
    private final JRadioButton c52;
    private final JRadioButton d52;
    private final JRadioButton e52;
    private final JRadioButton a53;
    private final JRadioButton b53;
    private final JRadioButton c53;
    private final JRadioButton d53;
    private final JRadioButton e53;
    private final JRadioButton a54;
    private final JRadioButton b54;
    private final JRadioButton c54;
    private final JRadioButton d54;
    private final JRadioButton e54;
    private final JRadioButton a55;
    private final JRadioButton b55;
    private final JRadioButton c55;
    private final JRadioButton d55;
    private final JRadioButton e55;

    private final JRadioButton female;
    private final JRadioButton male;
    private final JRadioButton other;
    private final JRadioButton femaleSexualOrientation;
    private final JRadioButton maleSexualOrientation;
    private final JRadioButton both;

    private String gender;
    private String sexualOrientation;
    private int ageValue;

    private List<List<String>> sectionAnswers;
    private Map<String, Integer> sectionWeights;
    private List<String> section1Answers;
    private List<String> section2Answers;
    private List<String> section3Answers;
    private List<String> section4Answers;
    private List<String> section5Answers;

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

        final JPanel basicInfo = new JPanel();
        basicInfo.setLayout(new BoxLayout(basicInfo, BoxLayout.PAGE_AXIS));
        basicInfo.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel basicLabel = new JLabel(ProfileViewModel.BASIC_INFORMATION);
        basicLabel.setFont(new Font(basicLabel.getFont().getName(), basicLabel.getFont().getStyle(), 18));
        basicInfo.add(basicLabel);
        final JLabel bGender = new JLabel(ProfileViewModel.BQ_GENDER);
        female = new JRadioButton("Female");
        male = new JRadioButton("Male");
        other = new JRadioButton("other");
        final ButtonGroup basicGender = new ButtonGroup();
        basicInfo.add(bGender);
        basicGender.add(female);
        basicGender.add(male);
        basicGender.add(other);
        basicInfo.add(female);
        basicInfo.add(male);
        basicInfo.add(other);
        extractGender(female, male, other);

        final JLabel bSexualOrientation = new JLabel(ProfileViewModel.BQ_SEXUAL_ORIENTATION);
        basicInfo.add(bSexualOrientation);
        femaleSexualOrientation = new JRadioButton("Female");
        maleSexualOrientation = new JRadioButton("Male");
        both = new JRadioButton("Both");
        final ButtonGroup basicSo = new ButtonGroup();
        basicSo.add(femaleSexualOrientation);
        basicSo.add(maleSexualOrientation);
        basicSo.add(both);
        basicInfo.add(femaleSexualOrientation);
        basicInfo.add(maleSexualOrientation);
        basicInfo.add(both);
        extractSexualOrientation(femaleSexualOrientation, maleSexualOrientation, both);

        final LabelTextPanel basicAge = new LabelTextPanel(
                new JLabel(ProfileViewModel.BQ_AGE), age);
        basicAge.setLayout(new BoxLayout(basicAge, BoxLayout.X_AXIS));
        basicAge.setAlignmentX(Component.LEFT_ALIGNMENT);
        basicInfo.add(basicAge);
        content.add(basicInfo);

        final LabelTextPanel contactMethod1 = new LabelTextPanel(new JLabel(ProfileViewModel.CONTACT_METHOD),
                this.contactMethod);
        final LabelTextPanel contactInfo1 = new LabelTextPanel(new JLabel(ProfileViewModel.CONTACT_INFO),
                this.contactInfo);
        contactMethod1.setLayout(new BoxLayout(contactMethod1, BoxLayout.X_AXIS));
        contactInfo1.setLayout(new BoxLayout(contactInfo1, BoxLayout.X_AXIS));
        contactMethod1.setAlignmentX(Component.LEFT_ALIGNMENT);
        contactInfo1.setAlignmentX(Component.LEFT_ALIGNMENT);
        basicInfo.add(contactMethod1);
        basicInfo.add(contactInfo1);
        content.add(contactMethod1);
        content.add(contactInfo1);

        a11 = new JRadioButton(ProfileViewModel.MC_A);
        b11 = new JRadioButton(ProfileViewModel.MC_B);
        c11 = new JRadioButton(ProfileViewModel.MC_C);
        d11 = new JRadioButton(ProfileViewModel.MC_D);
        e11 = new JRadioButton(ProfileViewModel.MC_E);
        a12 = new JRadioButton(ProfileViewModel.MC_A);
        b12 = new JRadioButton(ProfileViewModel.MC_B);
        c12 = new JRadioButton(ProfileViewModel.MC_C);
        d12 = new JRadioButton(ProfileViewModel.MC_D);
        e12 = new JRadioButton(ProfileViewModel.MC_E);
        a13 = new JRadioButton(ProfileViewModel.MC_A);
        b13 = new JRadioButton(ProfileViewModel.MC_B);
        c13 = new JRadioButton(ProfileViewModel.MC_C);
        d13 = new JRadioButton(ProfileViewModel.MC_D);
        e13 = new JRadioButton(ProfileViewModel.MC_E);
        a14 = new JRadioButton(ProfileViewModel.MC_A);
        b14 = new JRadioButton(ProfileViewModel.MC_B);
        c14 = new JRadioButton(ProfileViewModel.MC_C);
        d14 = new JRadioButton(ProfileViewModel.MC_D);
        e14 = new JRadioButton(ProfileViewModel.MC_E);
        a15 = new JRadioButton(ProfileViewModel.MC_A);
        b15 = new JRadioButton(ProfileViewModel.MC_B);
        c15 = new JRadioButton(ProfileViewModel.MC_C);
        d15 = new JRadioButton(ProfileViewModel.MC_D);
        e15 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section1 = new JPanel();
        section1.setLayout(new BoxLayout(section1, BoxLayout.PAGE_AXIS));
        section1.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section1Label = new JLabel(ProfileViewModel.SECTION_ONE);
        section1Label.setFont(new Font(section1.getFont().getName(), section1.getFont().getStyle(), 18));
        section1.add(section1Label);
        this.section1Answers = new ArrayList<>();
        section1.add(questionMcq(ProfileViewModel.ONE_QONE, a11, b11, c11, d11, e11));
        section1.add(questionMcq(ProfileViewModel.ONE_QTWO, a12, b12, c12, d12, e12));
        section1.add(questionMcq(ProfileViewModel.ONE_QTHREE, a13, b13, c13, d13, e13));
        section1.add(questionMcq(ProfileViewModel.ONE_QFOUR, a14, b14, c14, d14, e14));
        section1.add(questionMcq(ProfileViewModel.ONE_QFIVE, a15, b15, c15, d15, e15));
        extracted1(a11, b11, c11, d11, e11);
        extracted1(a12, b12, c12, d12, e12);
        extracted1(a13, b13, c13, d13, e13);
        extracted1(a14, b14, c14, d14, e14);
        extracted1(a15, b15, c15, d15, e15);

        content.add(section1);
        sectionAnswers.add(section1Answers);

        a21 = new JRadioButton(ProfileViewModel.MC_A);
        b21 = new JRadioButton(ProfileViewModel.MC_B);
        c21 = new JRadioButton(ProfileViewModel.MC_C);
        d21 = new JRadioButton(ProfileViewModel.MC_D);
        e21 = new JRadioButton(ProfileViewModel.MC_E);
        a22 = new JRadioButton(ProfileViewModel.MC_A);
        b22 = new JRadioButton(ProfileViewModel.MC_B);
        c22 = new JRadioButton(ProfileViewModel.MC_C);
        d22 = new JRadioButton(ProfileViewModel.MC_D);
        e22 = new JRadioButton(ProfileViewModel.MC_E);
        a23 = new JRadioButton(ProfileViewModel.MC_A);
        b23 = new JRadioButton(ProfileViewModel.MC_B);
        c23 = new JRadioButton(ProfileViewModel.MC_C);
        d23 = new JRadioButton(ProfileViewModel.MC_D);
        e23 = new JRadioButton(ProfileViewModel.MC_E);
        a24 = new JRadioButton(ProfileViewModel.MC_A);
        b24 = new JRadioButton(ProfileViewModel.MC_B);
        c24 = new JRadioButton(ProfileViewModel.MC_C);
        d24 = new JRadioButton(ProfileViewModel.MC_D);
        e24 = new JRadioButton(ProfileViewModel.MC_E);
        a25 = new JRadioButton(ProfileViewModel.MC_A);
        b25 = new JRadioButton(ProfileViewModel.MC_B);
        c25 = new JRadioButton(ProfileViewModel.MC_C);
        d25 = new JRadioButton(ProfileViewModel.MC_D);
        e25 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section2 = new JPanel();
        section2.setLayout(new BoxLayout(section2, BoxLayout.PAGE_AXIS));
        section2.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section2Label = new JLabel(ProfileViewModel.SECTION_TWO);
        section2Label.setFont(new Font(section2.getFont().getName(), section2.getFont().getStyle(), 18));
        section2.add(section2Label);
        this.section2Answers = new ArrayList<>();
        section2.add(questionMcq(ProfileViewModel.TWO_QONE, a21, b21, c21, d21, e21));
        section2.add(questionMcq(ProfileViewModel.TWO_QTWO, a22, b22, c22, d22, e22));
        section2.add(questionMcq(ProfileViewModel.TWO_QTHREE, a23, b23, c23, d23, e23));
        section2.add(questionMcq(ProfileViewModel.TWO_QFOUR, a24, b24, c24, d24, e24));
        section2.add(questionMcq(ProfileViewModel.TWO_QFIVE, a25, b25, c25, d25, e25));
        extracted2(a21, b21, c21, d21, e21);
        extracted2(a22, b22, c22, d22, e22);
        extracted2(a23, b23, c23, d23, e23);
        extracted2(a24, b24, c24, d24, e24);
        extracted2(a25, b25, c25, d25, e25);

        content.add(section2);
        sectionAnswers.add(section2Answers);

        a31 = new JRadioButton(ProfileViewModel.MC_A);
        b31 = new JRadioButton(ProfileViewModel.MC_B);
        c31 = new JRadioButton(ProfileViewModel.MC_C);
        d31 = new JRadioButton(ProfileViewModel.MC_D);
        e31 = new JRadioButton(ProfileViewModel.MC_E);
        a32 = new JRadioButton(ProfileViewModel.MC_A);
        b32 = new JRadioButton(ProfileViewModel.MC_B);
        c32 = new JRadioButton(ProfileViewModel.MC_C);
        d32 = new JRadioButton(ProfileViewModel.MC_D);
        e32 = new JRadioButton(ProfileViewModel.MC_E);
        a33 = new JRadioButton(ProfileViewModel.MC_A);
        b33 = new JRadioButton(ProfileViewModel.MC_B);
        c33 = new JRadioButton(ProfileViewModel.MC_C);
        d33 = new JRadioButton(ProfileViewModel.MC_D);
        e33 = new JRadioButton(ProfileViewModel.MC_E);
        a34 = new JRadioButton(ProfileViewModel.MC_A);
        b34 = new JRadioButton(ProfileViewModel.MC_B);
        c34 = new JRadioButton(ProfileViewModel.MC_C);
        d34 = new JRadioButton(ProfileViewModel.MC_D);
        e34 = new JRadioButton(ProfileViewModel.MC_E);
        a35 = new JRadioButton(ProfileViewModel.MC_A);
        b35 = new JRadioButton(ProfileViewModel.MC_B);
        c35 = new JRadioButton(ProfileViewModel.MC_C);
        d35 = new JRadioButton(ProfileViewModel.MC_D);
        e35 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section3 = new JPanel();
        section3.setLayout(new BoxLayout(section3, BoxLayout.PAGE_AXIS));
        section3.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section3Label = new JLabel(ProfileViewModel.SECTION_THREE);
        section3Label.setFont(new Font(section3.getFont().getName(), section3.getFont().getStyle(), 18));
        section3.add(section3Label);
        this.section3Answers = new ArrayList<>();
        section3.add(questionMcq(ProfileViewModel.THREE_QONE, a31, b31, c31, d31, e31));
        section3.add(questionMcq(ProfileViewModel.THREE_QTWO, a32, b32, c32, d32, e32));
        section3.add(questionMcq(ProfileViewModel.THREE_QTHREE, a33, b33, c33, d33, e33));
        section3.add(questionMcq(ProfileViewModel.THREE_QFOUR, a34, b34, c34, d34, e34));
        section3.add(questionMcq(ProfileViewModel.THREE_QFIVE, a35, b35, c35, d35, e35));
        extracted3(a31, b31, c31, d31, e31);
        extracted3(a32, b32, c32, d32, e32);
        extracted3(a33, b33, c33, d33, e33);
        extracted3(a34, b34, c34, d34, e34);
        extracted3(a35, b35, c35, d35, e35);

        content.add(section3);
        sectionAnswers.add(section3Answers);

        a41 = new JRadioButton(ProfileViewModel.MC_A);
        b41 = new JRadioButton(ProfileViewModel.MC_B);
        c41 = new JRadioButton(ProfileViewModel.MC_C);
        d41 = new JRadioButton(ProfileViewModel.MC_D);
        e41 = new JRadioButton(ProfileViewModel.MC_E);
        a42 = new JRadioButton(ProfileViewModel.MC_A);
        b42 = new JRadioButton(ProfileViewModel.MC_B);
        c42 = new JRadioButton(ProfileViewModel.MC_C);
        d42 = new JRadioButton(ProfileViewModel.MC_D);
        e42 = new JRadioButton(ProfileViewModel.MC_E);
        a43 = new JRadioButton(ProfileViewModel.MC_A);
        b43 = new JRadioButton(ProfileViewModel.MC_B);
        c43 = new JRadioButton(ProfileViewModel.MC_C);
        d43 = new JRadioButton(ProfileViewModel.MC_D);
        e43 = new JRadioButton(ProfileViewModel.MC_E);
        a44 = new JRadioButton(ProfileViewModel.MC_A);
        b44 = new JRadioButton(ProfileViewModel.MC_B);
        c44 = new JRadioButton(ProfileViewModel.MC_C);
        d44 = new JRadioButton(ProfileViewModel.MC_D);
        e44 = new JRadioButton(ProfileViewModel.MC_E);
        a45 = new JRadioButton(ProfileViewModel.MC_A);
        b45 = new JRadioButton(ProfileViewModel.MC_B);
        c45 = new JRadioButton(ProfileViewModel.MC_C);
        d45 = new JRadioButton(ProfileViewModel.MC_D);
        e45 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section4 = new JPanel();
        section4.setLayout(new BoxLayout(section4, BoxLayout.PAGE_AXIS));
        section4.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section4Label = new JLabel(ProfileViewModel.SECTION_FOUR);
        section4Label.setFont(new Font(section4.getFont().getName(), section4.getFont().getStyle(), 18));
        section4.add(section4Label);
        this.section4Answers = new ArrayList<>();
        section4.add(questionMcq(ProfileViewModel.FOUR_QONE, a41, b41, c41, d41, e41));
        section4.add(questionMcq(ProfileViewModel.FOUR_QTWO, a42, b42, c42, d42, e42));
        section4.add(questionMcq(ProfileViewModel.FOUR_QTHREE, a43, b43, c43, d43, e43));
        section4.add(questionMcq(ProfileViewModel.FOUR_QFOUR, a44, b44, c44, d44, e44));
        section4.add(questionMcq(ProfileViewModel.FOUR_QFIVE, a45, b45, c45, d45, e45));
        extracted4(a41, b41, c41, d41, e41);
        extracted4(a42, b42, c42, d42, e42);
        extracted4(a43, b43, c43, d43, e43);
        extracted4(a44, b44, c44, d44, e44);
        extracted4(a45, b45, c45, d45, e45);

        content.add(section4);
        sectionAnswers.add(section4Answers);

        a51 = new JRadioButton(ProfileViewModel.MC_A);
        b51 = new JRadioButton(ProfileViewModel.MC_B);
        c51 = new JRadioButton(ProfileViewModel.MC_C);
        d51 = new JRadioButton(ProfileViewModel.MC_D);
        e51 = new JRadioButton(ProfileViewModel.MC_E);
        a52 = new JRadioButton(ProfileViewModel.MC_A);
        b52 = new JRadioButton(ProfileViewModel.MC_B);
        c52 = new JRadioButton(ProfileViewModel.MC_C);
        d52 = new JRadioButton(ProfileViewModel.MC_D);
        e52 = new JRadioButton(ProfileViewModel.MC_E);
        a53 = new JRadioButton(ProfileViewModel.MC_A);
        b53 = new JRadioButton(ProfileViewModel.MC_B);
        c53 = new JRadioButton(ProfileViewModel.MC_C);
        d53 = new JRadioButton(ProfileViewModel.MC_D);
        e53 = new JRadioButton(ProfileViewModel.MC_E);
        a54 = new JRadioButton(ProfileViewModel.MC_A);
        b54 = new JRadioButton(ProfileViewModel.MC_B);
        c54 = new JRadioButton(ProfileViewModel.MC_C);
        d54 = new JRadioButton(ProfileViewModel.MC_D);
        e54 = new JRadioButton(ProfileViewModel.MC_E);
        a55 = new JRadioButton(ProfileViewModel.MC_A);
        b55 = new JRadioButton(ProfileViewModel.MC_B);
        c55 = new JRadioButton(ProfileViewModel.MC_C);
        d55 = new JRadioButton(ProfileViewModel.MC_D);
        e55 = new JRadioButton(ProfileViewModel.MC_E);

        final JPanel section5 = new JPanel();
        section5.setLayout(new BoxLayout(section5, BoxLayout.PAGE_AXIS));
        section5.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel section5Label = new JLabel(ProfileViewModel.SECTION_FIVE);
        section5Label.setFont(new Font(section5.getFont().getName(), section5.getFont().getStyle(), 18));
        section5.add(section5Label);
        this.section5Answers = new ArrayList<>();
        section5.add(questionMcq(ProfileViewModel.FIVE_QONE, a51, b51, c51, d51, e51));
        section5.add(questionMcq(ProfileViewModel.FIVE_QTWO, a52, b52, c52, d52, e52));
        section5.add(questionMcq(ProfileViewModel.FIVE_QTHREE, a53, b53, c53, d53, e53));
        section5.add(questionMcq(ProfileViewModel.FIVE_QFOUR, a54, b54, c54, d54, e54));
        section5.add(questionMcq(ProfileViewModel.FIVE_QFIVE, a55, b55, c55, d55, e55));
        extracted5(a51, b51, c51, d51, e51);
        extracted5(a52, b52, c52, d52, e52);
        extracted5(a53, b53, c53, d53, e53);
        extracted5(a54, b54, c54, d54, e54);
        extracted5(a55, b55, c55, d55, e55);

        content.add(section5);
        sectionAnswers.add(section5Answers);

        final JPanel weight = new JPanel();
        weight.setLayout(new BoxLayout(weight, BoxLayout.PAGE_AXIS));
        weight.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.sectionWeights = new HashMap<>();

        final JLabel weightLabel = new JLabel(ProfileViewModel.SECTION_WEIGHT);
        weightLabel.setFont(new Font(weight.getFont().getName(), weight.getFont().getStyle(), 18));
        weight.add(weightLabel);
        final JLabel weightQuestion = new JLabel(ProfileViewModel.Q_WEIGHT);
        weight.add(weightQuestion);
        final LabelTextPanel s1Weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_ONE), section1Weight);
        final LabelTextPanel s2Weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_TWO), section2Weight);
        final LabelTextPanel s3Weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_THREE), section3Weight);
        final LabelTextPanel s4Weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_FOUR), section4Weight);
        final LabelTextPanel s5Weight = new LabelTextPanel(
                new JLabel(ProfileViewModel.SECTION_FIVE), section5Weight);
        weight.add(s1Weight);
        weight.add(s2Weight);
        weight.add(s3Weight);
        weight.add(s4Weight);
        weight.add(s5Weight);

        content.add(weight);

        final JPanel buttonsPanel = new JPanel();
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

        content.add(profileErrorField);

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
                currentState.setContactInfo(contactInfo.getText());
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
        section1Weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section1", Integer.parseInt(section1Weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section1", Integer.parseInt(section1Weight.getText()));
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
        section2Weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section2", Integer.parseInt(section2Weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section2", Integer.parseInt(section2Weight.getText()));
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
        section3Weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section3", Integer.parseInt(section3Weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section3", Integer.parseInt(section3Weight.getText()));
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
        section4Weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section4", Integer.parseInt(section4Weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section4", Integer.parseInt(section4Weight.getText()));
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
        section5Weight.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                sectionWeights.put("section5", Integer.parseInt(section5Weight.getText()));
                final ProfileState currentState = profileViewModel.getState();
                currentState.getSectionWeights().put("section5", Integer.parseInt(section5Weight.getText()));
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
        final ProfileState state = (ProfileState) evt.getNewValue();
        profileErrorField.setText(state.getErrorMessage());
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

    /**
     * Initialize buttons each individual question.
     * @param question String of question and choices.
     * @param aButton choice.
     * @param bButton choice.
     * @param cButton choice.
     * @param dButton choice.
     * @param eButton choice.
     * @return question with initialized buttons.
     */
    public JPanel questionMcq(String question, JRadioButton aButton, JRadioButton bButton, JRadioButton cButton,
                              JRadioButton dButton, JRadioButton eButton) {
        final JPanel questionMcq = new JPanel();
        questionMcq.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        questionMcq.setAlignmentX(Component.LEFT_ALIGNMENT);
        final JLabel questionText = new JLabel(question);
        questionMcq.add(questionText);
        final ButtonGroup questionOptions = new ButtonGroup();
        questionOptions.add(aButton);
        questionOptions.add(bButton);
        questionOptions.add(cButton);
        questionOptions.add(dButton);
        questionOptions.add(eButton);
        questionMcq.add(aButton);
        questionMcq.add(bButton);
        questionMcq.add(cButton);
        questionMcq.add(dButton);
        questionMcq.add(eButton);
        return questionMcq;
    }

    private void extracted1(JRadioButton aButton, JRadioButton bButton, JRadioButton cButton,
                            JRadioButton dButton, JRadioButton eButton) {
        final ProfileState currentState = profileViewModel.getState();
        final String section = "section 1";

        aButton.addActionListener(evt -> {
            if (aButton.isSelected()) {
                section1Answers.add(aButton.getText());
                currentState.getSectionAnswers().put(section, section1Answers);
                profileViewModel.setState(currentState);
            }
        });

        bButton.addActionListener(evt -> {
            if (bButton.isSelected()) {
                section1Answers.add(bButton.getText());
                currentState.getSectionAnswers().put(section, section1Answers);
                profileViewModel.setState(currentState);
            }
        });

        cButton.addActionListener(evt -> {
            if (cButton.isSelected()) {
                section1Answers.add(cButton.getText());
                currentState.getSectionAnswers().put(section, section1Answers);
                profileViewModel.setState(currentState);
            }
        });

        dButton.addActionListener(evt -> {
            if (dButton.isSelected()) {
                section1Answers.add(dButton.getText());
                currentState.getSectionAnswers().put(section, section1Answers);
                profileViewModel.setState(currentState);
            }
        });

        eButton.addActionListener(evt -> {
            if (eButton.isSelected()) {
                section1Answers.add(eButton.getText());
                currentState.getSectionAnswers().put("section 1", section1Answers);
                profileViewModel.setState(currentState);
            }
        });
    }

    private void extracted2(JRadioButton aButton, JRadioButton bButton, JRadioButton cButton,
                            JRadioButton dButton, JRadioButton eButton) {
        final ProfileState currentState = profileViewModel.getState();
        final String section = "section 2";

        aButton.addActionListener(evt -> {
            if (aButton.isSelected()) {
                section2Answers.add(aButton.getText());
                currentState.getSectionAnswers().put(section, section2Answers);
                profileViewModel.setState(currentState);
            }
        });

        bButton.addActionListener(evt -> {
            if (bButton.isSelected()) {
                section2Answers.add(bButton.getText());
                currentState.getSectionAnswers().put(section, section2Answers);
                profileViewModel.setState(currentState);
            }
        });

        cButton.addActionListener(evt -> {
            if (cButton.isSelected()) {
                section2Answers.add(cButton.getText());
                currentState.getSectionAnswers().put(section, section2Answers);
                profileViewModel.setState(currentState);
            }
        });

        dButton.addActionListener(evt -> {
            if (dButton.isSelected()) {
                section2Answers.add(dButton.getText());
                currentState.getSectionAnswers().put(section, section2Answers);
                profileViewModel.setState(currentState);
            }
        });

        eButton.addActionListener(evt -> {
            if (eButton.isSelected()) {
                section2Answers.add(eButton.getText());
                currentState.getSectionAnswers().put(section, section2Answers);
                profileViewModel.setState(currentState);
            }
        });
    }

    private void extracted3(JRadioButton aButton, JRadioButton bButton, JRadioButton cButton,
                            JRadioButton dButton, JRadioButton eButton) {
        final ProfileState currentState = profileViewModel.getState();
        final String section = "section 3";

        aButton.addActionListener(evt -> {
            if (aButton.isSelected()) {
                section3Answers.add(aButton.getText());
                currentState.getSectionAnswers().put(section, section3Answers);
                profileViewModel.setState(currentState);
            }
        });

        bButton.addActionListener(evt -> {
            if (bButton.isSelected()) {
                section3Answers.add(bButton.getText());
                currentState.getSectionAnswers().put(section, section3Answers);
                profileViewModel.setState(currentState);
            }
        });

        cButton.addActionListener(evt -> {
            if (cButton.isSelected()) {
                section3Answers.add(cButton.getText());
                currentState.getSectionAnswers().put(section, section3Answers);
                profileViewModel.setState(currentState);
            }
        });

        dButton.addActionListener(evt -> {
            if (dButton.isSelected()) {
                section3Answers.add(dButton.getText());
                currentState.getSectionAnswers().put(section, section3Answers);
                profileViewModel.setState(currentState);
            }
        });

        eButton.addActionListener(evt -> {
            if (eButton.isSelected()) {
                section3Answers.add(eButton.getText());
                currentState.getSectionAnswers().put(section, section3Answers);
                profileViewModel.setState(currentState);
            }
        });
    }

    private void extracted4(JRadioButton aButton, JRadioButton bButton, JRadioButton cButton,
                            JRadioButton dButton, JRadioButton eButton) {
        final ProfileState currentState = profileViewModel.getState();
        final String section = "section 4";

        aButton.addActionListener(evt -> {
            if (aButton.isSelected()) {
                section4Answers.add(aButton.getText());
                currentState.getSectionAnswers().put(section, section4Answers);
                profileViewModel.setState(currentState);
            }
        });

        bButton.addActionListener(evt -> {
            if (bButton.isSelected()) {
                section4Answers.add(bButton.getText());
                currentState.getSectionAnswers().put(section, section4Answers);
                profileViewModel.setState(currentState);
            }
        });

        cButton.addActionListener(evt -> {
            if (cButton.isSelected()) {
                section4Answers.add(cButton.getText());
                currentState.getSectionAnswers().put(section, section4Answers);
                profileViewModel.setState(currentState);
            }
        });

        dButton.addActionListener(evt -> {
            if (dButton.isSelected()) {
                section4Answers.add(dButton.getText());
                currentState.getSectionAnswers().put(section, section4Answers);
                profileViewModel.setState(currentState);
            }
        });

        eButton.addActionListener(evt -> {
            if (eButton.isSelected()) {
                section4Answers.add(eButton.getText());
                currentState.getSectionAnswers().put(section, section4Answers);
                profileViewModel.setState(currentState);
            }
        });
    }

    private void extracted5(JRadioButton aButton, JRadioButton bButton, JRadioButton cButton,
                            JRadioButton dButton, JRadioButton eButton) {
        final ProfileState currentState = profileViewModel.getState();
        final String section = "section 5";

        aButton.addActionListener(evt -> {
            if (aButton.isSelected()) {
                section5Answers.add(aButton.getText());
                currentState.getSectionAnswers().put(section, section5Answers);
                profileViewModel.setState(currentState);
            }
        });

        bButton.addActionListener(evt -> {
            if (bButton.isSelected()) {
                section5Answers.add(bButton.getText());
                currentState.getSectionAnswers().put(section, section5Answers);
                profileViewModel.setState(currentState);
            }
        });

        cButton.addActionListener(evt -> {
            if (cButton.isSelected()) {
                section5Answers.add(cButton.getText());
                currentState.getSectionAnswers().put(section, section5Answers);
                profileViewModel.setState(currentState);
            }
        });

        dButton.addActionListener(evt -> {
            if (dButton.isSelected()) {
                section5Answers.add(dButton.getText());
                currentState.getSectionAnswers().put(section, section5Answers);
                profileViewModel.setState(currentState);
            }
        });

        eButton.addActionListener(evt -> {
            if (eButton.isSelected()) {
                section5Answers.add(eButton.getText());
                currentState.getSectionAnswers().put(section, section5Answers);
                profileViewModel.setState(currentState);
            }
        });
    }

    /**
     * Add action listener to Gender buttons and Gender button group and update state with selection.
     * @param female1 option.
     * @param male1 option.
     * @param other1 option.
     */
    public void extractGender(JRadioButton female1, JRadioButton male1, JRadioButton other1) {
        final ProfileState currentState = profileViewModel.getState();

        female1.addActionListener(evt -> {
            if (female1.isSelected()) {
                currentState.setGender(female1.getText());
                this.gender = female1.getText();
                profileViewModel.setState(currentState);
            }
        });
        male1.addActionListener(evt -> {
            if (male1.isSelected()) {
                currentState.setGender(male1.getText());
                this.gender = male1.getText();
                profileViewModel.setState(currentState);
            }
        });
        other1.addActionListener(evt -> {
            if (other1.isSelected()) {
                currentState.setGender(other1.getText());
                this.gender = other1.getText();
                profileViewModel.setState(currentState);
            }
        });
    }

    /**
     * Add action listener to SexualOrientation buttons and SexualOrientation button group and update state
     * with selection.
     * @param femaleSo option.
     * @param maleSo option.
     * @param both1 option.
     */
    public void extractSexualOrientation(JRadioButton femaleSo, JRadioButton maleSo, JRadioButton both1) {
        final ProfileState currentState = profileViewModel.getState();

        femaleSo.addActionListener(evt -> {
            if (femaleSo.isSelected()) {
                currentState.setSexualOrientation(femaleSo.getText());
                this.sexualOrientation = femaleSo.getText();
                profileViewModel.setState(currentState);
            }
        });
        maleSo.addActionListener(evt -> {
            if (maleSo.isSelected()) {
                currentState.setSexualOrientation(maleSo.getText());
                this.sexualOrientation = maleSo.getText();
                profileViewModel.setState(currentState);
            }
        });
        both1.addActionListener(evt -> {
            if (both1.isSelected()) {
                currentState.setSexualOrientation(both1.getText());
                this.sexualOrientation = both1.getText();
                profileViewModel.setState(currentState);
            }
        });
    }

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;

    }
}
