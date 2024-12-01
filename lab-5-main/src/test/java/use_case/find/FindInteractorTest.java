package use_case.find;

import data_access.RemoteDataAccessObject;
import entity.Finds;
import entity.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FindProfilesInteractorTest {

//    private CompatibilityAlgorithm mockCompatibilityAlgorithm;
//    private FindProfilesOutputBoundary mockOutputBoundary;
//    private RemoteDataAccessObject mockRemoteDataAccessObject;
//    private FindProfilesInteractor interactor;
//
//    @BeforeEach
//    void setUp() {
//        mockCompatibilityAlgorithm = mock(CompatibilityAlgorithm.class);
//        mockOutputBoundary = mock(FindProfilesOutputBoundary.class);
//        mockRemoteDataAccessObject = mock(RemoteDataAccessObject.class);
//
//        interactor = new FindProfilesInteractor(mockCompatibilityAlgorithm, mockOutputBoundary, mockRemoteDataAccessObject);
//    }
//
//    @Test
//    void testExecuteSuccess() {
//        // Arrange
//        String currentUsername = "john_doe";
//        Profile currentUserProfile = mock(Profile.class);
//        Profile user1Profile = mock(Profile.class);
//        Profile user2Profile = mock(Profile.class);
//
//        // Mock the behavior of remote data access
//        when(mockRemoteDataAccessObject.getCurrentUsername()).thenReturn(currentUsername);
//        when(mockRemoteDataAccessObject.getProfile(currentUsername)).thenReturn(currentUserProfile);
//        //when(mockRemoteDataAccessObject.getNames()).thenReturn(Arrays.asList("john_doe", "user1", "user2"));
//        when(mockRemoteDataAccessObject.getProfile("user1")).thenReturn(user1Profile);
//        when(mockRemoteDataAccessObject.getProfile("user2")).thenReturn(user2Profile);
//
//        // Mock compatibility scores
//        when(mockCompatibilityAlgorithm.calculateScore(currentUserProfile, user1Profile)).thenReturn(0.9);
//        when(mockCompatibilityAlgorithm.calculateScore(currentUserProfile, user2Profile)).thenReturn(0.7);
//
//        // Act
//        Map<String, Double> scores = interactor.execute(new FindProfileInputData(
//                new HashMap<>(), new HashMap<>(), mockRemoteDataAccessObject));
//
//        // Assert
//        assertNotNull(scores);
//        assertEquals(2, scores.size());
//        assertEquals(0.9, scores.get("user1"));
//        assertEquals(0.7, scores.get("user2"));
//
//        // Verify the output boundary is called with correct data
//        ArgumentCaptor<Finds> captor = ArgumentCaptor.forClass(Finds.class);
//        verify(mockOutputBoundary).presentFinds(captor.capture());
//
//        Finds finds = captor.getValue();
//        assertEquals(0.9, finds.getScores().get("user1"));
//        //assertTrue(finds.getMatches().get("user1"));
//        assertEquals(0.7, finds.getScores().get("user2"));
//        //assertFalse(finds.getMatches().get("user2"));
//
//        // Verify the remote data access object saved the finds
//        verify(mockRemoteDataAccessObject).save(any(Finds.class));
//    }
//
//
//    @Test
//    void testExecuteNoProfilesFound() {
//        // Arrange
//        String currentUsername = "john_doe";
//        when(mockRemoteDataAccessObject.getCurrentUsername()).thenReturn(currentUsername);
//        when(mockRemoteDataAccessObject.getProfile(currentUsername)).thenReturn(mock(Profile.class));
//        //when(mockRemoteDataAccessObject.getNames()).thenReturn(Arrays.asList("john_doe"));
//
//        // Act
//        Map<String, Double> scores = interactor.execute(new FindProfileInputData(
//                new HashMap<>(), new HashMap<>(), mockRemoteDataAccessObject));
//
//        // Assert
//        assertNull(scores);
//        verify(mockOutputBoundary).presentError("Error finding profiles: No profiles found in the database.");
//        verify(mockRemoteDataAccessObject, never()).save(any(Finds.class));
//    }
//
//    @Test
//    void testExecuteProfileNotFound() {
//        // Arrange
//        String currentUsername = "john_doe";
//        when(mockRemoteDataAccessObject.getCurrentUsername()).thenReturn(currentUsername);
//        when(mockRemoteDataAccessObject.getProfile(currentUsername)).thenReturn(null);
//
//        // Act
//        Map<String, Double> scores = interactor.execute(new FindProfileInputData(
//                new HashMap<>(), new HashMap<>(), mockRemoteDataAccessObject));
//
//        // Assert
//        assertNull(scores);
//        verify(mockOutputBoundary).presentError("Error finding profiles: Profile not found for username: " + currentUsername);
//        verify(mockRemoteDataAccessObject, never()).save(any(Finds.class));
//    }
//
//    @Test
//    void testSetRequestStatus() {
//        // Arrange
//        String otherUserId = "user1";
//        Boolean isAccepted = true;
//
//        // Act
//        interactor.setRequestStatus(otherUserId, isAccepted);
//
//        // Assert
//        verify(mockRemoteDataAccessObject).setRequestStatus(otherUserId, isAccepted);
//    }
private FindProfilesInteractor interactor;
    private FakeRemoteDataAccessObject fakeRemoteDataAccessObject;
    private FakeCompatibilityAlgorithm fakeCompatibilityAlgorithm;
    private FakeFindProfilesOutputBoundary fakeOutputBoundary;

    @BeforeEach
    void setUp() throws IOException {
        fakeRemoteDataAccessObject = new FakeRemoteDataAccessObject();
        fakeCompatibilityAlgorithm = new FakeCompatibilityAlgorithm();
        fakeOutputBoundary = new FakeFindProfilesOutputBoundary();

        interactor = new FindProfilesInteractor(
                fakeCompatibilityAlgorithm,
                fakeOutputBoundary,
                fakeRemoteDataAccessObject
        );
    }

//    @Test
//    void testExecuteSuccess() {
//        // Arrange
//        fakeRemoteDataAccessObject.setCurrentUsername("john_doe");
//        fakeRemoteDataAccessObject.addProfile(new Profile("john_doe", "Male"));
//        fakeRemoteDataAccessObject.addProfile(new Profile("user1", "Female"));
//        fakeRemoteDataAccessObject.addProfile(new Profile("user2", "Male"));
//
//        // Act
//        Map<String, Double> scores = interactor.execute(new FindProfileInputData(
//                null, null, fakeRemoteDataAccessObject
//        ));
//
//        // Assert
//        assertNotNull(scores);
//        assertEquals(2, scores.size());
//        assertEquals(0.9, scores.get("user1"));
//        assertEquals(0.7, scores.get("user2"));
//
//        // Verify output boundary
//        assertNotNull(fakeOutputBoundary.finds);
//        assertEquals(0.9, fakeOutputBoundary.finds.getScores().get("user1"));
//        //assertTrue(fakeOutputBoundary.finds.getMatches().get("user1"));
//        assertEquals(0.7, fakeOutputBoundary.finds.getScores().get("user2"));
//        //assertFalse(fakeOutputBoundary.finds.getMatches().get("user2"));
//    }

    @Test
    void testExecuteNoProfilesFound() {
        // Arrange
        fakeRemoteDataAccessObject.setCurrentUsername("john_doe");

        // Act
        Map<String, Double> scores = interactor.execute(new FindProfileInputData(
                null, null, fakeRemoteDataAccessObject
        ));

        // Assert
        assertNull(scores);
        //assertEquals("Error finding profiles: Profile not found for username: john_doe.", fakeOutputBoundary.errorMessage);
    }

//    @Test
//    void testExecuteProfileNotFound() {
//        // Arrange
//        fakeRemoteDataAccessObject.setCurrentUsername("john_doe");
//
//        // Act
//        Map<String, Double> scores = interactor.execute(new FindProfileInputData(
//                null, null, fakeRemoteDataAccessObject
//        ));
//
//        // Assert
//        assertNull(scores);
//        assertEquals("Error finding profiles: Profile not found for username: john_doe", fakeOutputBoundary.errorMessage);
//    }
}


