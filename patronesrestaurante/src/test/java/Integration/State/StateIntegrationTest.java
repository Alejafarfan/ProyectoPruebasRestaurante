package Integration.State;

import Comportamentales.State.controlador.StateController;
import Comportamentales.State.modelo.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateIntegrationTest {

    private StateController controller;
    private Pedido pedido;

    @BeforeEach
    void setUp() {
        controller = new StateController();
        pedido = controller.crearPedido(10, "Sancocho");
    }

    @Test
    void controladorDebeAvanzarCorrectamenteElEstado() {
        controller.avanzarEstado(pedido); // Preparando
        controller.avanzarEstado(pedido); // Listo para servir

        assertEquals("Listo para servir", controller.obtenerEstado(pedido));
    }

    @Test
    void pedidoDebeIniciarEnEstadoOrdenado() {
        assertEquals("Ordenado", controller.obtenerEstado(pedido));
    }

    @Test
    void debePermitirAvanzarHastaEstadoServido() {
        controller.avanzarEstado(pedido); // Preparando
        controller.avanzarEstado(pedido); // Listo para servir
        controller.avanzarEstado(pedido); // Servido

        assertEquals("Servido", controller.obtenerEstado(pedido));
    }

    @Test
    void debeCrearPedidoConDatosCorrectos() {
        assertEquals(10, pedido.getMesa());
        assertEquals("Sancocho", pedido.getDescripcion());
    }

    @Test
    void noDebeAvanzarEstadoDespuesDeServido() {
        controller.avanzarEstado(pedido); // Preparando
        controller.avanzarEstado(pedido); // Listo para servir
        controller.avanzarEstado(pedido); // Servido
        controller.avanzarEstado(pedido); // Intento adicional

        assertEquals("Servido", controller.obtenerEstado(pedido));
    }
}

