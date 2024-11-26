package interface_adapter.find;

import entity.Finds;
import use_case.Find.FindProfilesInputBoundary;
import use_case.Find.FindProfilesOutputBoundary;

public class FindProfilesController {
    private final FindProfilesInputBoundary findProfilesUseCase;
    private final FindProfilesOutputBoundary presenter;

    public FindProfilesController(FindProfilesInputBoundary findProfilesUseCase, FindProfilesOutputBoundary presenter) {
        this.findProfilesUseCase = findProfilesUseCase;
        this.presenter = presenter;
    }

    public void findProfiles(String currentUsername) {
        Finds finds = findProfilesUseCase.execute(currentUsername);
        presenter.presentFinds(finds);
    }
}
