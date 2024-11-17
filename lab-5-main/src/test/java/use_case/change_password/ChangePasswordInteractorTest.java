package use_case.change_password;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import use_case.signup.*;

import static org.junit.jupiter.api.Assertions.*;
public class ChangePasswordInteractorTest {
    @Test
    void successTest() {
        ChangePasswordInputData inputData = new ChangePasswordInputData("Paul", "password",
                "password","security");
        ChangePasswordUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // For the success test, we need to add Paul to the data access repository before we log in.
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("Paul", "password");
        userRepository.save(user);

        // This creates a successPresenter that tests whether the test case is as we expect.
        ChangePasswordOutputBoundary successPresenter = new ChangePasswordOutputBoundary() {
            @Override
            public void prepareSuccessView(ChangePasswordOutputData user) {
                // 2 things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("Paul", user.getUsername());
                assertFalse(user.isUseCaseFailed());
                assertTrue(userRepository.existsByName("Paul"));
            }

            // @Override
            // public void prepareSuccessView(ChangePasswordOutputData outputData) {

            // }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToHomePageView() {

            }

            // @Override
            // public void switchToLoginView() {
                // This is expected
            //}
        };

        ChangePasswordInputBoundary interactor = new ChangePasswordInteractor(userRepository, successPresenter,
                new CommonUserFactory());
        interactor.execute(inputData);
    }

    @Test
    void failurePasswordMismatchTest() {
        ChangePasswordInputData inputData = new ChangePasswordInputData("Paul", "password",
                "wrong","security");
        ChangePasswordUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // For this failure test, we need to add Paul to the data access repository before we change password, and
        // the passwords should not match.
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("Paul", "password");
        userRepository.save(user);

        // This creates a presenter that tests whether the test case is as we expect.
        ChangePasswordOutputBoundary failurePresenter = new ChangePasswordOutputBoundary() {
            @Override
            public void prepareSuccessView(ChangePasswordOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Passwords don't match.", error);
            }

            @Override
            public void switchToHomePageView() {
                // This is expected
            }
        };

        ChangePasswordInputBoundary interactor = new ChangePasswordInteractor(userRepository, failurePresenter, new CommonUserFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureUserExistsTest() {
        ChangePasswordInputData inputData = new ChangePasswordInputData("Paul", "password",
                "wrong","security");
        ChangePasswordUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
//        UserFactory factory = new CommonUserFactory();
//        User user = factory.create("Paul", "pwd");
//        userRepository.save(user);

        // This creates a presenter that tests whether the test case is as we expect.
        ChangePasswordOutputBoundary failurePresenter = new ChangePasswordOutputBoundary() {
            @Override
            public void prepareSuccessView(ChangePasswordOutputData user) {
                // this should never be reached since the test case should fail
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Paul: Account doesn't exist.", error);
            }

            @Override
            public void switchToHomePageView() {
                // This is expected
            }
        };

        ChangePasswordInputBoundary interactor = new ChangePasswordInteractor(userRepository, failurePresenter, new CommonUserFactory());
        interactor.execute(inputData);
    }
}


