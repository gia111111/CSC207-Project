package use_case.matches;

import data_access.InMemoryDataAccessObject;
import data_access.RemoteDataAccessObject;
import entity.Matches;
import entity.Requests;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import use_case.matches.MatchesInputData;
import use_case.matches.MatchesInteractor;
import use_case.matches.MatchesOutputBoundary;
import use_case.matches.MatchesOutputData;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class MatchesInteractorTest {
    private RemoteDataAccessObject mockDataAccessObject;
    private RemoteDataAccessObject mockDataAccessObject2;

    @BeforeEach
    void setUp() throws Exception {
        mockDataAccessObject = mock(RemoteDataAccessObject.class);
        when(mockDataAccessObject.getCurrentUsername()).thenReturn("Matt");
        when(mockDataAccessObject.getNames()).thenReturn(List.of("Jack", "Anna"));
        mockDataAccessObject2 = mock(RemoteDataAccessObject.class);
        when(mockDataAccessObject2.getCurrentUsername()).thenReturn(null);
    }

    @Test
    void executeSuccessTest() {

        HashMap<String, List<String>> matchesData = new HashMap<>();
        matchesData.put("Jack", List.of("Instagram", "@JackTheBear"));
        matchesData.put("Anna", List.of("SnapChat", "@annaTheBana"));

//        MatchesInputData inputData = new MatchesInputData(Map.of("Jack", List.of("Instagram", "@JackTheBear"),
//                "Anna", List.of("SnapChat", "@annaTheBana")), mockDataAccessObject);

        MatchesInputData inputData = new MatchesInputData(matchesData, mockDataAccessObject);
        System.out.println("test1"+inputData.getMatches());

        InMemoryDataAccessObject matchesRepository = new InMemoryDataAccessObject(){
            @Override
            public List<String> getRequests(String username) {
                return List.of("Jack", "Anna");
            }

            @Override
            public List<String> getContactCard(String username) {
                return List.of("Instagram", "@"+ username + "the duck");
            }
        };

        Matches mock = new Matches(mockDataAccessObject.getCurrentUsername(), matchesData);
        mock.setMatches(matchesData);
        System.out.println("test" + mock.getMatches());
        matchesRepository.save(mock);

        HashMap<String, Boolean> requestsPart1 = new HashMap<>();
        requestsPart1.put("Jack", true);
        requestsPart1.put("Anna", false);
        HashMap<String, Double> requestsPart2 = new HashMap<>();
        requestsPart2.put("Jack", 63.1);
        requestsPart2.put("Anna", 16.7);
        Requests requests = new Requests(requestsPart1, requestsPart2);
        matchesRepository.save(requests);

        MatchesOutputBoundary successPresenter = new MatchesOutputBoundary() {
            @Override
            public void prepareSuccessView(MatchesOutputData matchesOutputData) {
                assertEquals("Matt", matchesOutputData.getName());
                System.out.println(matchesRepository + "repo");
                assertTrue(matchesRepository.getRequests("Matt") != null);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }

            @Override
            public void switchToDashBoardView() {
            }
        };

        MatchesInteractor interactor = new MatchesInteractor(matchesRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void executeFailureNoMatchesTest() {

        MatchesDataAccessObject matchesRepository = new InMemoryDataAccessObject();

        MatchesInputData inputData = new MatchesInputData(null, mockDataAccessObject2);
        System.out.println(inputData.getMatches());

        MatchesOutputBoundary failurePresenter = new MatchesOutputBoundary() {
            @Override
            public void prepareSuccessView(MatchesOutputData matchesOutputData) {
                fail("Use case failure is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Sorry, no current matches. Please access the Finds page from Dashboard to start matching!", errorMessage);
            }

            @Override
            public void switchToDashBoardView() {
            }
        };
        MatchesInteractor interactor = new MatchesInteractor(matchesRepository,failurePresenter);
        interactor.execute(inputData);
    }
}
