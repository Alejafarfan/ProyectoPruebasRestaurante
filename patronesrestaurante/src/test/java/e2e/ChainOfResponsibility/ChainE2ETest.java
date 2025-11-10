package e2e.ChainOfResponsibility;

import Comportamentales.ChainOfResponsibility.controlador.ChainController;
import org.junit.jupiter.api.Test;

class ChainE2ETest {

    @Test
    void testFullClientRequestFlow() {
        ChainController controller = new ChainController();
        controller.ejecutarFlujo();
    }
}
