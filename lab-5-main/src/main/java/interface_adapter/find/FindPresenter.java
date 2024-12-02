package interface_adapter.find;

import entity.Finds;
import interface_adapter.ViewManagerModel;
import use_case.find.FindOutputBoundary;

public class FindPresenter implements FindOutputBoundary {

    private final FindViewModel findViewModel;
    private final ViewManagerModel viewManagerModel;

    public FindPresenter(FindViewModel findViewModel, ViewManagerModel viewManagerModel) {
        this.findViewModel = findViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void presentFinds(Finds finds) {
        final FindState state = findViewModel.getState();
        state.setScores(finds.getScores());
        findViewModel.setState(state);
        viewManagerModel.setState("find");
    }


    @Override
    public void presentError(String errorMessage) {
        // Handle and display the error
        System.err.println(errorMessage);
    }
}
