package e2e.Proxy;

import Estructurales.Proxy.controlador.ProxyController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ProxyE2ETest {

    @Test
    void simulacionCompletaPedido() {
        ProxyController controller = new ProxyController();
        controller.ejecutarFlujo();
    }

    @Test
    void ejecutarFlujo_NoExceptionThrown() {
        ProxyController controller = new ProxyController();
        assertThatCode(controller::ejecutarFlujo).doesNotThrowAnyException();
    }

    @Test
    void ejecutarFlujo_MultipleCalls() {
        ProxyController controller = new ProxyController();
        controller.ejecutarFlujo();
        controller.ejecutarFlujo();
        // No assertions, just ensure no exceptions on repeated calls
    }

    @Test
    void proxyController_NotNull() {
        ProxyController controller = new ProxyController();
        assertThat(controller).isNotNull();
    }
}
