package view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final JLabel passwordErrorField = new JLabel();
    private ChangePasswordController changePasswordController;
//    private ChangePasswordController changePasswordController2;
    private LogoutController logoutController;

    private final JButton logOut;

    private final JTextField usernameInputField = new JTextField(15);
    private final JTextField passwordInputField1 = new JTextField(15);
    private final JTextField passwordInputField2 = new JTextField(15);
    private final JTextField securityInputField = new JTextField(15);
    private final JButton changePassword;

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Reset new password");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("username"), usernameInputField);
        final LabelTextPanel passwordInfo1 = new LabelTextPanel(
                new JLabel("New password"), passwordInputField1);
        final LabelTextPanel passwordInfo2 = new LabelTextPanel(
                new JLabel("Repeat new password"), passwordInputField2);
        final LabelTextPanel securityInfo = new LabelTextPanel(
                new JLabel("Security question"),securityInputField);


        // final JLabel usernameInfo = new JLabel("Currently logged in: ");
        // username = new JLabel();

        final JPanel buttons = new JPanel();
        logOut = new JButton("Log Out");
        buttons.add(logOut);

        changePassword = new JButton("Change Password");
        buttons.add(changePassword);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        passwordInputField1.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setPassword(passwordInputField1.getText());
                loggedInViewModel.setState(currentState);
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

        passwordInputField2.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
//                if (passwordInputField1.getText().equals(passwordInputField2.getText())) {
                    final LoggedInState currentState = loggedInViewModel.getState();
                    currentState.setPassword(passwordInputField2.getText());
                    loggedInViewModel.setState(currentState);
                }
//            }
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

        securityInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
//                if (passwordInputField1.getText().equals(passwordInputField2.getText())) {
                final LoggedInState currentState = loggedInViewModel.getState();
                currentState.setSecurity(securityInputField.getText());
                loggedInViewModel.setState(currentState);
            }
            //            }
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

        changePassword.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(changePassword)) {
                        final LoggedInState currentState = loggedInViewModel.getState();

                        this.changePasswordController.execute(
                                currentState.getUsername(),
                                currentState.getPassword(),
                                currentState.getSecurityWord(),
                                currentState.getPasswordError()
                        );
                        // After changing the password, redirect to the login view
                        this.changePasswordController.redirectToLogin();
//                      this.changePasswordController2.execute(
//                                currentState.getUsername(),
//                                currentState.getPassword(),
//                                );

                    }
                }
        );


        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        // TODO: execute the logout use case through the Controller
                        // 1. get the state out of the loggedInViewModel. It contains the username.
                        // 2. Execute the logout Controller.
                        final LoggedInState currentState = loggedInViewModel.getState();
                        this.logoutController.execute(currentState.getUsername());
                    }
                }
        );


        this.add(title);
        // this.add(usernameInfo);
        // this.add(username);
        this.add(usernameInfo);
        this.add(passwordInfo1);
        this.add(passwordInfo2);
        this.add(securityInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            // username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setChangePasswordController(ChangePasswordController changePasswordController) {
        this.changePasswordController = changePasswordController;
    }

    public void setLogoutController(LogoutController logoutController) {
        // TODO: save the logout controller in the instance variable.
        this.logoutController = logoutController;
    }
}
