package Comportamentales.State.controlador;

import Comportamentales.State.modelo.*;

public class StateController {

    public Pedido crearPedido(int id, String descripcion) {
        return new Pedido(id, descripcion);
    }

    public void avanzarEstado(Pedido pedido) {
        pedido.avanzarEstado();
    }

    public boolean esPedidoCerrado(Pedido pedido) {
        return pedido.getEstadoNombre().equalsIgnoreCase("Cerrado");
    }

    public String obtenerEstado(Pedido pedido) {
    return pedido.getEstadoNombre();
}

}
