package e2e.Singleton;

import Creacionales.Singleton.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryE2ETest {

    @Test
    void adminAddsAndKitchenConsumesSuccessfully() {
        Administrator admin = new Administrator("Lucía");
        Kitchen kitchen = new Kitchen("Chef Laura");

        admin.addStock("Huevos", 20);
        kitchen.requestIngredient("Huevos", 10);

        Inventory inv = Inventory.getInstance();
        boolean exists = inv.getProductos().stream()
                .anyMatch(p -> p.getNombre().equals("Huevos") && p.getCantidad() >= 0);

        assertTrue(exists);
    }
}

