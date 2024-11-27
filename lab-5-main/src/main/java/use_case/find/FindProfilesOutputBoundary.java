package use_case.find;

import entity.Finds;

public interface FindProfilesOutputBoundary {
    void presentFinds(Finds finds);
    void presentError(String error);
}
