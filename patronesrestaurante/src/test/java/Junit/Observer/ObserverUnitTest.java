package Junit.Observer;

import Comportamentales.Observer.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObserverUnitTest {

    @Test
    void testPedidoEstadoActualizaCorrectamente() {
        Pedido pedido = new Pedido(1, "Hamburguesa");
        pedido.setEstado("Listo");
        assertEquals("Listo", pedido.getEstado());
    }

    @Test
    void testNotifierNotifiesObservers() {
        OrderNotifier notifier = new OrderNotifier();
        CocinaObserver cocina = new CocinaObserver("Test");
        notifier.agregarObservador(cocina);

        Pedido p = new Pedido(1, "Pizza");
        notifier.setPedido(p);
        assertEquals(p, notifier.getPedidoActual());
    }
}
