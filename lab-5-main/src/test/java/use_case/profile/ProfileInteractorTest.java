package use_case.profile;

import data_access.RemoteDataAccessObject;
import entity.CommonProfile;
import entity.Profile;
import entity.ProfileFactory;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import use_case.createProfile.*;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CreateProfileInteractorTest {
    private FakeProfileDataAccessObject fakeProfileDataAccessObject;
    private FakeProfilePresenter fakeProfilePresenter;
    private FakeProfileFactory fakeProfileFactory;
    private CreateProfileInteractor interactor;

    @BeforeEach
    void setUp() {
        fakeProfileDataAccessObject = new FakeProfileDataAccessObject();
        fakeProfilePresenter = new FakeProfilePresenter();
        fakeProfileFactory = new FakeProfileFactory();

        interactor = new CreateProfileInteractor(fakeProfileDataAccessObject, fakeProfilePresenter, fakeProfileFactory);
    }

//    @Test
//    void testExecuteSuccess() {
//        // Arrange
//        CreateProfileInputData inputData = new CreateProfileInputData(
//                "Male",
//                "Female",
//                25,
//                Map.of(
//                        "section 1", List.of("A", "B", "C", "D", "E"),
//                        "section 2", List.of("F", "G", "H", "I", "J"),
//                        "section 3", List.of("K", "L", "M", "N", "O"),
//                        "section 4", List.of("P", "Q", "R", "S", "T"),
//                        "section 5", List.of("U", "V", "W", "X", "Y")
//                ),
//                Map.of(
//                        "section1", 20,
//                        "section2", 20,
//                        "section3", 20,
//                        "section4", 20,
//                        "section5", 20
//                ),
//                "email",
//                "contact@example.com",
//                null
//        );
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        Profile savedProfile = fakeProfileDataAccessObject.getSavedProfile();
//        assertNotNull(savedProfile);
//        assertEquals("Male", savedProfile.getGender());
//        assertEquals("Female", savedProfile.getSexualOrientation());
//        assertEquals(25, savedProfile.getAge());
//
//        assertEquals("Success: john_doe", fakeProfilePresenter.getSuccessMessage());
//        assertNull(fakeProfilePresenter.getErrorMessage());
//    }

//    @Test
//    void testExecuteFailValidation() {
//        // Arrange
//        CreateProfileInputData inputData = new CreateProfileInputData(
//                "Male",
//                "Female",
//                25,
//                Map.of(
//                        "section 1", List.of("A", "B", "C", "D", "E"),
//                        "section 2", List.of("F", "G", "H", "I", "J"),
//                        "section 3", List.of("K", "L", "M", "N", "O"),
//                        "section 4", List.of("P", "Q", "R", "S", "T"),
//                        "section 5", List.of("U", "V", "W", "X") // Invalid: Less than 5 answers
//                ),
//                Map.of(
//                        "section1", 20,
//                        "section2", 20,
//                        "section3", 20,
//                        "section4", 20,
//                        "section5", 15 // Invalid: Weights don't sum to 100
//                ),
//                "email",
//                "",
//                null
//        );
//
//        // Act
//        interactor.execute(inputData);
//
//        // Assert
//        assertNull(fakeProfileDataAccessObject.getSavedProfile());
//        assertEquals("Please answer every question!", fakeProfilePresenter.getErrorMessage());
//        assertNull(fakeProfilePresenter.getSuccessMessage());
//    }

    @Test
    void testSwitchToDashboardView() {
        // Act
        interactor.switchToDashBroadView();

        // Assert
        // We assume this action does nothing for now
    }
}



