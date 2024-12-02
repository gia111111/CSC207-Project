package app;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.*;

import data_access.RemoteDataAccessObject;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.ChangePasswordPresenter;
import interface_adapter.change_password.ChangePasswordViewModel;
import interface_adapter.dashboard.DashBoardController;
import interface_adapter.dashboard.DashBoardViewModel;
import interface_adapter.find.FindController;
import interface_adapter.find.FindPresenter;
import interface_adapter.find.FindViewModel;
import interface_adapter.home.HomePageController;
import interface_adapter.home.HomePagePresenter;
import interface_adapter.home.HomePageViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.matches.MatchesController;
import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfilePresenter;
import interface_adapter.requests.RequestsController;
import interface_adapter.requests.RequestsPresenter;
import interface_adapter.requests.RequestsViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.matches.MatchesViewModel;
import interface_adapter.matches.MatchesPresenter;
import use_case.changePassword.ChangePasswordInputBoundary;
import use_case.changePassword.ChangePasswordInteractor;
import use_case.changePassword.ChangePasswordOutputBoundary;
import use_case.createProfile.CreateProfileInputBoundary;
import use_case.createProfile.CreateProfileInteractor;
import use_case.createProfile.CreateProfileOutputBoundary;
import use_case.find.*;
import use_case.home.HomeInteractor;
import use_case.home.HomeOutputBoundary;
import use_case.matches.MatchesInputBoundary;
import use_case.matches.MatchesInteractor;
import use_case.matches.MatchesOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.requests.*;
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

public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final UserFactory userFactory = new CommonUserFactory();
    private final ProfileFactory profileFactory = new CommonProfileFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final HomePageViewModel homePageViewModel = new HomePageViewModel();
    private final MatchesViewModel matchesViewModel = new MatchesViewModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final RemoteDataAccessObject remoteDataAccessObject = new RemoteDataAccessObject();

    private HomePageView homePageView;
    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private ChangePasswordViewModel changePasswordViewModel;
    private ChangePasswordView changePasswordView;
    private LoginView loginView;
    private ProfileViewModel profileViewModel;
    private ProfileView profileView;
    private DashBoardViewModel dashBoardViewModel;
    private DashBoardView dashBoardView;
    private MatchesView matchesView;
    private RequestsView requestsView;
    private RequestsViewModel requestsViewModel;
    private FindViewModel findViewModel;
    private FindView findView;

    private final HomeOutputBoundary homeOutputBoundary = new HomePagePresenter(homePageViewModel, signupViewModel, loginViewModel, changePasswordViewModel, viewManagerModel);
    private final HomeInteractor homeInteractor = new HomeInteractor(homeOutputBoundary);
    private final HomePageController homePageController = new HomePageController(viewManagerModel);
    private DashBoardController dashBoardController = new DashBoardController(viewManagerModel);
    private RequestsInputBoundary requestsInputBoundary;

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
        changePasswordViewModel = new ChangePasswordViewModel();
        changePasswordView = new ChangePasswordView(changePasswordViewModel);
        cardPanel.add(changePasswordView, changePasswordView.getViewName());
        return this;
    }

    /**
     * Adds the Profile View to the application.
     * @return this builder
     */
    public AppBuilder addProfileView() {
        profileViewModel = new ProfileViewModel();
        profileView = new ProfileView(profileViewModel);
        cardPanel.add(profileView, profileView.getViewName());
        return this;
    }


    /**
     * Adds the Dashboard View to the application.
     * @return this builder
     */
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

        final SignupController controller = new SignupController(userSignupInteractor, viewManagerModel, remoteDataAccessObject);
        signupView.setSignupController(controller);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                changePasswordViewModel, loginViewModel, dashBoardViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                remoteDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor, viewManagerModel, remoteDataAccessObject);
        loginView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addChangePasswordView() {
        changePasswordViewModel = new ChangePasswordViewModel();
        changePasswordView = new ChangePasswordView(changePasswordViewModel);
        cardPanel.add(changePasswordView, changePasswordView.getViewName());
        return this;
    }

    /**
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addChangePasswordUseCase() {
        final ChangePasswordOutputBoundary changePasswordOutputBoundary =
                new ChangePasswordPresenter(changePasswordViewModel, viewManagerModel,loginViewModel);

        final ChangePasswordInputBoundary changePasswordInteractor =
                new ChangePasswordInteractor(remoteDataAccessObject, changePasswordOutputBoundary, userFactory);

        final ChangePasswordController changePasswordController =
                new ChangePasswordController(changePasswordInteractor, viewManagerModel, remoteDataAccessObject);
        changePasswordView.setChangePasswordController(changePasswordController);
        return this;
    }

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                changePasswordViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(remoteDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        changePasswordView.setLogoutController(logoutController);
        return this;
    }


    public AppBuilder addFindUseCase(){
        // Initialize the compatibility algorithm
        final CompatibilityAlgorithm compatibilityAlgorithm = new BasicCompatibilityAlgorithm();

        // Initialize the output boundary (Presenter)
        final FindOutputBoundary outputBoundary = new FindPresenter(findViewModel, viewManagerModel);

        // Create the FindProfilesInteractor
        final FindInteractor findProfilesInteractor = new FindInteractor(
                compatibilityAlgorithm, // The data access interface
                outputBoundary,
                remoteDataAccessObject
                );

        // Create the controller and assign the interactor
        final FindController findController = new FindController(findProfilesInteractor, viewManagerModel, remoteDataAccessObject);

        // Assign the controller to the FindViewModel or other components if necessary
        findView.setFindProfilesController(findController);

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
        final HomePageController controller = new HomePageController(viewManagerModel);
        homePageView.setHomePageController(controller);
        return this;
    }

    public AppBuilder addMatchesView() {
        matchesView = new MatchesView(matchesViewModel);
        cardPanel.add(matchesView, matchesView.getViewName());
        return this;
    }

    public AppBuilder addMatchesUseCase() {
        final MatchesOutputBoundary matchesOutputBoundary = new MatchesPresenter(matchesViewModel, viewManagerModel);
        final MatchesInputBoundary matchesInteractor = new MatchesInteractor(remoteDataAccessObject, matchesOutputBoundary);
        final MatchesController matchesController = new MatchesController(matchesInteractor, viewManagerModel, remoteDataAccessObject);

        matchesView.setMatchesController(matchesController);
        return this;
    }

    /**
     * Adds the Profile Use Case to the application.
     * @return this builder
     */
    public AppBuilder addProfileUseCase() {
        final CreateProfileOutputBoundary createProfileOutputBoundary =
                new ProfilePresenter(profileViewModel, viewManagerModel);
        final CreateProfileInputBoundary userCreateProfileInteractor =
                new CreateProfileInteractor(remoteDataAccessObject, createProfileOutputBoundary, profileFactory);

        final ProfileController profileController = new ProfileController(userCreateProfileInteractor, viewManagerModel, remoteDataAccessObject);
        profileView.setProfileController(profileController);
        return this;
    }


    /**
     * Adds the Requests Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRequestsUseCase() {
        // Initialize the compatibility algorithm
        final RequestsOutputBoundary requestsOutputBoundary = new RequestsPresenter(viewManagerModel, requestsViewModel);
        final CompatibilityAlgorithm2 compatibilityAlgorithm = new BasicCompatibilityAlgorithm2();
        final RequestsInputBoundary requestsInputBoundary = new RequestsInteractor(requestsOutputBoundary, remoteDataAccessObject,
                compatibilityAlgorithm);

        final RequestsController requestsController = new RequestsController(viewManagerModel,requestsInputBoundary,remoteDataAccessObject);
        requestsView.setRequestsController(requestsController);
        return this;
    }


    /**
     * Adds the Requests View to the application.
     * @return this builder
     */
    public AppBuilder addRequestsView(){
        requestsViewModel = new RequestsViewModel();
        requestsView = new RequestsView(requestsViewModel);
        cardPanel.add(requestsView,requestsView.getViewName());
        return this;
    }



    public AppBuilder addFindView() {

        // Initialize the FindViewModel
        findViewModel = new FindViewModel();
        // Create the FindView and link it to the view model and controller
        findView = new FindView(findViewModel);

        // Add the FindView to the card panel or relevant UI component
        cardPanel.add(findView, findView.getViewName());

        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the HomePageView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Code & Cupid");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JScrollPane scroll = new JScrollPane(cardPanel);
        application.add(scroll);

        viewManagerModel.setState(homePageView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
