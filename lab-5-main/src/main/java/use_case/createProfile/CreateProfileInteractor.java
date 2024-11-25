package use_case.createProfile;

import entity.Profile;
import entity.ProfileFactory;

import java.util.List;
import java.util.Map;

/**
 * The CreateProfile Interactor.
 */
public class CreateProfileInteractor implements CreateProfileInputBoundary {
    private final CreateProfileDataAccessInterface profileDataAccessObject;
    private final CreateProfileOutputBoundary profilePresenter;
    private final ProfileFactory profileFactory;


    public CreateProfileInteractor(CreateProfileDataAccessInterface profileDataAccessInterface,
                                   CreateProfileOutputBoundary profileOutputBoundary,
                                   ProfileFactory profileFactory) {
        this.profileDataAccessObject = profileDataAccessInterface;
        this.profilePresenter = profileOutputBoundary;
        this.profileFactory = profileFactory;

    }

    @Override
    public void execute(CreateProfileInputData createProfileInputData) {
//        final String gender = createProfileInputData.getGender();
//        final String sexualOrientation = createProfileInputData.getSexualOrientation();
//        final int ageValue = createProfileInputData.getAge();
//        final List<List<String>> sectionAnswers = createProfileInputData.getAnswers();
//        final Map<String, Integer> sectionWeights = createProfileInputData.getWeights();

        final Profile profile = profileFactory.create(createProfileInputData.getName(),
                createProfileInputData.getGender(),
                createProfileInputData.getSexualOrientation(),
                createProfileInputData.getAge(),
                createProfileInputData.getAnswers(),
                createProfileInputData.getWeights(),
                createProfileInputData.getContactInfo(),
                createProfileInputData.getContactMethod());

        if ((profile.getGender() == "") || (profile.getSexualOrientation() == "") || (profile.getAge() == 0) || (profile.getAnswer().size() != 5)
        || (profile.getAnswer().get("section 1").size() != 5) || (profile.getAnswer().get("section 2").size() != 5) || (profile.getAnswer().get("section 3").size() != 5)
        || (profile.getAnswer().get("section 4").size() != 5) || (profile.getAnswer().get("section 5").size() != 5) || (profile.getWeights().size() != 5)
        || ((profile.getWeights().get("section1") + profile.getWeights().get("section2") + profile.getWeights().get("section3") + profile.getWeights().get("section4") + profile.getWeights().get("section5") != 100)|| (profile.getContactMethod() == "") || (profile.getContactInfo() == ""))) {
            profilePresenter.prepareFailView("Please answer every question!");
        }
        else {

            profileDataAccessObject.save(profile);

            final CreateProfileOutputData createProfileOutputData = new CreateProfileOutputData(profile.getName(), false);
            profilePresenter.prepareSuccessView(createProfileOutputData);

        }

    }

    @Override
    public void switchToDashBroadView() {
        profilePresenter.switchToDashBoardView();
    }
}
