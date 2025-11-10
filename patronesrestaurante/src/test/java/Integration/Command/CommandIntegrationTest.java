package Integration.Command;

import Comportamentales.Command.controlador.CommandController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandIntegrationTest {

    @Test
    void testClientInteractionThroughController() {
        CommandController controller = new CommandController();
        controller.clienteSolicita("registrar", "Arroz con pollo");
        assertTrue(controller.getSystem().getActiveOrders().contains("Arroz con pollo"));
    }

    @Test
    void testSystemStartsWithNoActiveOrders() {
        CommandController controller = new CommandController();
        assertThat(controller.getSystem().getActiveOrders()).isNotNull().isEmpty();
    }

    @Test
    void testRegisterMultipleOrders() {
        CommandController controller = new CommandController();
        controller.clienteSolicita("registrar", "Arroz con pollo");
        controller.clienteSolicita("registrar", "Lomo saltado");
        assertThat(controller.getSystem().getActiveOrders())
            .hasSize(2)
            .contains("Arroz con pollo", "Lomo saltado");
    }

    @Test
    void testRegisterSameOrderTwiceDoesNotCrashAndContainsItem() {
        CommandController controller = new CommandController();
        controller.clienteSolicita("registrar", "Ceviche");
        controller.clienteSolicita("registrar", "Ceviche");
        assertThat(controller.getSystem().getActiveOrders()).contains("Ceviche");
        assertThat(controller.getSystem().getActiveOrders().size()).isGreaterThanOrEqualTo(1);
    }
}
