package Junit.ChainOfResponsibility;

import Comportamentales.ChainOfResponsibility.modelo.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class ChainUnitTest {

    @Test
    void testWaiterHandlesOrder() {
        Waiter waiter = new Waiter("Laura", "Zona A");
        waiter.handle("order", "Pedido de jugo de mango");
    }

    @Test
    void testChefHandlesCookRequest() {
        Chef chef = new Chef("Andrés", "Italiana");
        chef.handle("cook", "Preparar pizza napolitana");
    }

    @Test
    void testWaiterPassesCookRequestToNextHandler() {
        Waiter waiter = new Waiter("Laura", "Zona A");
        Chef chef = mock(Chef.class);
        waiter.setNext(chef);

        waiter.handle("cook", "Preparar pasta carbonara");

        verify(chef).handle("cook", "Preparar pasta carbonara");
    }

    @Test
    void testChefDoesNotHandleOrder() {
        Chef chef = new Chef("Andrés", "Italiana");
        // Assuming Chef does not handle "order" type
        chef.handle("order", "Pedido de ensalada");
        // No exception should be thrown, and nothing should happen
    }

    @Test
    void testChainHandlesUnknownRequestGracefully() {
        Waiter waiter = new Waiter("Laura", "Zona A");
        Chef chef = new Chef("Andrés", "Italiana");
        waiter.setNext(chef);

        // Assuming neither handles "payment"
        waiter.handle("payment", "Pago con tarjeta");
        // No exception should be thrown, and nothing should happen
    }

    @Test
    void testFullChainHandlesOrderAndCook() {
        Waiter waiter = new Waiter("Laura", "Zona B");
        Chef chef = new Chef("Andrés", "Italiana");
        waiter.setNext(chef);

        // Waiter handles "order"
        waiter.handle("order", "Pedido de sopa de tomate");

        // Chef handles "cook"
        waiter.handle("cook", "Preparar lasaña");
    }
}
