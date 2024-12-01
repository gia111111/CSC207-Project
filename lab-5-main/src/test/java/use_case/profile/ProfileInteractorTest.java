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

class CreateProfileInteractorTest {

    private CreateProfileDataAccessInterface mockProfileDataAccessObject;
    private CreateProfileOutputBoundary mockProfilePresenter;
    private ProfileFactory mockProfileFactory;
    private RemoteDataAccessObject mockRemoteDataAccessObject;
    private CreateProfileInteractor interactor;

    @BeforeEach
    void setUp() {
        mockProfileDataAccessObject = mock(CreateProfileDataAccessInterface.class);
        mockProfilePresenter = mock(CreateProfileOutputBoundary.class);
        mockProfileFactory = mock(ProfileFactory.class);
        mockRemoteDataAccessObject = mock(RemoteDataAccessObject.class);

        interactor = new CreateProfileInteractor(mockProfileDataAccessObject, mockProfilePresenter, mockProfileFactory);
    }

    @Test
    void testExecuteSuccess() {
        // Arrange
        when(mockRemoteDataAccessObject.getCurrentUsername()).thenReturn("john_doe");

        CreateProfileInputData inputData = new CreateProfileInputData(
                "Male",
                "Female",
                25,
                Map.of(
                        "section 1", List.of("A", "B", "C", "D", "E"),
                        "section 2", List.of("F", "G", "H", "I", "J"),
                        "section 3", List.of("K", "L", "M", "N", "O"),
                        "section 4", List.of("P", "Q", "R", "S", "T"),
                        "section 5", List.of("U", "V", "W", "X", "Y")
                ),
                Map.of(
                        "section1", 20,
                        "section2", 20,
                        "section3", 20,
                        "section4", 20,
                        "section5", 20
                ),
                "email",
                "contact@example.com",
                mockRemoteDataAccessObject
        );

        Profile mockProfile = mock(Profile.class);

// Mock the behavior of necessary methods
        when(mockProfile.getName()).thenReturn(inputData.getName());
        when(mockProfile.getGender()).thenReturn(inputData.getGender());
        when(mockProfile.getSexualOrientation()).thenReturn(inputData.getSexualOrientation());
        when(mockProfile.getAge()).thenReturn(inputData.getAge());
        //when(mockProfile.getAnswers()).thenReturn(inputData.getAnswers());
        when(mockProfile.getWeights()).thenReturn(inputData.getWeights());
        when(mockProfile.getContactInfo()).thenReturn(inputData.getContactInfo());
        when(mockProfile.getContactMethod()).thenReturn(inputData.getContactMethod());

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockProfileDataAccessObject).save(mockProfile);

        ArgumentCaptor<CreateProfileOutputData> captor = ArgumentCaptor.forClass(CreateProfileOutputData.class);
        verify(mockProfilePresenter).prepareSuccessView(captor.capture());
        assertEquals("john_doe", captor.getValue().getName());
    }

    @Test
    void testExecuteFailValidation() {
        // Arrange
        when(mockRemoteDataAccessObject.getCurrentUsername()).thenReturn("john_doe");

        CreateProfileInputData inputData = new CreateProfileInputData(
                "Male",
                "Female",
                25,
                Map.of(
                        "section 1", List.of("A", "B", "C", "D", "E"),
                        "section 2", List.of("F", "G", "H", "I", "J"),
                        "section 3", List.of("K", "L", "M", "N", "O"),
                        "section 4", List.of("P", "Q", "R", "S", "T"),
                        "section 5", List.of("U", "V", "W", "X") // Invalid: Less than 5 answers
                ),
                Map.of(
                        "section1", 20,
                        "section2", 20,
                        "section3", 20,
                        "section4", 20,
                        "section5", 15 // Invalid: Weights don't sum to 100
                ),
                "email",
                "",
                mockRemoteDataAccessObject
        );

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockProfilePresenter).prepareFailView("Please answer every question!");
        verify(mockProfileDataAccessObject, never()).save(any(Profile.class));
    }

    @Test
    void testSwitchToDashboardView() {
        // Act
        interactor.switchToDashBroadView();

        // Assert
        verify(mockProfilePresenter).switchToDashBoardView();
    }
}


