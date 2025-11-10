package Junit.Adapter;

import Estructurales.Adapter.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdapterUnitTest {

    @Test
    void pagoConTarjetaDebeSerExitoso() {
        AdapterPayMethod adapter = AdapterPayMethod.withCreditCard(
                "Lucía", "4111111111111111", "123", 12, 2025);
        assertTrue(adapter.payMethod(30000));
    }

    @Test
    void pagoEnEfectivoDebeDarCambioCorrecto() {
        CashMethod cash = new CashMethod(50000, 30000, "TX-001");
        assertTrue(cash.cashPayAmount(30000));
    }

    @Test
    void pagoEnEfectivoDebeFallarSiNoHayFondos() {
        CashMethod cash = new CashMethod(10000, 20000, "TX-002");
        assertFalse(cash.cashPayAmount(20000));
    }

    @Test
    void transferenciaDebeSerExitosaSiMontoNoSuperaTransferAmount() {
        TransferMethod transfer = new TransferMethod(
                "ACC-LUCIA", "ACC-RESTAURANTE", 40000, new java.util.Date(), "TRX-01");
        assertTrue(transfer.transferCash(35000));
    }

    @Test
    void transferenciaDebeFallarSiMontoExcedeTransferAmount() {
        TransferMethod transfer = new TransferMethod(
                "ACC-LUCIA", "ACC-RESTAURANTE", 20000, new java.util.Date(), "TRX-02");
        assertFalse(transfer.transferCash(50000));
    }

    @Test
    void metodoPagarDebeRetornarTrueParaTarjeta() {
        AdapterPayMethod adapter = new AdapterPayMethod(null, null, null);
        assertTrue(adapter.pagar("Lucía", 15000, "tarjeta"));
    }
}
