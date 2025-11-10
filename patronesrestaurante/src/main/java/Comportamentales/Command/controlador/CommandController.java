package Comportamentales.Command.controlador;

import Comportamentales.Command.modelo.*;

public class CommandController {

    private final OrderSystem system;
    private final Cashier cashier;

    public CommandController() {
        this.system = new OrderSystem();
        this.cashier = new Cashier("Laura");
    }

    public void clienteSolicita(String action, String order) {
        Client client = new Client("Lucía");
        client.requestAction(action, order, cashier, system);
    }

    public OrderSystem getSystem() {
        return system;
    }
}
