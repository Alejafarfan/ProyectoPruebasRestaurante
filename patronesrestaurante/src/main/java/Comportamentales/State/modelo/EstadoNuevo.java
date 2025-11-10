package Comportamentales.State.modelo;

public class EstadoNuevo extends EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        pedido.setEstado(new EstadoPreparando());
    }

    @Override
    public String getNombreEstado() {
        return "Nuevo";
    }
}