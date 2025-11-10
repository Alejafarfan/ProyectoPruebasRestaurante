package Comportamentales.Observer.modelo;

public class CocinaObserver implements Observer {
    private String nombre;

    public CocinaObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Cocina " + nombre + " recibió actualización: " + pedido);
    }
}
