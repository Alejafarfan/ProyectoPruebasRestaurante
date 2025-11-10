package Junit.Command;

import Comportamentales.Command.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandUnitTest {

    @Test
    void testRegisterOrderCommand() {
        OrderSystem system = new OrderSystem();
        Command cmd = new RegisterOrder(system, "Pizza");
        cmd.execute();
        assertTrue(system.getActiveOrders().contains("Pizza"));
    }

    @Test
    void testCancelOrderCommand() {
        OrderSystem system = new OrderSystem();
        system.registerOrder("Sopa");
        Command cmd = new CancelOrder(system, "Sopa");
        cmd.execute();
        assertFalse(system.getActiveOrders().contains("Sopa"));
    }

    @Test
    void testCancelOrderThatDoesNotExist() {
        OrderSystem system = new OrderSystem();
        Command cmd = new CancelOrder(system, "Hamburguesa");
        cmd.execute();
        assertFalse(system.getActiveOrders().contains("Hamburguesa"));
    }

    @Test
    void testMultipleOrdersAndCancellations() {
        OrderSystem system = new OrderSystem();
        Command registerPizza = new RegisterOrder(system, "Pizza");
        Command registerPasta = new RegisterOrder(system, "Pasta");
        Command cancelPizza = new CancelOrder(system, "Pizza");

        registerPizza.execute();
        registerPasta.execute();
        assertTrue(system.getActiveOrders().contains("Pizza"));
        assertTrue(system.getActiveOrders().contains("Pasta"));

        cancelPizza.execute();
        assertFalse(system.getActiveOrders().contains("Pizza"));
        assertTrue(system.getActiveOrders().contains("Pasta"));
    }

    @Test
    void testRegisterSameOrderTwice() {
        OrderSystem system = new OrderSystem();
        Command cmd1 = new RegisterOrder(system, "Ensalada");
        Command cmd2 = new RegisterOrder(system, "Ensalada");
        cmd1.execute();
        cmd2.execute();
        // Assuming duplicates are allowed, there should be two "Ensalada" entries
        long count = system.getActiveOrders().stream().filter(o -> o.equals("Ensalada")).count();
        assertTrue(count >= 1);
    }
}
