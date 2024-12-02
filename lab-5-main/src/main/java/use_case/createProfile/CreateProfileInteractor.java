package use_case.createProfile;

import entity.Profile;
import entity.ProfileFactory;
import use_case.Constants;

/**
 * The CreateProfile Interactor.
 */
public class CreateProfileInteractor implements CreateProfileInputBoundary {
    private final CreateProfileDataAccessInterface profileDataAccessObject;
    private final CreateProfileOutputBoundary profilePresenter;
    private final ProfileFactory profileFactory;

    /**
     * The constructor of CreateProfileInteractor.
     * @param profileDataAccessInterface The profile data access interface.
     * @param profileOutputBoundary The profile output boundary.
     * @param profileFactory The profile factory.
     */
    public CreateProfileInteractor(CreateProfileDataAccessInterface profileDataAccessInterface,
                                   CreateProfileOutputBoundary profileOutputBoundary,
                                   ProfileFactory profileFactory) {
        this.profileDataAccessObject = profileDataAccessInterface;
        this.profilePresenter = profileOutputBoundary;
        this.profileFactory = profileFactory;

    }

    @Override
    public void execute(CreateProfileInputData createProfileInputData) {
        final Profile profile = profileFactory.create(createProfileInputData.getName(),
                createProfileInputData.getGender(),
                createProfileInputData.getSexualOrientation(),
                createProfileInputData.getAge(),
                createProfileInputData.getAnswers(),
                createProfileInputData.getWeights(),
                createProfileInputData.getContactInfo(),
                createProfileInputData.getContactMethod());

        if ((profile.getGender() == "") || (profile.getSexualOrientation() == "")
                || (profile.getAge() == 0) || (profile.getAnswer().size() != Constants.SECTION_NUMBER)
                || (profile.getAnswer().get(Constants.SECTION_1).size() != Constants.SECTION_ONE_QUESTIONS)
                || (profile.getAnswer().get(Constants.SECTION_2).size() != Constants.SECTION_TWO_QUESTIONS)
                || (profile.getAnswer().get(Constants.SECTION_3).size() != Constants.SECTION_THREE_QUESTIONS)
                || (profile.getAnswer().get(Constants.SECTION_4).size() != Constants.SECTION_FOUR_QUESTIONS)
                || (profile.getAnswer().get(Constants.SECTION_5).size() != Constants.SECTION_FIVE_QUESTIONS)
                || (profile.getWeights().size() != Constants.SECTION_NUMBER)
                || ((profile.getWeights().get(Constants.SECTION_1)
                + profile.getWeights().get(Constants.SECTION_2)
                + profile.getWeights().get(Constants.SECTION_3)
                + profile.getWeights().get(Constants.SECTION_4)
                + profile.getWeights().get(Constants.SECTION_5) != Constants.TOTAL_WEIGHTS))
                || (profile.getContactMethod() == "")
                || (profile.getContactInfo() == "")) {
            profilePresenter.prepareFailView(Constants.ERROR_MESSAGE);
        }
        else {
            profileDataAccessObject.save(profile);
            final CreateProfileOutputData createProfileOutputData =
                    new CreateProfileOutputData(profile.getName(), false);
            profilePresenter.prepareSuccessView(createProfileOutputData);
        }
    }

    @Override
    public void switchToDashBroadView() {
        profilePresenter.switchToDashBoardView();
    }
}
