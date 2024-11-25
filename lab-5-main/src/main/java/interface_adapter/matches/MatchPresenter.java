package interface_adapter.matches;

import use_case.matches.MatchOutputBoundary;
import use_case.matches.MatchOutputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchPresenter implements MatchOutputBoundary {
    @Override
    public void presentMatchOutput(MatchOutputData outputData) {
        if (outputData.isSuccess()) {
            presentOutput(outputData);
        } else {
            System.out.println("Failed to process matches: " + outputData.getMessage());
        }
    }

    private static void presentOutput(MatchOutputData outputData) {
        // Display success message
        System.out.println("Operation Successful for User: " + outputData.getUsername());

        // Print all matches if present
        HashMap<String, List<String>> matches = outputData.getMatches();
        if (matches != null && !matches.isEmpty()) {
            System.out.println("Matches:");
            matches.forEach((matchName, contactInfo) -> {
                System.out.println("  Match Name: " + matchName);
                System.out.println("  Contact Method: " + contactInfo.get(0));
                System.out.println("  Contact Info: " + contactInfo.get(1));
            });
        } else {
            System.out.println("No matches found.");
        }
    }
}
