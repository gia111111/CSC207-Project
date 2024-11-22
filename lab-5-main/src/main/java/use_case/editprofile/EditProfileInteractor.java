package use_case.editprofile;

/**
 * The Edit Profile Interactor.
 */
public class EditProfileInteractor {
    private final EditProfileUserDataAccessInterface userDataAccessObject;
    private final EditProfileOutputBoundary userPresenter;

    public EditProfileInteractor(EditProfileUserDataAccessInterface editProfileDataAccessInterface,
                                 EditProfileOutputBoundary editProfileOutputBoundary) {
        this.userDataAccessObject = editProfileDataAccessInterface;
        this.userPresenter = editProfileOutputBoundary;
    }
    
    public void execute(EditProfileInputData editProfileInputData) {
        userDataAccessObject.save(editProfileInputData);
        userPresenter.switchToDashBroadView();
    }

}
