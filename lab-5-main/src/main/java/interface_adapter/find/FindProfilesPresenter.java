package interface_adapter.find;

import entity.Finds;
import use_case.Find.FindProfilesOutputBoundary;

public class FindProfilesPresenter implements FindProfilesOutputBoundary {
    @Override
    public void presentFinds(Finds finds) {
        System.out.println("Matches: " + finds.getMatches());
        System.out.println("Scores: " + finds.getScores());
        // Adapt this to pass data to the actual view
    }
}
