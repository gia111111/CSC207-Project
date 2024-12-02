package use_case.matches;

import entity.Matches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchesInteractor implements MatchesInputBoundary {
    private final MatchesDataAccessObject matchesDataAccessObject;
    private final MatchesOutputBoundary matchesOutputBoundary;

    public MatchesInteractor(MatchesDataAccessObject matchesDataAccessObject, MatchesOutputBoundary matchesOutputBoundary) {
        this.matchesDataAccessObject = matchesDataAccessObject;
        this.matchesOutputBoundary = matchesOutputBoundary;
    }

    @Override
    public Map<String, List<String>> execute(MatchesInputData matchesInputData) {
        List<String> otherUsers = matchesDataAccessObject.getRequests(matchesInputData.getName());
        HashMap<String, List<String>> matchContactInfo = new HashMap<>();
        for (String otherUser : otherUsers) {
            List<String> otherUserContactInfo = matchesDataAccessObject.getContactCard(otherUser);
            System.out.println(otherUserContactInfo);
            matchContactInfo.put(otherUser, otherUserContactInfo);
        }
        final Matches matches = new Matches(matchesInputData.getName(), matchContactInfo);
        if (matches.getMatches()!= null) {
            matchesDataAccessObject.save(matches);
            final MatchesOutputData matchesOutputData = new MatchesOutputData(matches.getCurrentUsername(), false);
            matchesOutputBoundary.prepareSuccessView(matchesOutputData);
            System.out.println("interactor" + matches.getMatches());
            return matches.getMatches();
        }
        else {
            matchesOutputBoundary.prepareFailView("Sorry, no current matches. Please access the Finds page from Dashboard to start matching!");
            return null;
        }
    }

    @Override
    public void switchToDashBoardView() {
    }
}
