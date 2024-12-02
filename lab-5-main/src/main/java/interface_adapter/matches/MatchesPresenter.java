package interface_adapter.matches;

import interface_adapter.ViewManagerModel;
import use_case.matches.MatchesInputData;
import use_case.matches.MatchesOutputBoundary;
import use_case.matches.MatchesOutputData;

public class MatchesPresenter implements MatchesOutputBoundary {
    private final MatchesViewModel matchesViewModel;
    private final ViewManagerModel viewManagerModel;

    public MatchesPresenter(MatchesViewModel matchesViewModel, ViewManagerModel viewManagerModel) {
        this.matchesViewModel = matchesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(MatchesOutputData matchesOutputData) {
        final MatchesState currentState = matchesViewModel.getState();
        currentState.setName(matchesOutputData.getName());
        matchesViewModel.setState(currentState);

        viewManagerModel.setState("matches");
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final MatchesState currentState = matchesViewModel.getState();
        currentState.setErrorMessage(errorMessage);
        matchesViewModel.firePropertyChanged();
    }

    @Override
    public void switchToDashBoardView() {
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();

    }
}
