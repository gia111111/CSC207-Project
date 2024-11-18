package use_case.dashboard;

import interface_adapter.dashboard.DashBoardState;
import interface_adapter.dashboard.DashBoardViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DashBoardViewModelTest {
    private DashBoardViewModel dashBoardViewModel;
    private boolean propertyChangeTriggered;

    @BeforeEach
    public void setUp() {
        dashBoardViewModel = new DashBoardViewModel();
        propertyChangeTriggered = false;
    }

    @Test
    void testInitialState() {
        assertEquals("dashboard", dashBoardViewModel.getState().getCurrentSection());
    }

    @Test
    void testSetCurrentSection() {
        dashBoardViewModel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                propertyChangeTriggered = true;
            }
        });

        dashBoardViewModel.setState(new DashBoardState());
        assertTrue(propertyChangeTriggered);
        assertEquals("profile", dashBoardViewModel.getState().getCurrentSection());
    }
}
