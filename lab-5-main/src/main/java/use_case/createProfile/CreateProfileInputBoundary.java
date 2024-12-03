package use_case.createProfile;

/**
 * The input boundary for actions which are related with Creating Profile.
 */
public interface CreateProfileInputBoundary {
    /**
     * Executes the Create Profile use case.
     * @param createProfileInputData the input data
     */
    void execute(CreateProfileInputData createProfileInputData);

}
