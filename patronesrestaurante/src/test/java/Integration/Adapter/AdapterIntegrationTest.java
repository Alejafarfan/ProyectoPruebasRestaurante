package Integration.Adapter;

import Estructurales.Adapter.controlador.AdapterController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapterIntegrationTest {

    @Test
    void controladorDebeRegistrarPagoExitosoConTarjeta() {
        AdapterController controller = new AdapterController();
        boolean resultado = controller.realizarPago("Lucía", 25000, "tarjeta");
        assertTrue(resultado);
    }

    @Test
    void controladorDebeRegistrarPagoExitosoConTransferencia() {
        AdapterController controller = new AdapterController();
        boolean resultado = controller.realizarPago("Carlos", 40000, "transferencia");
        assertTrue(resultado);
    }

    @Test
    void controladorDebeRegistrarPagoExitosoConEfectivo() {
        AdapterController controller = new AdapterController();
        boolean resultado = controller.realizarPago("Ana", 18000, "efectivo");
        assertTrue(resultado);
    }

    @Test
    void controladorDebeRegistrarPagoFallidoParaMetodoDesconocido() {
        AdapterController controller = new AdapterController();
        boolean resultado = controller.realizarPago("Pedro", 10000, "bitcoin");
        assertFalse(resultado);
    }
}

