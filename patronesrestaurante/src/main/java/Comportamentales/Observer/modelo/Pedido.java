package Comportamentales.Observer.modelo;

public class Pedido {
    private int id;
    private String descripcion;
    private String estado;

    public Pedido(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = "Nuevo";
    }

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Pedido #" + id + " [" + descripcion + "] - Estado: " + estado;
    }

    public Integer getMesa() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMesa'");
    }
}
