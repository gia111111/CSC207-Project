package use_case.matches;

public class MatchesOutputData {
    private final String name;
    private final boolean useCaseFailed;

    public MatchesOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {return name;}

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
