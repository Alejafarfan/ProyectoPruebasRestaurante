package Comportamentales.State.modelo;


public abstract class EstadoPedido {
    public abstract void avanzar(Pedido pedido);
    public abstract String getNombreEstado();
}
