package use_case.createProfile;

import data_access.InMemoryDataAccessObject;
import data_access.RemoteDataAccessObject;
import entity.CommonProfileFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CreateProfileInteractorTest {

    private RemoteDataAccessObject mockDataAccessObject;

    @BeforeEach
    void setUp() {
        mockDataAccessObject = mock(RemoteDataAccessObject.class);
        when(mockDataAccessObject.getCurrentUsername()).thenReturn("Paul");
    }

    @Test
    void excuteSuccessTest() {
        CreateProfileInputData inputData = new CreateProfileInputData("Male", "Female", 21,
                Map.of("section 1", List.of("A", "A", "A", "A", "A"),
                        "section 2", List.of("B", "B", "B", "B", "B"),
                        "section 3", List.of("C", "C", "C", "C", "C"),
                        "section 4", List.of("D", "D", "D", "D", "D"),
                        "section 5", List.of("A", "B", "C", "D", "A")),
                Map.of("section1", 20, "section2", 20, "section3", 20, "section4", 20, "section5", 20),
                "Email", "contact@example.com", mockDataAccessObject);

        CreateProfileDataAccessInterface profileRepository = new InMemoryDataAccessObject();

        CreateProfileOutputBoundary successPresenter = new CreateProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateProfileOutputData profile) {
                assertEquals("Paul", profile.getName());
                assertTrue(profileRepository.existsByUsername("Paul"));
                assertEquals("Male", profileRepository.getGender());
                assertEquals("Female", profileRepository.getSexualOrientation());
                assertEquals(21, profileRepository.getAgeValue());
                assertEquals(Map.of(
                        "section 1", List.of("A", "A", "A", "A", "A"),
                        "section 2", List.of("B", "B", "B", "B", "B"),
                        "section 3", List.of("C", "C", "C", "C", "C"),
                        "section 4", List.of("D", "D", "D", "D", "D"),
                        "section 5", List.of("A", "B", "C", "D", "A")), profileRepository.getSectionAnswers());
                assertEquals(Map.of(
                        "section1", 20, "section2", 20,
                        "section3", 20, "section4", 20,
                        "section5", 20), profileRepository.getSectionWeights());
                assertEquals("contact@example.com", profileRepository.getContactInfo());
                assertEquals("Email", profileRepository.getContactMethod());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToDashBoardView() {
                // This is expected
            }
        };

        CreateProfileInteractor interactor = new CreateProfileInteractor(profileRepository, successPresenter, new CommonProfileFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureSectionWeightsTest() {
        CreateProfileInputData inputData = new CreateProfileInputData("Male", "Female", 21,
                Map.of("section 1", List.of("A", "A", "A", "A", "A"),
                        "section 2", List.of("B", "B", "B", "B", "B"),
                        "section 3", List.of("C", "C", "C", "C", "C"),
                        "section 4", List.of("D", "D", "D", "D", "D"),
                        "section 5", List.of("A", "B", "C", "D", "A")),
                Map.of("section1", 10, "section2", 20, "section3", 20, "section4", 20, "section5", 20),
                "Email", "contact@example.com", mockDataAccessObject);

        CreateProfileDataAccessInterface profileRepository = new InMemoryDataAccessObject();

        CreateProfileOutputBoundary successPresenter = new CreateProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateProfileOutputData profile) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Weights do not add up to 100!", error);
            }

            @Override
            public void switchToDashBoardView() {
                // This is expected
            }
        };

        CreateProfileInteractor interactor = new CreateProfileInteractor(profileRepository, successPresenter, new CommonProfileFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureIncompleteProfileTest() {
        CreateProfileInputData inputData = new CreateProfileInputData("Male", "Female", 21,
                Map.of("section 1", List.of("A", "A", "A", "A", "A"),
                        "section 2", List.of("B", "B", "B", "B", "B"),
                        "section 3", List.of("C", "C", "C", "C", "C"),
                        "section 4", List.of("D", "D", "D", "D", "D"),
                        "section 5", List.of("A", "B", "C", "D", "A")),
                Map.of("section1", 20, "section2", 20, "section3", 20, "section4", 20, "section5", 20),
                "Email", "", mockDataAccessObject);

        CreateProfileDataAccessInterface profileRepository = new InMemoryDataAccessObject();

        CreateProfileOutputBoundary successPresenter = new CreateProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateProfileOutputData profile) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Please answer every question!", error);
            }

            @Override
            public void switchToDashBoardView() {
                // This is expected
            }
        };

        CreateProfileInteractor interactor = new CreateProfileInteractor(profileRepository, successPresenter, new CommonProfileFactory());
        interactor.execute(inputData);
    }
}
