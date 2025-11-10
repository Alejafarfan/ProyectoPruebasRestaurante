package e2e.State;

import Comportamentales.State.controlador.StateController;
import Comportamentales.State.modelo.Pedido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateE2ETest {

    @Test
    void flujoCompletoDebeLlevarElPedidoHastaCerrado() {
        StateController controller = new StateController();
        Pedido pedido = controller.crearPedido(5, "Bandeja paisa");

        controller.avanzarEstado(pedido); // Preparando
        controller.avanzarEstado(pedido); // Listo para servir
        controller.avanzarEstado(pedido); // Entregado
        controller.avanzarEstado(pedido); // Cerrado

        assertEquals("Cerrado", controller.obtenerEstado(pedido));
    }
}
