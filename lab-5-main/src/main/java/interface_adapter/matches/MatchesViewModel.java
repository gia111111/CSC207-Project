package interface_adapter.matches;

import interface_adapter.ViewModel;
import interface_adapter.requests.RequestsState;

public class MatchesViewModel extends ViewModel<MatchesState> { ;
    public static final String BACK_BUTTON_LABEL = "Back";
//    public static final String USERNAME_LABEL = "user"


    public MatchesViewModel() {
        super("matches");
        setState(new MatchesState());
    }
}
