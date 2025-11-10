package Creacionales.Singleton.modelo;

public class Administrator {
    private final String name;

    public Administrator(String name) { this.name = name; }

    public void reviewInventory() {
        Inventory inv = Inventory.getInstance();
        System.out.println("Administrador " + name + " revisa el inventario de " + inv.getRestaurantName());
        inv.showInventory();
    }

    public void addStock(String nombre, int cantidad) {
        Inventory inv = Inventory.getInstance();
        inv.registerEntry(nombre, cantidad);
        System.out.println("Administrador " + name + " agregó " + cantidad + " unidades de " + nombre);
    }
}
