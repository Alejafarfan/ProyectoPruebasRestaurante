package Comportamentales.Observer.modelo;

public class CajaObserver implements Observer {
    private String nombre;

    public CajaObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Caja " + nombre + " fue informada del cambio: " + pedido);
    }
}
