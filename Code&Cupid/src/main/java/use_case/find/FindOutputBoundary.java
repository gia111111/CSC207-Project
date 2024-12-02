package use_case.find;

import entity.Finds;

public interface FindOutputBoundary {
    void presentFinds(Finds finds);
    void presentError(String error);
}
