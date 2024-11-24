package app;

import data_access.RemoteDataAccessObject;

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
        final AppBuilder appBuilder = new AppBuilder();
        // TODO: add the Logout Use Case to the app using the appBuilder
        final JFrame application = appBuilder
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
                .addProfileUseCase()
                                            .build();


        application.pack();
        application.setVisible(true);
    }
}
