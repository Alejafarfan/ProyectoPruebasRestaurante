package Comportamentales.State.modelo;

public class EstadoListo extends EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EstadoEntregado());
    }

    @Override
    public String getNombreEstado() {
        return "Listo para servir";
    }
}
