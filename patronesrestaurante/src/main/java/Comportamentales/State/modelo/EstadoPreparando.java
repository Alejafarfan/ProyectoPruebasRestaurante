package Comportamentales.State.modelo;

public class EstadoPreparando extends EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EstadoListo());
    }

    @Override
    public String getNombreEstado() {
        return "Preparando";
    }
}
