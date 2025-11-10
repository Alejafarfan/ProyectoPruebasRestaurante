package Creacionales.Singleton.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static Inventory instance;
    private String restaurantName;
    private int minimumLevel;
    private final List<ProductoInventario> productos = new ArrayList<>();

    private Inventory() {
        this.restaurantName = "Restaurante Pikaikukuta";
        this.minimumLevel = 5;
        inicializarInventario();
    }

    private void inicializarInventario() {
        productos.add(new ProductoInventario("Arroz", 50));
        productos.add(new ProductoInventario("Aceite", 20));
        productos.add(new ProductoInventario("Leche", 30));
    }

    public static synchronized Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void registerEntry(String nombre, int cantidad) {
        ProductoInventario producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + cantidad);
        } else {
            productos.add(new ProductoInventario(nombre, cantidad));
        }
    }

    public boolean registerExit(String nombre, int cantidad) {
        ProductoInventario producto = buscarProducto(nombre);
        if (producto != null && producto.getCantidad() >= cantidad) {
            producto.setCantidad(producto.getCantidad() - cantidad);
            return true;
        }
        return false;
    }

    private ProductoInventario buscarProducto(String nombre) {
        for (ProductoInventario p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public List<ProductoInventario> getProductos() {
        return new ArrayList<>(productos);
    }

    public void showInventory() {
        System.out.println("\n=== INVENTARIO ===");
        for (ProductoInventario p : productos) {
            System.out.println(p);
        }
    }

    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }
    public int getMinimumLevel() { return minimumLevel; }
    public void setMinimumLevel(int minimumLevel) { this.minimumLevel = minimumLevel; }
}
