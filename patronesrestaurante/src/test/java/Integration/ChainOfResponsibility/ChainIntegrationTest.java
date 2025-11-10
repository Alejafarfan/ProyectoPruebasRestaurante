package Integration.ChainOfResponsibility;

import Comportamentales.ChainOfResponsibility.controlador.ChainController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ChainE2ETest {

    private ChainController controller;

    @BeforeEach
    void setUp() {
        controller = new ChainController();
    }

    @Test 
    void testFullClientRequestFlow() {
        controller.ejecutarFlujo();
    }

    @Test
    void testEmptyRequestFlow() {
        ChainController mockController = mock(ChainController.class);
        doNothing().when(mockController).ejecutarFlujo();
        
        mockController.ejecutarFlujo();
        
        verify(mockController, times(1)).ejecutarFlujo();
    }

    @Test
    void testMultipleRequestsFlow() {
        controller.ejecutarFlujo();
        controller.ejecutarFlujo();
        controller.ejecutarFlujo();
    }

    @Test
    void testControllerInitialization() {
        assertThat(controller).isNotNull();
    }
}
