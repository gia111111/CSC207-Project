package interface_adapter.editprofile;

import interface_adapter.ViewManagerModel;
import use_case.editprofile.EditProfileInputBoundary;
import use_case.editprofile.EditProfileInputData;

import java.util.List;
import java.util.Map;

/**
 * Controller for the EditProfile Use Case.
 */
public class EditProfileController {
    private final EditProfileInputBoundary userEditProfileUseCaseInteractor;
    private final EditProfileViewModel editProfileViewModel;
    private final ViewManagerModel viewManagerModel;

    public EditProfileController(EditProfileInputBoundary userEditProfileUseCaseInteractor,
                                 EditProfileViewModel editProfileViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.userEditProfileUseCaseInteractor = userEditProfileUseCaseInteractor;
        this.editProfileViewModel = editProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Executes the EditProfile Use Case.
     * @param name the name of the user
     * @param gender the gender of the user
     * @param SexualOrientation the sexual orientation of the user
     * @param age the age of the user
     * @param answers the answers to the questions
     * @param weights the weights of the answers
     */
    public void execute(String name, String gender, String SexualOrientation, int age, List<List<String>> answers, Map<String, Integer> weights) {
        final EditProfileInputData editProfileInputData = new EditProfileInputData(name, gender, SexualOrientation, age, answers, weights);
        userEditProfileUseCaseInteractor.execute(editProfileInputData);
    }

    /**
     * Handles the Cancel action to switch back to the Home Page.
     */
    public void handleCancel() {
        // Switch back to the homepage or another view
        viewManagerModel.setState("home");
        editProfileViewModel.firePropertyChanged();
    }

    /**
     * Executes the "switch to DashboardView" Use Case.
     */
}
