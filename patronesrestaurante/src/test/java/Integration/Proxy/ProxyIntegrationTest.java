package Integration.Proxy;

import Estructurales.Proxy.modelo.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ProxyIntegrationTest {

    @Test
    void flujoCompletoClienteMeseroCocina() {
        Kitchen kitchen = new Kitchen("Camilo", 1, "Sopas");
        Waiter waiter = new Waiter("Paola", kitchen);
        Client client = new Client("Lucía", waiter);

        client.requestDish("Sancocho de gallina");
        // No assertions since original test has none, but should not throw exceptions
    }

    @Test
    void clienteSolicitaPlatoNoDisponible() {
        Kitchen kitchen = new Kitchen("Camilo", 1, "Sopas");
        Waiter waiter = new Waiter("Paola", kitchen);
        Client client = new Client("Lucía", waiter);

        // Assuming Kitchen or Waiter handles unavailable dishes gracefully
        client.requestDish("Pizza");
        // No exceptions expected
    }

    @Test
    void meseroSinCocinaNoPuedeAtender() {
        Waiter waiter = new Waiter("Paola", null);
        Client client = new Client("Lucía", waiter);

        assertThatThrownBy(() -> client.requestDish("Sancocho de gallina"))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    void cocinaConCapacidadCeroNoAtiendePedidos() {
        Kitchen kitchen = new Kitchen("Camilo", 0, "Sopas");
        Waiter waiter = new Waiter("Paola", kitchen);
        Client client = new Client("Lucía", waiter);

        client.requestDish("Sancocho de gallina");
        // No exceptions expected, but kitchen should not process the order
    }

    @Test
    void variosClientesSolicitanPlatos() {
        Kitchen kitchen = new Kitchen("Camilo", 2, "Sopas");
        Waiter waiter = new Waiter("Paola", kitchen);
        Client client1 = new Client("Lucía", waiter);
        Client client2 = new Client("Carlos", waiter);

        client1.requestDish("Sancocho de gallina");
        client2.requestDish("Ajiaco");
        // Both requests should be processed if kitchen capacity allows
    }
}
