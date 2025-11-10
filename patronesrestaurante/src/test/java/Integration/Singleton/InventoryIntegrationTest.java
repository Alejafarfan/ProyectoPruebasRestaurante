package Integration.Singleton;

import Creacionales.Singleton.controlador.InventoryController;
import Creacionales.Singleton.modelo.ProductoInventario;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InventoryIntegrationTest {

    @Test
    void testControllerReflectsSameInventoryInstance() {
        InventoryController c1 = new InventoryController();
        InventoryController c2 = new InventoryController();

        c1.addProduct("Leche", 10);

        boolean found = c2.getInventoryStatus().stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase("Leche") && p.getCantidad() >= 10);

        assertTrue(found);
    }

    @Test
    void testAddProductInOneControllerIsVisibleInAnother() {
        InventoryController controllerA = new InventoryController();
        InventoryController controllerB = new InventoryController();

        controllerA.addProduct("Pan", 5);

        List<ProductoInventario> inventory = controllerB.getInventoryStatus();
        boolean found = inventory.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase("Pan") && p.getCantidad() == 5);

        assertTrue(found);
    }

    @Test
    void testProductQuantityIsUpdatedAcrossControllers() {
        InventoryController controllerA = new InventoryController();
        InventoryController controllerB = new InventoryController();

        controllerA.addProduct("Queso", 3);
        controllerB.addProduct("Queso", 2);

        int total = controllerA.getInventoryStatus().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase("Queso"))
                .mapToInt(ProductoInventario::getCantidad)
                .sum();

        assertEquals(5, total);
    }

    @Test
    void testInventoryIsInitiallyEmpty() {
        InventoryController controller = new InventoryController();
        List<ProductoInventario> inventory = controller.getInventoryStatus();
        // Assuming inventory is cleared between test runs
        assertTrue(inventory.isEmpty() || inventory.stream().allMatch(p -> p.getCantidad() == 0));
    }

    @Test
    void testAddMultipleProducts() {
        InventoryController controller = new InventoryController();

        controller.addProduct("Cafe", 7);
        controller.addProduct("Te", 4);

        List<ProductoInventario> inventory = controller.getInventoryStatus();

        boolean cafeFound = inventory.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase("Cafe") && p.getCantidad() == 7);
        boolean teFound = inventory.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase("Te") && p.getCantidad() == 4);

        assertTrue(cafeFound && teFound);
    }
}

