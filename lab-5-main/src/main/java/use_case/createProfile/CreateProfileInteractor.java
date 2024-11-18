package use_case.createProfile;

import entity.Profile;
import entity.ProfileFactory;

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
        final Profile profile = profileFactory.create(createProfileInputData.getName(), createProfileInputData.getGender(), createProfileInputData.getSexualOrientation(), createProfileInputData.getAge(), createProfileInputData.getAnswers(), createProfileInputData.getWeights());
        profileDataAccessObject.save(profile);

        final CreateProfileOutputData createProfileOutputData = new CreateProfileOutputData(profile.getName(), false);
        profilePresenter.prepareSuccessView(createProfileOutputData);
    }

    @Override
    public void switchToDashBroadView() {
        profilePresenter.switchToDashBoardView();
    }
}
