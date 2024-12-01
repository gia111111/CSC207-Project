package app;

import javax.swing.*;
import javax.swing.JFrame;
import java.io.IOException;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            // Set Material Look-and-Feel
            UIManager.setLookAndFeel(new mdlaf.MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException evt) {
            evt.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            try {
                // Use AppBuilder to construct the application
                AppBuilder appBuilder = new AppBuilder();
                JFrame application = appBuilder
                        .addHomePageView()
                        .addLoginView()
                        .addSignupView()
                        .addLoggedInView()
                        .addProfileView()
                        .addDashboardView()
                        .addSignupUseCase()
                        .addLoginUseCase()
                        .addChangePasswordUseCase()
                        .addProfileUseCase()
                        .addHomePageUseCase()
                        .addLogoutUseCase()
                        .addFindView()
                        .addFindUseCase()
                        .addRequestsView()
                        .addRequestsUseCase()
                        .addMatchView()
                        .build();

                // Launch the application
                application.pack();
                application.setVisible(true);
            } catch (IOException evt) {
                evt.printStackTrace();
            } catch (Exception evt) {
                throw new RuntimeException(evt);
            }
        });
    }
}
