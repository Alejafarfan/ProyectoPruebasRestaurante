package e2e.Observer;


import Comportamentales.Observer.controlador.ObserverController;
import Comportamentales.Observer.modelo.Pedido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObserverE2ETest {

    @Test
    void fullFlowShouldPropagateUpdates() {
        ObserverController controller = new ObserverController();
        Pedido pedido = controller.crearPedido(5, "Sancocho de gallina");

        controller.cambiarEstadoPedido(pedido, "En preparación");
        controller.cambiarEstadoPedido(pedido, "Listo");
        controller.cambiarEstadoPedido(pedido, "Entregado");

        assertEquals("Entregado", pedido.getEstado());
    }
}
