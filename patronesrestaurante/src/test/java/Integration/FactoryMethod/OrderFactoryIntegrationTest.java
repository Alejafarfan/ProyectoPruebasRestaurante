package Integration.FactoryMethod;

import Creacionales.FactoryMethod.controlador.OrderFactoryController;
import Creacionales.FactoryMethod.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryIntegrationTest {

    @Test
    void placeOrder_flowWorksAndTotalsAreCorrect() {
        KitchenService kitchen = order -> {
            // Simulate order preparation
        };
        OrderCreator creator = new DineInOrderCreator(kitchen);
        OrderFactoryController controller = new OrderFactoryController(creator);

        Order order = controller.placeOrder("Mesa 5");

        assertNotNull(order);
        assertEquals("DINE_IN", order.getType());
        assertEquals(2, order.getItems().size());
        assertEquals(25.0, order.getPrice(), 0.001);
    }

    @Test
    void placeOrder_takeaway_triggersKitchenAndHasPositiveTotals() {
        AtomicBoolean kitchenCalled = new AtomicBoolean(false);
        KitchenService kitchen = order -> {
            kitchenCalled.set(true);
        };

        OrderCreator creator = new TakeAwayOrderCreator(kitchen, null);
        OrderFactoryController controller = new OrderFactoryController(creator);

        Order order = controller.placeOrder("Para llevar");

        assertNotNull(order);
        assertTrue(kitchenCalled.get(), "Kitchen should be invoked for takeaway orders");
        assertEquals("TAKEAWAY", order.getType());
        assertTrue(order.getItems().size() >= 1, "Takeaway order should contain at least one item");
        assertTrue(order.getPrice() > 0.0, "Takeaway order price should be positive");
    }

    @Test
    void placeOrder_delivery_and_dineIn_areIndependentAndHaveCorrectTypes() {
        AtomicBoolean kitchenDineInCalled = new AtomicBoolean(false);
        AtomicBoolean kitchenDeliveryCalled = new AtomicBoolean(false);

        KitchenService dineInKitchen = order -> kitchenDineInCalled.set(true);
        KitchenService deliveryKitchen = order -> kitchenDeliveryCalled.set(true);

        OrderCreator dineInCreator = new DineInOrderCreator(dineInKitchen);
        OrderCreator deliveryCreator = new DeliveryOrderCreator(deliveryKitchen, null);

        OrderFactoryController dineInController = new OrderFactoryController(dineInCreator);
        OrderFactoryController deliveryController = new OrderFactoryController(deliveryCreator);

        Order dineInOrder = dineInController.placeOrder("Mesa 1");
        Order deliveryOrder = deliveryController.placeOrder("Calle Falsa 123");

        assertNotNull(dineInOrder);
        assertNotNull(deliveryOrder);
        assertTrue(kitchenDineInCalled.get(), "Dine-in kitchen should be invoked");
        assertTrue(kitchenDeliveryCalled.get(), "Delivery kitchen should be invoked");
        assertEquals("DINE_IN", dineInOrder.getType());
        assertEquals("DELIVERY", deliveryOrder.getType());
        assertNotSame(dineInOrder, deliveryOrder, "Orders from different creators should be distinct");
        assertTrue(dineInOrder.getItems().size() >= 1);
        assertTrue(deliveryOrder.getItems().size() >= 1);
        assertTrue(dineInOrder.getPrice() > 0.0);
        assertTrue(deliveryOrder.getPrice() > 0.0);
    }
}