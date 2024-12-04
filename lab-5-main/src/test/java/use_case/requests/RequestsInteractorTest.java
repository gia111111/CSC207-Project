package use_case.requests;

import data_access.InMemoryDataAccessObject;
import data_access.RemoteDataAccessObject;
import entity.Finds;
import entity.Profile;
import entity.Requests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RequestsInteractorTest {
    private RemoteDataAccessObject mockDataAccessObject;
    private RemoteDataAccessObject mockDataAccessObject2;
    private RemoteDataAccessObject mockDataAccessObject3;
    private RemoteDataAccessObject mockDataAccessObject4;
    private CompatibilityAlgorithm2 mockAlgorithm;

    @BeforeEach
    void setUp() throws Exception {
        mockAlgorithm = mock(CompatibilityAlgorithm2.class);
        mockDataAccessObject = mock(RemoteDataAccessObject.class);
        mockDataAccessObject2 = mock(RemoteDataAccessObject.class);
        mockDataAccessObject3 = mock(RemoteDataAccessObject.class);
        when(mockDataAccessObject.getCurrentUsername()).thenReturn("Eddie");
        when(mockDataAccessObject.getNames()).thenReturn(List.of( "Aurora","Eddie"));
        //when(mockDataAccessObject.getRequestsActionsMap("Eddie")).thenReturn()
        Profile current = null;
        Profile partner = null;
        when(mockDataAccessObject.getProfile("Eddie")).thenReturn(current);
        when(mockDataAccessObject.getProfile("Aurora")).thenReturn(partner);
        when(mockDataAccessObject.getFinds("Aurora")).thenReturn(Map.of("Eddie", true));
        // when(mockDataAccessObject.updateSatus("Eddie", "Aurora",true)).

        when(mockAlgorithm.calculateScore(partner,current)).thenReturn(50.1);
        when(mockAlgorithm.calculateScore(current,partner)).thenReturn(53.56);

        when(mockDataAccessObject2.getCurrentUsername()).thenReturn("Anna");
        when(mockDataAccessObject2.getNames()).thenReturn(List.of("Anna", "Adam"));
        when(mockDataAccessObject2.getFinds("Adam")).thenReturn(Map.of("Anna", false));

        when(mockDataAccessObject3.getCurrentUsername()).thenReturn("Suzy");
        when(mockDataAccessObject3.getNames()).thenReturn((List.of("Suzy","Jennie")));
        HashMap<String, Boolean> empty = new HashMap<>();
        when(mockDataAccessObject3.getFinds("jennie")).thenReturn(empty);

        mockDataAccessObject4 = mock(RemoteDataAccessObject.class);
        when(mockDataAccessObject4.getCurrentUsername()).thenReturn("Tiffany");
        when(mockDataAccessObject4.getNames()).thenReturn(List.of("Tiffany","Jessica"));
       //when(mockDataAccessObject4.getFinds("Jessica")).thenReturn(Map.of("Tiffany", null));



    }

    @Test
    void executeSuccessTest(){
        HashMap<String, Boolean> statusMap = new HashMap<>();
        HashMap<String, Double> scoresMap = new HashMap<>();
        statusMap.put("Aurora", null);
        scoresMap.put("Aurora", 53.56);
        Requests mock = new Requests(statusMap,scoresMap);
        mock.setActionsToRequests(statusMap);
        mock.setScoresMap(scoresMap);

        RequestsInputData inputData = new RequestsInputData(mockDataAccessObject,null);

        InMemoryDataAccessObject requestsRepositoryE = new InMemoryDataAccessObject() {
            @Override
            public Map<String, Boolean> getFinds(String partnerName) {
                HashMap<String, Boolean> finds = new HashMap<>();
                finds.put("Eddie", true);
                return finds;
            }

            @Override
            public List<String> getNames(){
                List<String> list = new ArrayList<>();
                list.add("Aurora");
                list.add("Eddie");
                return  list;
            }

        };
        requestsRepositoryE.setCurrentUsername("Eddie");
        requestsRepositoryE.save(mock);

        HashMap<String, Boolean> findsstatusA = new HashMap<>();
        findsstatusA.put("Eddie", true);
        HashMap<String, Double> scoresA = new HashMap<>();
        scoresA.put("Eddie", 50.1);
        Finds finds = new Finds(findsstatusA,scoresA);


        InMemoryDataAccessObject requestsRepositoryA = new InMemoryDataAccessObject();
        requestsRepositoryA.setCurrentUsername("Aurora");
        requestsRepositoryA.save(finds);


        RequestsOutputBoundary successPresenter = new RequestsOutputBoundary() {
            @Override
            public void prepareSuccessView(RequestsOutputData outputData) {
                assertTrue(outputData.getName() == "Eddie");
                assertTrue(requestsRepositoryE.getFinds("Aurora")!= null);
                assertTrue(requestsRepositoryE.getRequestsActionsMap("Eddie").get("Aurora") == null);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                System.out.println(errorMessage);
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToDashBoardView() {

            }
        };

        RequestsInteractor interactor = new RequestsInteractor(successPresenter,
                requestsRepositoryE, mockAlgorithm);
        interactor.execute(inputData);

    }

    @Test
    public void testNoNamesFound() throws Exception {
        // Arrange
        RemoteDataAccessObject mockDataAccess = mock(RemoteDataAccessObject.class);
        RequestsOutputBoundary mockOutputBoundary = mock(RequestsOutputBoundary.class);
        CompatibilityAlgorithm2 mockAlgorithm = mock(CompatibilityAlgorithm2.class);
        when(mockDataAccess.getNames()).thenReturn(List.of());

        RequestsInteractor interactor = new RequestsInteractor(mockOutputBoundary, mockDataAccess, mockAlgorithm);

        RequestsInputData inputData = new RequestsInputData(mockDataAccess,null);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockOutputBoundary).prepareFailView("Error getting requests: No names found.");
    }


    @Test
    void acceptTest(){
        RequestsInputData inputData = new RequestsInputData(mockDataAccessObject,"Aurora");
        when(mockDataAccessObject.getCurrentUsername()).thenReturn("Eddie");

        HashMap<String,Boolean> test = new HashMap<>();
        test.put("Aurora", true);
        when(mockDataAccessObject.getRequestsActionsMap("Eddie")).thenReturn(test);
        RequestsOutputBoundary acceptPresenter = new RequestsOutputBoundary() {
            @Override
            public void prepareSuccessView(RequestsOutputData outputData) {
                assertTrue(mockDataAccessObject.getRequestsActionsMap(outputData.getName()).get("Aurora"));
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");

            }

            @Override
            public void switchToDashBoardView() {

            }
        };
        RequestsInteractor interactor = new RequestsInteractor(acceptPresenter,mockDataAccessObject,mockAlgorithm);
        HashMap<String, Boolean> result = interactor.accept(inputData);

        assertNotNull(result);
        assertTrue(result.containsKey("Aurora"));
        assertTrue(result.get("Aurora"));

    }


    @Test
    void rejectTest(){
        RequestsInputData inputData = new RequestsInputData(mockDataAccessObject,"Aurora");
        when(mockDataAccessObject.getCurrentUsername()).thenReturn("Eddie");
        HashMap<String,Boolean> test = new HashMap<>();
        test.put("Aurora", false);
        when(mockDataAccessObject.getRequestsActionsMap("Eddie")).thenReturn(test);
        RequestsOutputBoundary rejectPresenter = new RequestsOutputBoundary() {
            @Override
            public void prepareSuccessView(RequestsOutputData outputData) {
                assertFalse(mockDataAccessObject.getRequestsActionsMap(outputData.getName()).get("Aurora"));
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");

            }

            @Override
            public void switchToDashBoardView() {

            }
        };
        RequestsInteractor interactor = new RequestsInteractor(rejectPresenter,mockDataAccessObject,mockAlgorithm);
        HashMap<String, Boolean> result = interactor.reject(inputData);

        assertNotNull(result);
        assertTrue(result.containsKey("Aurora"));
        assertFalse(result.get("Aurora"));

    }

    @Test
    void findsRejectTest(){

        RequestsInputData inputData = new RequestsInputData(mockDataAccessObject2,null);

        InMemoryDataAccessObject requestsRepository = new InMemoryDataAccessObject() {
            @Override
            public Map<String, Boolean> getFinds(String partnerName) {
                HashMap<String, Boolean> finds = new HashMap<>();
                finds.put("Adam", false);
                return finds;
            }

            @Override
            public List<String> getNames(){
                List<String> list = new ArrayList<>();
                list.add("Anna");
                list.add("Adam");
                return  list;
            }

        };
        requestsRepository.setCurrentUsername("Anna");

        HashMap<String, Boolean> findsstatusA = new HashMap<>();
        findsstatusA.put("Anna", false);
        HashMap<String, Double> scoresA = new HashMap<>();
        scoresA.put("Anna", 12.7);
        Finds finds = new Finds(findsstatusA,scoresA);


        InMemoryDataAccessObject requestsRepository2 = new InMemoryDataAccessObject();
        requestsRepository2.setCurrentUsername("Adam");
        requestsRepository2.save(finds);


        RequestsOutputBoundary successPresenter = new RequestsOutputBoundary() {
            @Override
            public void prepareSuccessView(RequestsOutputData outputData) {

                assertTrue(outputData.getName() == "Anna");

                assertTrue(requestsRepository.getFinds("Adam")!= null);

                assertTrue(requestsRepository.getRequestsActionsMap("Anna").size()==0);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                System.out.println(errorMessage);
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToDashBoardView() {

            }
        };

        RequestsInteractor interactor = new RequestsInteractor(successPresenter,
                requestsRepository, mockAlgorithm);
        interactor.execute(inputData);

    }

    @Test
    void noFindsTest(){

        RequestsInputData inputData = new RequestsInputData(mockDataAccessObject3,null);

        InMemoryDataAccessObject requestsRepository = new InMemoryDataAccessObject() {
            @Override
            public Map<String, Boolean> getFinds(String partnerName) {
                HashMap<String, Boolean> finds = new HashMap<>();
                return finds;
            }

            @Override
            public List<String> getNames(){
                List<String> list = new ArrayList<>();
                list.add("Suzy");
                list.add("Jennie");
                return  list;
            }

        };
        requestsRepository.setCurrentUsername("Suzy");


        RequestsOutputBoundary successPresenter = new RequestsOutputBoundary() {
            @Override
            public void prepareSuccessView(RequestsOutputData outputData) {

                assertTrue(outputData.getName() == "Suzy");

                assertTrue(requestsRepository.getFinds("Adam").size() == 0);

            }

            @Override
            public void prepareFailView(String errorMessage) {
                System.out.println(errorMessage);
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToDashBoardView() {

            }
        };

        RequestsInteractor interactor = new RequestsInteractor(successPresenter,
                requestsRepository, mockAlgorithm);
        interactor.execute(inputData);

    }
//
    @Test
    void testPartnerFindResultsNull() {
        RequestsInputData requestsInputData = new RequestsInputData(mockDataAccessObject4, null);
        InMemoryDataAccessObject requestsRepository = new InMemoryDataAccessObject() {
            @Override
            public Map<String, Boolean> getFinds(String partnerName) {
                HashMap<String, Boolean> finds = new HashMap<>();
                finds.put("Tiffany", null);
                return finds;
            }

            @Override
            public List<String> getNames(){
                List<String> list = new ArrayList<>();
                list.add("Tiffany");
                list.add("Jessica");
                return  list;
            }

        };

        RequestsOutputBoundary mockOutputBoundary1 = new RequestsOutputBoundary() {
            @Override
            public void prepareSuccessView(RequestsOutputData outputData) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertTrue(requestsRepository.getFinds("Jessica").get("Tiffany") == null);
            }

            @Override
            public void switchToDashBoardView() {

            }
        };

        RequestsInteractor interactor = new RequestsInteractor(mockOutputBoundary1, mockDataAccessObject4, mockAlgorithm);
        interactor.execute(requestsInputData);
    }

    @Test
    void testExceptionHandling() throws Exception {
        RemoteDataAccessObject mockDataAccessObject5 = mock(RemoteDataAccessObject.class);
        when(mockDataAccessObject5.getNames()).thenThrow(new RuntimeException("Database error"));
        RequestsInputData inputData = new RequestsInputData(mockDataAccessObject5, null);
        RequestsOutputBoundary mockOutputBoundary = mock(RequestsOutputBoundary.class);

        RequestsInteractor interactor = new RequestsInteractor(mockOutputBoundary, mockDataAccessObject5, mockAlgorithm);
        interactor.execute(inputData);

        verify(mockOutputBoundary).prepareFailView("Error getting requests: Database error");
    }

}




