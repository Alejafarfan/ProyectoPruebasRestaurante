package Junit.FactoryMethod;

import Creacionales.FactoryMethod.modelo.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderFactoryUnitTest {

    @Test
    void dineInOrder_prepare_delegatesToKitchen() {
        KitchenService kitchen = Mockito.mock(KitchenService.class);
        DineInOrderCreator creator = new DineInOrderCreator(kitchen);

        Order order = creator.createOrder("Mesa 1");
        order.addItem("Arroz", 10.0);
        order.prepare();

        verify(kitchen, times(1)).prepareOrder(order);
        assertEquals(10.0, order.getPrice(), 0.001);
        assertEquals("DINE_IN", order.getType());
    }

    @Test
    void takeOutOrder_prepare_delegatesToKitchen() {
        KitchenService kitchen = Mockito.mock(KitchenService.class);
        TakeAwayOrderCreator creator = new TakeAwayOrderCreator(kitchen, null);

        Order order = creator.createOrder("Cliente 1");
        order.addItem("Pizza", 15.0);
        order.prepare();

        verify(kitchen, times(1)).prepareOrder(order);
        assertEquals(15.0, order.getPrice(), 0.001);
        assertEquals("TAKEAWAY", order.getType());
    }

    @Test
    void deliveryOrder_prepare_delegatesToKitchen() {
        KitchenService kitchen = Mockito.mock(KitchenService.class);
        DeliveryOrderCreator creator = new DeliveryOrderCreator(kitchen, null);

        Order order = creator.createOrder("Calle Principal 123");
        order.addItem("Hamburguesa", 12.0);
        order.prepare();

        verify(kitchen, times(1)).prepareOrder(order);
        assertEquals(12.0, order.getPrice(), 0.001);
        assertEquals("DELIVERY", order.getType());
    }

    @Test
    void order_multipleItems_calculatesTotalPrice() {
        KitchenService kitchen = Mockito.mock(KitchenService.class);
        DineInOrderCreator creator = new DineInOrderCreator(kitchen);

        Order order = creator.createOrder("Mesa 2");
        order.addItem("Sopa", 5.0);
        order.addItem("Pollo", 15.0);
        order.addItem("Postre", 8.0);

        assertEquals(28.0, order.getPrice(), 0.001);
    }
}