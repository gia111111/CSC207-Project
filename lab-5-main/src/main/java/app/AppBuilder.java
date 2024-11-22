package app;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.*;

import data_access.InMemoryUserDataAccessObject;
import data_access.RemoteDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.ChangePasswordPresenter;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.dashboard.DashBoardController;
import interface_adapter.dashboard.DashBoardViewModel;
import interface_adapter.home.HomePageController;
import interface_adapter.home.HomePagePresenter;
import interface_adapter.home.HomePageViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.profile.ProfileController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.profile.ProfileViewModel;
import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInteractor;
import use_case.change_password.ChangePasswordOutputBoundary;
import use_case.home.HomeInputBoundary;
import use_case.home.HomeInteractor;
import use_case.home.HomeOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term.
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final UserFactory userFactory = new CommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final HomePageViewModel homePageViewModel = new HomePageViewModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    // private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();
    private final RemoteDataAccessObject remoteDataAccessObject = new RemoteDataAccessObject();

    private HomePageView homePageView;
    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private ProfileViewModel profileViewModel;
    private ProfileView profileView;
    private DashBoardViewModel dashBoardViewModel;
    private DashBoardView dashBoardView;


    private final HomeOutputBoundary homeOutputBoundary = new HomePagePresenter(homePageViewModel, signupViewModel, loginViewModel, loggedInViewModel, viewManagerModel);
    private final HomeInteractor homeInteractor = new HomeInteractor(homeOutputBoundary);
    private final HomePageController homePageController = new HomePageController(viewManagerModel);
    private final ProfileController profileController = new ProfileController(viewManagerModel);
    private DashBoardController dashBoardController = new DashBoardController(viewManagerModel);

    public AppBuilder() throws IOException {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    public AppBuilder addProfileView() {
        profileViewModel = new ProfileViewModel();
        profileView = new ProfileView(profileViewModel);
        cardPanel.add(profileView, profileView.getViewName());
        return this;
    }

    public AppBuilder addDashboardView() {
        dashBoardViewModel = new DashBoardViewModel();
        dashBoardView = new DashBoardView(dashBoardViewModel, dashBoardController);

        cardPanel.add(dashBoardView, dashBoardView.getViewName());
        return this;
    }


    /**
     * Adds the Signup Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, profileViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                remoteDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor, viewManagerModel);
        signupView.setSignupController(controller);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel, dashBoardViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                remoteDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor, viewManagerModel);
        loginView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addChangePasswordUseCase() {
        final ChangePasswordOutputBoundary changePasswordOutputBoundary =
                new ChangePasswordPresenter(loggedInViewModel, viewManagerModel);

        final ChangePasswordInputBoundary changePasswordInteractor =
                new ChangePasswordInteractor(remoteDataAccessObject, changePasswordOutputBoundary, userFactory);

        final ChangePasswordController changePasswordController =
                new ChangePasswordController(changePasswordInteractor, viewManagerModel);
        loggedInView.setChangePasswordController(changePasswordController);
        return this;
    }

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(remoteDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        loggedInView.setLogoutController(logoutController);
        return this;
    }

    /**
     * Adds the HomePageView to the application.
     */
    public AppBuilder addHomePageView() {
        homePageView = new HomePageView(homePageViewModel, homePageController);
        cardPanel.add(homePageView, homePageView.getViewName());
        return this;
    }

    public AppBuilder addHomePageUseCase() {
        final HomeOutputBoundary homeOutputBoundary = new HomePagePresenter(homePageViewModel,
                signupViewModel, loginViewModel, loggedInViewModel, viewManagerModel);
        final HomeInputBoundary userHomeInteractor = new HomeInteractor(homeOutputBoundary);

        final HomePageController controller = new HomePageController(viewManagerModel);
        homePageView.setHomePageController(controller);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the HomePageView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Code & Cupid");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        application.add(cardPanel);
        JScrollPane scroll = new JScrollPane(cardPanel);
        application.add(scroll);

        viewManagerModel.setState(homePageView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
