package Comportamentales.State.modelo;

public class EstadoEntregado extends EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EstadoCerrado());
    }

    @Override
    public String getNombreEstado() {
        return "Entregado";
    }
}