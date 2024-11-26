package use_case.Find;

import entity.Finds;

public interface FindProfilesInputBoundary {
    Finds execute(String currentUsername);
}
