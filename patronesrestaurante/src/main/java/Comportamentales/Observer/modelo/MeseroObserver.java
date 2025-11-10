package Comportamentales.Observer.modelo;

public class MeseroObserver implements Observer {
    private String nombre;

    public MeseroObserver(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Pedido pedido) {
        System.out.println("Mesero " + nombre + " notificado: " + pedido);
    }
}
