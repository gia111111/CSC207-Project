package interface_adapter.matches;

import data_access.RemoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.matches.MatchesInputBoundary;
import use_case.matches.MatchesInputData;

import java.util.List;
import java.util.Map;

public class MatchesController {
    private final MatchesInputBoundary matchesInputBoundary;
    private final ViewManagerModel viewManagerModel;
    private final RemoteDataAccessObject remoteDataAccessObject;

    public MatchesController(MatchesInputBoundary matchesInputBoundary, ViewManagerModel viewManagerModel, RemoteDataAccessObject remoteDataAccessObject) {
        this.matchesInputBoundary = matchesInputBoundary;
        this.viewManagerModel = viewManagerModel;
        this.remoteDataAccessObject = remoteDataAccessObject;
    }

    public Map<String, List<String>> execute(Map<String, List<String>> contactInfo) {
        final MatchesInputData matchesInputData = new MatchesInputData(contactInfo, remoteDataAccessObject);
        Map<String, List<String>> matchesInfo = matchesInputBoundary.execute(matchesInputData);
        return matchesInfo;
    }

    public void switchToDashBoardView() {
        viewManagerModel.setState("dashboard");
        viewManagerModel.firePropertyChanged();
    }
}
