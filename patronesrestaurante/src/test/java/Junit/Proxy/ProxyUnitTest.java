package Junit.Proxy;

import Estructurales.Proxy.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProxyUnitTest {

    @Test
    void waiterDebeTomarYEntregarPedido() {
        Kitchen kitchen = new Kitchen("Andrés", 1, "Pasta");
        Waiter waiter = new Waiter("Carlos", kitchen);
        waiter.takeOrder("Spaghetti");
        assertEquals("Spaghetti", waiter.getCurrentOrder());
    }

    @Test
    void clientDebeSolicitarPlato() {
        Kitchen kitchen = new Kitchen("Mario", 1, "Postres");
        Waiter waiter = new Waiter("Sofía", kitchen);
        Client client = new Client("Lucía", waiter);

        client.requestDish("Tiramisú");
        assertEquals("Lucía", client.getName());
    }

    @Test
    void waiterDebeActualizarPedidoActual() {
        Kitchen kitchen = new Kitchen("Ana", 2, "Ensaladas");
        Waiter waiter = new Waiter("Pedro", kitchen);
        waiter.takeOrder("César");
        assertEquals("César", waiter.getCurrentOrder());
        waiter.takeOrder("Griega");
        assertEquals("Griega", waiter.getCurrentOrder());
    }

    @Test
    void kitchenDebePrepararPlatoCorrectamente() {
        Kitchen kitchen = new Kitchen("Luis", 3, "Carnes");
        String dish = kitchen.prepareDish("Bife");
        assertNotNull(dish);
        assertTrue(dish.contains("Bife"));
    }

    @Test
    void waiterSinPedidoDebeRetornarNull() {
        Kitchen kitchen = new Kitchen("Sara", 5, "Pescados");
        Waiter waiter = new Waiter("Raúl", kitchen);
        assertNull(waiter.getCurrentOrder());
    }
}
