package view;

import interface_adapter.profile.ProfileController;
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

    private final JButton save;
    private final JRadioButton a;
    private final JRadioButton b;
    private final JRadioButton c;
    private final JRadioButton d;
    private final JRadioButton e;

    public ProfileView(ProfileViewModel profileViewModel, ProfileController profileController) {
        this.profileController = profileController;
        this.profileViewModel = profileViewModel;
        profileViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel(ProfileViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        save = new JButton(ProfileViewModel.SAVE_BUTTON_LABEL);

        final JPanel section1 = new JPanel();
        section1.setLayout(new BoxLayout(section1, BoxLayout.Y_AXIS));
        final JLabel section1_label = new JLabel(ProfileViewModel.SECTION_ONE);
        section1.setFont(new Font(section1.getFont().getName(), section1.getFont().getStyle(), 24));
        section1.add(section1_label);
        final JLabel one_one = new JLabel(ProfileViewModel.ONE_QONE);
        section1.add(one_one);
        a = new JRadioButton(ProfileViewModel.MC_A);
        b = new JRadioButton(ProfileViewModel.MC_B);
        c = new JRadioButton(ProfileViewModel.MC_C);
        d = new JRadioButton(ProfileViewModel.MC_D);
        e = new JRadioButton(ProfileViewModel.MC_E);
        ButtonGroup question1_1 = new ButtonGroup();
        question1_1.add(a);
        question1_1.add(b);
        question1_1.add(c);
        question1_1.add(d);
        question1_1.add(e);
        section1.add(a);
        section1.add(b);
        section1.add(c);
        section1.add(d);
        section1.add(e);

        this.add(section1);
        save.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(save);




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
