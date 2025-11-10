package Creacionales.FactoryMethod.controlador;

import Creacionales.FactoryMethod.modelo.*;

public class OrderFactoryController {
    private final OrderCreator creator;

    public OrderFactoryController(OrderCreator creator) {
        this.creator = creator;
    }

    public Order placeOrder(String customerName) {
        Order o = creator.createOrder(customerName);
        o.addItem("Plato principal", 20.0);
        o.addItem("Bebida", 5.0);
        o.prepare();
        return o;
    }
}
