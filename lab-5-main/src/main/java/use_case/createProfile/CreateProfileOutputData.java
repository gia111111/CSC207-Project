package use_case.createProfile;

/**
 * The output boundary for the createProfile Use Case.
 */
public class CreateProfileOutputData {

    private final String name;

    private final boolean useCaseFailed;

    public CreateProfileOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return name;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
