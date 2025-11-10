package e2e.FactoryMethod;

import Creacionales.FactoryMethod.controlador.OrderFactoryController;
import Creacionales.FactoryMethod.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryE2ETest {

    @Test
    void fullFlow_createPrepareDeliver() {
        KitchenService kitchen = order -> System.out.println("Chef preparando: " + order.getName());
        OrderCreator creator = new DeliveryOrderCreator(kitchen, "Calle 123");
        OrderFactoryController controller = new OrderFactoryController(creator);

        Order order = controller.placeOrder("Cliente Juan");
        order.deliver();

        assertEquals("DELIVERY", order.getType());
        assertTrue(order.getPrice() > 0.0);
        assertFalse(order.getItems().isEmpty());
    }
}
