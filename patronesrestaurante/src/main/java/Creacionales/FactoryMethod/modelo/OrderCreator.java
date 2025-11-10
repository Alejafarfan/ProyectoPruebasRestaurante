package Creacionales.FactoryMethod.modelo;

public abstract class OrderCreator {
    public abstract Order createOrder(String name);

    public Order createAndPrepare(String name) {
        Order order = createOrder(name);
        order.prepare();
        return order;
    }
}
