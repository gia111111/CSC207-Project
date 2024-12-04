package use_case.find;

import data_access.InMemoryDataAccessObject;
import data_access.RemoteDataAccessObject;
import entity.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FindInteractorTest {
    private RemoteDataAccessObject mockDataAccessObject;
    private ProfileFactory profileFactory;

    @BeforeEach
    void setUp() throws Exception {
        this.profileFactory = new CommonProfileFactory();
        mockDataAccessObject = mock(RemoteDataAccessObject.class);
        when(mockDataAccessObject.getCurrentUsername()).thenReturn("Hannah");
    }

    @Test
    void executeSuccessTest() {
        HashMap<String, Double> scores = new HashMap<>();
        HashMap<String, Boolean> likes = new HashMap<>();
        scores.put("Adam", 32.4);
        scores.put("Zac", 32.4);
        likes.put("Adam", true);
        likes.put("Zac", true);

        FindInputData inputData = new FindInputData(scores, likes, mockDataAccessObject) {
            @Override
            public Map<String, Boolean> getMatches() {
                return Map.of("Adam", false, "Zac", true);
            }

            public Map<String, Double> getScores() {
                return Map.of("Adam", 32.7, "Zac", 68.2);
            }
        };

        List<String> names = new ArrayList<>() {
            @Override
            public boolean remove(Object o) {
                return true;
            }
        };
        names.add("Adam");
        names.add("Zac");

        FindDataAccessInterface findsRepository = new InMemoryDataAccessObject() {
            @Override
            public Profile getProfile(String username){
                    return profileFactory.create(username, "Female",
                            "Male", 19, Map.of("section 1", List.of("A", "A", "A", "A", "A"),
                                    "section 2", List.of("B", "B", "B", "B", "B"),
                                    "section 3", List.of("C", "C", "C", "C", "C"),
                                    "section 4", List.of("D", "D", "D", "D", "D"),
                                    "section 5", List.of("A", "B", "C", "D", "A")),
                            Map.of("section1", 20, "section2", 20, "section3", 20, "section4", 20, "section5", 20),
                            "@" + username, "Instagram");
            }

            @Override
            public List<String> getNames() {
                return names;
            }

            @Override
            public String getCurrentUsername() {
                return "Hannah";
            }
        };

        CompatibilityAlgorithm algorithm = new BasicCompatibilityAlgorithm() {
            @Override
            public double calculateScore(Profile currentUser, Profile otherUser) {
                return 32.4;
            }
        };

        HashMap<String, Boolean> matches = new HashMap<>(inputData.getMatches());
        HashMap<String, Double> scores1 = new HashMap<>(inputData.getScores());

        Finds finds = new Finds(matches, scores1);
        findsRepository.save(finds);

        FindOutputBoundary successPresenter = new FindOutputBoundary() {
            @Override
            public void presentFinds(Finds finds) {
                assertEquals(likes, finds.getFinds());
                assertEquals(scores, finds.getScores());
                assertTrue(findsRepository.getCurrentUsername().equals("Hannah"));
            }

            @Override
            public void presentError(String error) {
                fail("Use case failure is unexpected");
            }
        };

        FindInteractor interactor = new FindInteractor(algorithm, successPresenter, findsRepository);
        interactor.execute(inputData);
    }

    @Test
    void executeFailNoProfileTest() {
        HashMap<String, Double> scores = new HashMap<>();
        HashMap<String, Boolean> likes = new HashMap<>();
        scores.put("Adam", 32.4);
        scores.put("Zac", 32.4);
        likes.put("Adam", true);
        likes.put("Zac", true);

        FindInputData inputData = new FindInputData(scores, likes, mockDataAccessObject) {
            @Override
            public Map<String, Boolean> getMatches() {
                return Map.of("Adam", false, "Zac", true);
            }

            public Map<String, Double> getScores() {
                return Map.of("Adam", 32.7, "Zac", 68.2);
            }
        };

        List<String> names = new ArrayList<>() {
            @Override
            public boolean remove(Object o) {
                return true;
            }
        };
        names.add("Adam");
        names.add("Zac");

        FindDataAccessInterface findsRepository = new InMemoryDataAccessObject() {
            @Override
            public Profile getProfile(String username){
                return null;
            }
            @Override
            public List<String> getNames() {
                return names;
            }

            @Override
            public String getCurrentUsername() {
                return "Hannah";
            }
        };

        CompatibilityAlgorithm algorithm = new BasicCompatibilityAlgorithm() {
            @Override
            public double calculateScore(Profile currentUser, Profile otherUser) {
                return 32.4;
            }
        };

        HashMap<String, Boolean> matches = new HashMap<>(inputData.getMatches());
        HashMap<String, Double> scores1 = new HashMap<>(inputData.getScores());

        Finds finds = new Finds(matches, scores1);
        findsRepository.save(finds);

        FindOutputBoundary successPresenter = new FindOutputBoundary() {
            @Override
            public void presentFinds(Finds finds) {
                fail("Use case failure is unexpected");
            }
            @Override
            public void presentError(String error) {
                StringBuilder capturedError = new StringBuilder();
                capturedError.append(error);
                assertEquals("Error finding profiles: Profile not found for username: Hannah", capturedError.toString());
            }
        };

        FindInteractor interactor = new FindInteractor(algorithm, successPresenter, findsRepository);
        interactor.execute(inputData);

    }

    @Test
    void executeFailNoName() {
        HashMap<String, Double> scores = new HashMap<>();
        HashMap<String, Boolean> likes = new HashMap<>();
        scores.put("Adam", 32.4);
        scores.put("Zac", 32.4);
        likes.put("Adam", true);
        likes.put("Zac", true);

        FindInputData inputData = new FindInputData(scores, likes, mockDataAccessObject) {
            @Override
            public Map<String, Boolean> getMatches() {
                return Map.of("Adam", false, "Zac", true);
            }

            public Map<String, Double> getScores() {
                return Map.of("Adam", 32.7, "Zac", 68.2);
            }
        };

        List<String> names = new ArrayList<>();

        FindDataAccessInterface findsRepository = new InMemoryDataAccessObject() {
            @Override
            public Profile getProfile(String username){
                return profileFactory.create(username, "Female",
                        "Male", 19, Map.of("section 1", List.of("A", "A", "A", "A", "A"),
                                "section 2", List.of("B", "B", "B", "B", "B"),
                                "section 3", List.of("C", "C", "C", "C", "C"),
                                "section 4", List.of("D", "D", "D", "D", "D"),
                                "section 5", List.of("A", "B", "C", "D", "A")),
                        Map.of("section1", 20, "section2", 20, "section3", 20, "section4", 20, "section5", 20),
                        "@" + username, "Instagram");
            }

            @Override
            public List<String> getNames() {
                return names;
            }

            @Override
            public String getCurrentUsername() {
                return "Hannah";
            }
        };

        CompatibilityAlgorithm algorithm = new BasicCompatibilityAlgorithm() {
            @Override
            public double calculateScore(Profile currentUser, Profile otherUser) {
                return 32.4;
            }
        };

        HashMap<String, Boolean> matches = new HashMap<>(inputData.getMatches());
        HashMap<String, Double> scores1 = new HashMap<>(inputData.getScores());

        Finds finds = new Finds(matches, scores1);
        findsRepository.save(finds);

        FindOutputBoundary successPresenter = new FindOutputBoundary() {
            @Override
            public void presentFinds(Finds finds) {
                fail("Use case failure is unexpected");
            }
            @Override
            public void presentError(String error) {
                StringBuilder capturedError = new StringBuilder();
                capturedError.append(error);
                assertEquals("Error finding profiles: No profiles found in the database.", capturedError.toString());
            }
        };

        FindInteractor interactor = new FindInteractor(algorithm, successPresenter, findsRepository);
        interactor.execute(inputData);
    }

    @Test
    void setRequestStatusTest() {
            // Prepare test inputs
            String otherUserId = "Adam";
            Boolean isAccepted = true;

            // Create mock instances of dependencies
            CompatibilityAlgorithm mockAlgorithm = mock(CompatibilityAlgorithm.class);
            FindOutputBoundary mockOutputBoundary = mock(FindOutputBoundary.class);

            // Initialize the FindInteractor with the mock dependencies
            FindInteractor findInteractor = new FindInteractor(mockAlgorithm, mockOutputBoundary, mockDataAccessObject);

            // Call the method under test
            findInteractor.setRequestStatus(otherUserId, isAccepted);

            // Verify that the method on mockDataAccessObject is called with correct parameters
            verify(mockDataAccessObject).setRequestStatus(otherUserId, isAccepted);

    }
}
