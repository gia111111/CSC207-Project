package use_case.editprofile;

/**
 * The Output Data for the Edit Profile Use Case.
 */
public class EditProfileOutputData {

    private final String name;
    private boolean useCaseFailed;

    public EditProfileOutputData(String name, boolean useCaseFailed) {
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
