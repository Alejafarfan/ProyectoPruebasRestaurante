package Junit.Singleton;

import Creacionales.Singleton.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryUnitTest {

    @Test
    void singletonInstanceShouldBeUnique() {
        Inventory inv1 = Inventory.getInstance();
        Inventory inv2 = Inventory.getInstance();
        assertSame(inv1, inv2);
    }

    @Test
    void shouldRegisterEntryAndExitCorrectly() {
        Inventory inv = Inventory.getInstance();
        inv.registerEntry("Café", 10);
        assertTrue(inv.registerExit("Café", 5));
        assertFalse(inv.registerExit("Café", 1000)); // insuficiente
    }
}

