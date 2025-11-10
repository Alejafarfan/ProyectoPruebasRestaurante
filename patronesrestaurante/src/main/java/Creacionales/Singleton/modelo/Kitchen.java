package Creacionales.Singleton.modelo;

public class Kitchen {
    private final String chefName;

    public Kitchen(String chefName) {
        this.chefName = chefName;
    }

    public void requestIngredient(String nombre, int cantidad) {
        Inventory inv = Inventory.getInstance();
        boolean success = inv.registerExit(nombre, cantidad);
        if (success) {
            System.out.println(chefName + " tomó " + cantidad + " unidades de " + nombre);
        } else {
            System.out.println("No hay suficiente " + nombre + " en inventario.");
        }
    }
}
