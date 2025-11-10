package Comportamentales.State.modelo;

public class Pedido {
    private int id;
    private int mesa;
    private String descripcion;
    private EstadoPedido estadoActual;

    public Pedido(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estadoActual = new EstadoNuevo(); // Estado inicial
    }

    public void avanzarEstado() {
        estadoActual.avanzar(this);
    }

    public void setEstado(EstadoPedido estado) {
        this.estadoActual = estado;
    }

    public String getDescripcion() { return descripcion; }
    public int getId() { return id; }
    public int getMesa() {return mesa;}
    public String getEstadoNombre() { return estadoActual.getNombreEstado(); }

    @Override
    public String toString() {
        return "Pedido #" + id + " [" + descripcion + "] - Estado: " + getEstadoNombre();
    }
}


