package Creacionales.Singleton.controlador;

import Creacionales.Singleton.modelo.*;

import java.util.List;

public class InventoryController {
    private final Inventory inventory = Inventory.getInstance();

    public void addProduct(String nombre, int cantidad) {
        inventory.registerEntry(nombre, cantidad);
    }

    public boolean removeProduct(String nombre, int cantidad) {
        return inventory.registerExit(nombre, cantidad);
    }

    public List<ProductoInventario> getInventoryStatus() {
        return inventory.getProductos();
    }

    public String getRestaurantName() {
        return inventory.getRestaurantName();
    }
}
