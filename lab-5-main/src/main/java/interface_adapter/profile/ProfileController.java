package interface_adapter.profile;

import data_access.InMemoryUserDataAccessObject;
import data_access.RemoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.createProfile.CreateProfileInputBoundary;
import use_case.createProfile.CreateProfileInputData;

import java.util.List;
import java.util.Map;

public class ProfileController {

    private final CreateProfileInputBoundary userCreateProfileUseCaseInteractor;
    private final ViewManagerModel viewManagerModel;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public ProfileController(CreateProfileInputBoundary userCreateProfileUseCaseInteractor, ViewManagerModel viewManagerModel, RemoteDataAccessObject dataAccessObject) {
        this.userCreateProfileUseCaseInteractor = userCreateProfileUseCaseInteractor;
        this.viewManagerModel = viewManagerModel;
        this.remoteDataAccessObject = dataAccessObject;
    }

    /**
     * Executes the CreateProfile Use Case.
     * @param gender the gender of the user
     * @param sexualOrientation the sexual orientation of the user
     * @param age the age of the user
     * @param answers the answers to the questions
     * @param weights the weights of the answers
     */
    public void execute(String gender, String sexualOrientation, int age, List<List<String>> answers, Map<String, Integer> weights) {
        final CreateProfileInputData createProfileInputData = new CreateProfileInputData(gender, sexualOrientation, age, answers, weights, remoteDataAccessObject);
        userCreateProfileUseCaseInteractor.execute(createProfileInputData);
//        remoteDataAccessObject.setGender(gender);
//        remoteDataAccessObject.setSexualOrientation(sexualOrientation);
//        remoteDataAccessObject.setSectionAnswers(answers);
//        remoteDataAccessObject.setSectionWeights(weights);
//        System.out.println(remoteDataAccessObject.getGender());
//        System.out.println(remoteDataAccessObject.getSectionWeights());

    }

    /**x
     * Executes the "switch to DashboardView" Use Case.
     */
    //    void switchToDashboardView(){
//
//    }

}