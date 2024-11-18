package use_case.editprofile;

/**
 * Input Boundary for actions which are related to editing the profile.
 */
public interface EditProfileInputBoundary {

        /**
        * Executes the edit profile use case.
        * @param editProfileInputData the input data
        */
        void execute(EditProfileInputData editProfileInputData);

        /**
        * Executes the switch to profile view use case.
        */
        void switchToProfileView();
}
