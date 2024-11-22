package interface_adapter.profile;

import interface_adapter.ViewManagerModel;
import use_case.createProfile.CreateProfileInputBoundary;
import use_case.createProfile.CreateProfileInputData;

import java.util.List;

public class ProfileController {

    private final CreateProfileInputBoundary userCreateProfileUseCaseInteractor;
    private final ViewManagerModel viewManagerModel;

    public ProfileController(CreateProfileInputBoundary userCreateProfileUseCaseInteractor, ViewManagerModel viewManagerModel) {
        this.userCreateProfileUseCaseInteractor = userCreateProfileUseCaseInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Executes the CreateProfile Use Case.
     * @param name the name of the user
     * @param gender the gender of the user
     * @param SexualOrientation the sexual orientation of the user
     * @param age the age of the user
     * @param answers the answers to the questions
     * @param weights the weights of the answers
     */
    public void execute(String name, String gender, String SexualOrientation, int age, List<List<String>> answers, List<Integer> weights) {
        final CreateProfileInputData createProfileInputData = new CreateProfileInputData(name, gender, SexualOrientation, age, answers, weights);
        userCreateProfileUseCaseInteractor.execute(createProfileInputData);
    }

    /**
     * Executes the "switch to DashboardView" Use Case.
     */
    //    void switchToDashboardView(){
//
//    }

    /**
     * Handles the Cancel action to switch back to the Home Page.
     */
    public void handleCancel() {
        // Switch back to the homepage or another view
        viewManagerModel.setState("home");
        viewManagerModel.firePropertyChanged();
    }
}