package interface_adapter.matches;

import interface_adapter.ViewModel;

public class MatchesViewModel extends ViewModel<MatchesState> {
    public static final String TITLE_LABEL = "Matches";
    public static final String LOAD_MATCHES = "Press to load all matches";
    public static final String BACK_DASHBOARD = "Back to Dashboard";

    public MatchesViewModel() {
        super("matches");
        setState(new MatchesState());
    }
}
