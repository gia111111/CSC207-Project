package use_case.matches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Matches;

/**
 * Interactor responsible for finding matches of the current user.
 * Implements the {@Link MatchesInputBoundary} interface to define use case behaviour.
 */
public class MatchesInteractor implements MatchesInputBoundary {
    private final MatchesDataAccessObject matchesDataAccessObject;
    private final MatchesOutputBoundary matchesOutputBoundary;

    /**
     * Constructs a new MatchesInteractor instance.
     *
     * @param matchesDataAccessObject the data access object for interacting with the database
     * @param matchesOutputBoundary the output boundary for presenting results or errors
     */
    public MatchesInteractor(MatchesDataAccessObject matchesDataAccessObject,
                             MatchesOutputBoundary matchesOutputBoundary) {
        this.matchesDataAccessObject = matchesDataAccessObject;
        this.matchesOutputBoundary = matchesOutputBoundary;
    }

    /**
     * Executes the matches use case.
     * Fetches the current users matches and retrieves their contact information.
     *
     * @param matchesInputData input data containing match details.
     * @return a map of the current users matches' usernames and a list of their contact information,
     *      or null if an error occurs.
     */
    @Override
    public Map<String, List<String>> execute(MatchesInputData matchesInputData) {
        final List<String> otherUsers = matchesDataAccessObject.getRequests(matchesInputData.getName());
        System.out.println("interactorblah" + otherUsers);
        final HashMap<String, List<String>> matchContactInfo = new HashMap<>();
        for (String otherUser : otherUsers) {
            final List<String> otherUserContactInfo = matchesDataAccessObject.getContactCard(otherUser);
            matchContactInfo.put(otherUser, otherUserContactInfo);
        }
        final Matches matches = new Matches(matchesInputData.getName(), matchContactInfo);
        System.out.println(matches.getMatches() + "aaaahhhhh");
        if (matches.getMatches().size() != 0) {
            System.out.println("Interactor" + matches.getMatches());
            matchesDataAccessObject.save(matches);
            final MatchesOutputData matchesOutputData = new MatchesOutputData(matches.getCurrentUsername(), false);
            matchesOutputBoundary.prepareSuccessView(matchesOutputData);
            return matches.getMatches();
        }
        else {
            matchesOutputBoundary.prepareFailView(
                    "Sorry, no current matches. Please access the Finds page from Dashboard to start matching!");
            return matches.getMatches();
        }
    }
}
