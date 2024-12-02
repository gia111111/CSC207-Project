package use_case.changePassword;

import entity.User;
import entity.UserFactory;

/**
 * The Change Password Interactor.
 */
public class ChangePasswordInteractor implements ChangePasswordInputBoundary {
    private final ChangePasswordUserDataAccessInterface userDataAccessObject;
    private final ChangePasswordOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public ChangePasswordInteractor(ChangePasswordUserDataAccessInterface changePasswordDataAccessInterface,
                                    ChangePasswordOutputBoundary changePasswordOutputBoundary,
                                    UserFactory userFactory) {
        this.userDataAccessObject = changePasswordDataAccessInterface;
        this.userPresenter = changePasswordOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(ChangePasswordInputData changePasswordInputData) {
        final String username = changePasswordInputData.getUsername();
        final String password = changePasswordInputData.getPassword();
        final String repeatPassword = changePasswordInputData.getRepeatPassword();
        final User user = userDataAccessObject.get(changePasswordInputData.getUsername());
        if (!userDataAccessObject.existsByName(username)) {
            userPresenter.prepareFailView(username + ": Account doesn't exist.");
        }

        else if (!changePasswordInputData.getSecurityWord().equals(user.getSecurityWord())) {
            userPresenter.prepareFailView( username + ": Security word doesn't match.");
        }


        else {
            if (!password.equals(repeatPassword)){
                userPresenter.prepareFailView("Passwords don't match.");
            }
            else{
                user.setPassword(changePasswordInputData.getPassword());
                userDataAccessObject.changePassword(user);
                final ChangePasswordOutputData changePasswordOutputData= new ChangePasswordOutputData(user.getName(),false);
                userPresenter.prepareSuccessView(changePasswordOutputData);

            }
        }

    }
}
