package Comportamentales.State.modelo;


public class EstadoCerrado extends EstadoPedido {
    @Override
    public void avanzar(Pedido pedido) {
        System.out.println("El pedido ya está cerrado, no se puede avanzar más.");
    }

    @Override
    public String getNombreEstado() {
        return "Cerrado";
    }
}
