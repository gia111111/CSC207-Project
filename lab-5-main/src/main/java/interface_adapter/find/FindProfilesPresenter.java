package interface_adapter.find;

import entity.Finds;
import interface_adapter.ViewManagerModel;
import use_case.find.FindProfilesOutputBoundary;

public class FindProfilesPresenter implements FindProfilesOutputBoundary {

    private final FindViewModel findViewModel;
    private final ViewManagerModel viewManagerModel;

    public FindProfilesPresenter(FindViewModel findViewModel, ViewManagerModel viewManagerModel) {
        this.findViewModel = findViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void presentFinds(Finds finds) {
//        // Format and display the results (e.g., send to the UI)
//        finds.getScores().forEach((username, score) -> {
//            System.out.println("Username: " + username + ", Compatibility Score: " + score);
//        });
        FindState state = new FindState();
        state.setScores(finds.getScores());
        findViewModel.setState(state);
    }


    @Override
    public void presentError(String errorMessage) {
        // Handle and display the error
        System.err.println(errorMessage);
    }
}
