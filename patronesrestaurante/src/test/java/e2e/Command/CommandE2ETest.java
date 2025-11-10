package e2e.Command;

import Comportamentales.Command.controlador.CommandController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CommandE2ETest {

    @Test
    void testFullFlowClientCashierSystem() {
        CommandController controller = new CommandController();

        controller.clienteSolicita("registrar", "Pasta");
        controller.clienteSolicita("pagar", "");
        controller.clienteSolicita("cancelar", "Pasta");

        assertEquals(20000, controller.getSystem().getTotalSales());
        assertFalse(controller.getSystem().getActiveOrders().contains("Pasta"));
    }

    @Test
    void testRegisterAddsOrderToActiveOrders() {
        CommandController controller = new CommandController();

        controller.clienteSolicita("registrar", "Burger");

        assertTrue(controller.getSystem().getActiveOrders().contains("Burger"));
    }

    @Test
    void testPayIncreasesTotalSales() {
        CommandController controller = new CommandController();

        long before = controller.getSystem().getTotalSales();
        controller.clienteSolicita("registrar", "Pasta");
        controller.clienteSolicita("pagar", "");

        long after = controller.getSystem().getTotalSales();
        assertTrue(after > before, "Total sales should increase after payment");
    }

    @Test
    void testCancelRemovesOrderAndDoesNotAddSalesIfNotPaid() {
        CommandController controller = new CommandController();

        controller.clienteSolicita("registrar", "Pasta");
        controller.clienteSolicita("cancelar", "Pasta");

        assertFalse(controller.getSystem().getActiveOrders().contains("Pasta"));
        assertEquals(0, controller.getSystem().getTotalSales());
    }

    @Test
    void testPayWithoutOrdersDoesNotChangeSystem() {
        CommandController controller = new CommandController();

        long before = controller.getSystem().getTotalSales();
        controller.clienteSolicita("pagar", "");
        long after = controller.getSystem().getTotalSales();

        assertEquals(before, after);
        assertTrue(controller.getSystem().getActiveOrders().isEmpty());
    }

    @Test
    void testMultipleRegistrationsAndCancelOne() {
        CommandController controller = new CommandController();

        controller.clienteSolicita("registrar", "Pasta");
        controller.clienteSolicita("registrar", "Burger");
        controller.clienteSolicita("cancelar", "Burger");

        assertThat(controller.getSystem().getActiveOrders())
            .contains("Pasta")
            .doesNotContain("Burger");
    }
}
