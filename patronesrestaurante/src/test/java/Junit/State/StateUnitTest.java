package Junit.State;

import Comportamentales.State.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StateUnitTest {

    @Test
    void pedidoDebeCambiarDeEstado() {
        Pedido pedido = new Pedido(1, "Pasta");
        assertEquals("Nuevo", pedido.getEstadoNombre());

        pedido.avanzarEstado();
        assertEquals("Preparando", pedido.getEstadoNombre());
    }

    @Test
    void pedidoDebeLlegarHastaCerrado() {
        Pedido pedido = new Pedido(1, "Ensalada"); 

        pedido.avanzarEstado(); // Preparando
        pedido.avanzarEstado(); // Listo para servir
        pedido.avanzarEstado(); // Entregado
        pedido.avanzarEstado(); // Cerrado

        assertEquals("Cerrado", pedido.getEstadoNombre());
    }

    @Test
    void pedidoDebeIniciarEnEstadoNuevo() {
        Pedido pedido = new Pedido(2, "Pizza");
        assertEquals("Nuevo", pedido.getEstadoNombre());
    }

    @Test
    void pedidoDebeAvanzarHastaListoParaServir() {
        Pedido pedido = new Pedido(3, "Hamburguesa");
        
        pedido.avanzarEstado(); // Preparando
        pedido.avanzarEstado(); // Listo para servir
        
        assertEquals("Listo para servir", pedido.getEstadoNombre());
    }

    @Test 
    void pedidoDebeAvanzarHastaEntregado() {
        Pedido pedido = new Pedido(4, "Sushi");

        pedido.avanzarEstado(); // Preparando
        pedido.avanzarEstado(); // Listo para servir
        pedido.avanzarEstado(); // Entregado

        assertEquals("Entregado", pedido.getEstadoNombre());
    }

    @Test
    void verificarIdYDescripcionPedido() {
        Pedido pedido = new Pedido(5, "Tacos");
        assertEquals(5, pedido.getId());
        assertEquals("Tacos", pedido.getDescripcion());
    }
}
