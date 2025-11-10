package Comportamentales.Observer.modelo;

import java.util.ArrayList;
import java.util.List;

public class OrderNotifier implements Subject {
    private final List<Observer> observadores = new ArrayList<>();
    private Pedido pedidoActual;

    public void setPedido(Pedido pedido) {
        this.pedidoActual = pedido;
        notificarObservadores();
    }

    public Pedido getPedidoActual() {
        return pedidoActual;
    }

    @Override
    public void agregarObservador(Observer obs) {
        observadores.add(obs);
    }

    @Override
    public void eliminarObservador(Observer obs) {
        observadores.remove(obs);
    }

    @Override
    public void notificarObservadores() {
        for (Observer o : observadores) {
            o.actualizar(pedidoActual);
        }
    }
}
