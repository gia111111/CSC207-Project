package view;

import interface_adapter.find.FindProfilesController;

public class FindsView {
    private final FindProfilesController controller;

    public FindsView(FindProfilesController controller) {
        this.controller = controller;
    }

    public void displayFindResults(String currentUsername) {
        controller.findProfiles(currentUsername);
    }
}
