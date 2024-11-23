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
        final String gender = createProfileInputData.getGender();
        final String sexualOrientation = createProfileInputData.getSexualOrientation();
        final int ageValue = createProfileInputData.getAge();
        final List<List<String>> sectionAnswers = createProfileInputData.getAnswers();
        final Map<String, Integer> sectionWeights = createProfileInputData.getWeights();

//        final Profile profile = profileFactory.create(createProfileInputData.getName(), createProfileInputData.getGender(), createProfileInputData.getSexualOrientation(), createProfileInputData.getAge(), createProfileInputData.getAnswers(), createProfileInputData.getWeights());
//        profileDataAccessObject.save(profile);
//
//        final CreateProfileOutputData createProfileOutputData = new CreateProfileOutputData(profile.getName(), false);
//        profilePresenter.prepareSuccessView(createProfileOutputData);

        if (gender != null && sexualOrientation != null && ageValue != 0 && sectionAnswers.size() == 5 && sectionAnswers.get(0).size() == 10
        && sectionAnswers.get(1).size()==10 && sectionAnswers.get(2).size()==10 && sectionAnswers.get(3).size()==10 && sectionAnswers.get(4).size()==10
        && sectionWeights.size()==5) {
            final Profile profile = profileFactory.create(createProfileInputData.getName(), createProfileInputData.getGender(), createProfileInputData.getSexualOrientation(), createProfileInputData.getAge(), createProfileInputData.getAnswers(), createProfileInputData.getWeights());
            profileDataAccessObject.save(profile);

            final CreateProfileOutputData createProfileOutputData = new CreateProfileOutputData(profile.getName(), false);
            profilePresenter.prepareSuccessView(createProfileOutputData);
        }
        else {
            profilePresenter.prepareFailView("Please answer every question!");
        }

    }

    @Override
    public void switchToDashBroadView() {
        profilePresenter.switchToDashBoardView();
    }
}
