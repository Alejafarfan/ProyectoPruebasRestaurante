package Comportamentales.Observer.controlador;

import Comportamentales.Observer.modelo.*;

public class ObserverController {
    private final OrderNotifier notifier;

    private final CocinaObserver cocina;
    private final MeseroObserver mesero;
    private final CajaObserver caja;

    public ObserverController() {
        this.notifier = new OrderNotifier();
        this.cocina = new CocinaObserver("Principal");
        this.mesero = new MeseroObserver("Lucía");
        this.caja = new CajaObserver("Caja 1");

        notifier.agregarObservador(cocina);
        notifier.agregarObservador(mesero);
        notifier.agregarObservador(caja);
    }

    public void cambiarEstadoPedido(Pedido pedido, String nuevoEstado) {
        pedido.setEstado(nuevoEstado);
        notifier.setPedido(pedido);
    }

    public Pedido crearPedido(int id, String descripcion) {
        return new Pedido(id, descripcion);
    }
}
