package interface_adapter.find;

import entity.Finds;
import use_case.find.FindProfilesOutputBoundary;

public class FindProfilesPresenter implements FindProfilesOutputBoundary {
    @Override
    public void presentFinds(Finds finds) {
        // Format and display the results (e.g., send to the UI)
        finds.getScores().forEach((username, score) -> {
            System.out.println("Username: " + username + ", Compatibility Score: " + score);
        });
    }


    @Override
    public void presentError(String errorMessage) {
        // Handle and display the error
        System.err.println(errorMessage);
    }
}
