package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.ChangePasswordViewModel;
import interface_adapter.change_password.ChangedPasswordState;
import interface_adapter.logout.LogoutController;

/**
 * The View for when the user is logged into the program.
 */
public class ChangePasswordView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final ChangePasswordViewModel changePasswordViewModel;
    private final JLabel passwordErrorField = new JLabel();
    private ChangePasswordController changePasswordController;
    private LogoutController logoutController;

    private final JButton back;

    private final JTextField usernameInputField = new JTextField(15);
    private final JTextField passwordInputField1 = new JTextField(15);
    private final JTextField passwordInputField2 = new JTextField(15);
    private final JTextField securityInputField = new JTextField(15);
    private final JButton changePassword;

    public ChangePasswordView(ChangePasswordViewModel changePasswordViewModel) {
        this.changePasswordViewModel = changePasswordViewModel;
        this.changePasswordViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Reset new password");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("username"), usernameInputField);
        final LabelTextPanel passwordInfo1 = new LabelTextPanel(
                new JLabel("New password"), passwordInputField1);
        final LabelTextPanel passwordInfo2 = new LabelTextPanel(
                new JLabel("Repeat new password"), passwordInputField2);
        final LabelTextPanel securityInfo = new LabelTextPanel(
                new JLabel("Security question"), securityInputField);

        final JPanel buttons = new JPanel();
        back = new JButton("cancel");
        buttons.add(back);

        changePassword = new JButton("change password");
        buttons.add(changePassword);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        changePassword.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(changePassword)) {
                            final ChangedPasswordState currentState = changePasswordViewModel.getState();
                            changePasswordController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword(),
                                    currentState.getSecurityWord()
                            );
                        }
                    }
                }
        );

        back.addActionListener(evt -> {
            if (changePasswordController != null) {
                changePasswordController.handleCancel();
            }
        });

        addUsernameListener();
        addPasswordListener();
        addRepeatPasswordListener();
        addSecurityQuestionListener();

        this.add(title);
        this.add(usernameInfo);
        this.add(passwordInfo1);
        this.add(passwordInfo2);
        this.add(securityInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    private void addUsernameListener() {
        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final ChangedPasswordState currentState = changePasswordViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                changePasswordViewModel.setState(currentState);
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

    private void addPasswordListener() {
        passwordInputField1.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final ChangedPasswordState currentState = changePasswordViewModel.getState();
                currentState.setPassword(new String(passwordInputField1.getText()));
                changePasswordViewModel.setState(currentState);
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

    private void addRepeatPasswordListener() {
        passwordInputField2.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final ChangedPasswordState currentState = changePasswordViewModel.getState();
                currentState.setRepeatPassword(new String(passwordInputField2.getText()));
                changePasswordViewModel.setState(currentState);
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

    private void addSecurityQuestionListener() {
        securityInputField.getDocument().addDocumentListener(new DocumentListener() {
            private void documentListenerHelper() {
                final ChangedPasswordState currentState = changePasswordViewModel.getState();
                currentState.setSecurityWord(new String(securityInputField.getText()));
                changePasswordViewModel.setState(currentState);
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
    public void propertyChange(PropertyChangeEvent evt) {
        final ChangedPasswordState state = (ChangedPasswordState) evt.getNewValue();
        setFields(state);
        passwordErrorField.setText(state.getPasswordError());
    }

    private void setFields(ChangedPasswordState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField1.setText(state.getPassword());
    }

    public String getViewName() {
        return viewName;
    }

    public void setChangePasswordController(ChangePasswordController changePasswordController) {
        this.changePasswordController = changePasswordController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}
