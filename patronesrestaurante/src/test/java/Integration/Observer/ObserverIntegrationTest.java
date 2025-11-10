package Integration.Observer;

import Comportamentales.Observer.controlador.ObserverController;
import Comportamentales.Observer.modelo.Pedido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObserverIntegrationTest {

    @Test
    void controllerShouldNotifyObserversWhenStateChanges() {
        ObserverController controller = new ObserverController();
        Pedido pedido = controller.crearPedido(10, "Pasta Alfredo");

        controller.cambiarEstadoPedido(pedido, "Listo");
        assertEquals("Listo", pedido.getEstado());
    }
}

