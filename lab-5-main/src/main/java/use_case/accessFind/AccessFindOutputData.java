package use_case.accessFind;

public class AccessFindOutputData {
    private final String name;
    private final boolean useCaseFail;


    public AccessFindOutputData(String name, boolean useCaseFail) {
        this.name = name;
        this.useCaseFail = useCaseFail;
    }

    public String getName() {return name;}

    public boolean isUseCaseFailed() {return useCaseFail;}
}
