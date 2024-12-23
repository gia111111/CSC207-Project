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
        System.out.println(profile.getWeights());
        System.out.println(profile.getAnswer());
        System.out.println(profile.getName());
        System.out.println(profile.getAge());
        System.out.println(profile.getSexualOrientation());
        System.out.println(profile.getGender());
        System.out.println(profile.getContactInfo());
        System.out.println(profile.getContactMethod());

        if (isProfileIncomplete(profile)) {
            profilePresenter.prepareFailView(Constants.ERROR_MESSAGE_one);
        }
        else if (areWeightsInvalid(profile)) {
            profilePresenter.prepareFailView(Constants.ERROR_MESSAGE_two);
        }
        else {
            profileDataAccessObject.save(profile);
            final CreateProfileOutputData createProfileOutputData =
                    new CreateProfileOutputData(profile.getName(), false);
            profilePresenter.prepareSuccessView(createProfileOutputData);
        }
    }

    private boolean isProfileIncomplete(Profile profile) {
        return isGenderInvalid(profile) || isSexualOrientationInvalid(profile) || isAgeInvalid(profile)
                || areAnswersInvalid(profile) || isContactMethodInvalid(profile)
                || isContactInfoInvalid(profile);
    }

    private boolean isGenderInvalid(Profile profile) {
        return profile.getGender().isEmpty();
    }

    private boolean isSexualOrientationInvalid(Profile profile) {
        return profile.getSexualOrientation().isEmpty();
    }

    private boolean isAgeInvalid(Profile profile) {
        return profile.getAge() == 0;
    }

    private boolean areAnswersInvalid(Profile profile) {
        return profile.getAnswer().size() != Constants.SECTION_NUMBER
                || profile.getAnswer().get(Constants.SECTION_1).size() != Constants.SECTION_ONE_QUESTIONS
                || profile.getAnswer().get(Constants.SECTION_2).size() != Constants.SECTION_TWO_QUESTIONS
                || profile.getAnswer().get(Constants.SECTION_3).size() != Constants.SECTION_THREE_QUESTIONS
                || profile.getAnswer().get(Constants.SECTION_4).size() != Constants.SECTION_FOUR_QUESTIONS
                || profile.getAnswer().get(Constants.SECTION_5).size() != Constants.SECTION_FIVE_QUESTIONS;
    }

    private boolean areWeightsInvalid(Profile profile) {
        return profile.getWeights().size() != Constants.SECTION_NUMBER
                || profile.getWeights().get(Constants.SECTION_1_WEIGHT)
                + profile.getWeights().get(Constants.SECTION_2_WEIGHT)
                + profile.getWeights().get(Constants.SECTION_3_WEIGHT)
                + profile.getWeights().get(Constants.SECTION_4_WEIGHT)
                + profile.getWeights().get(Constants.SECTION_5_WEIGHT) != Constants.TOTAL_WEIGHTS;
    }

    private boolean isContactMethodInvalid(Profile profile) {
        return profile.getContactMethod().isEmpty();
    }

    private boolean isContactInfoInvalid(Profile profile) {
        return profile.getContactInfo().isEmpty();
    }

}
