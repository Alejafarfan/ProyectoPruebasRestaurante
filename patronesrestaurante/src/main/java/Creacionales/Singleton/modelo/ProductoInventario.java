package Creacionales.Singleton.modelo;

public class ProductoInventario {
    private String nombre;
    private int cantidad;

    public ProductoInventario(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return nombre + " - " + cantidad + " unidades";
    }
}
