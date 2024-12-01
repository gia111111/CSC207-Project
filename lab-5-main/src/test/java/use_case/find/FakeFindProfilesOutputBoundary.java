package use_case.find;

import entity.Finds;

public class FakeFindProfilesOutputBoundary implements FindProfilesOutputBoundary{
    public Finds finds;
    public String errorMessage;

    @Override
    public void presentFinds(Finds finds) {
        this.finds = finds;
    }

    @Override
    public void presentError(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
