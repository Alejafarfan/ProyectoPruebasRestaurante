package Creacionales.FactoryMethod.modelo;

public class DeliveryOrderCreator extends OrderCreator {
    private final KitchenService kitchen;
    private final String address;

    public DeliveryOrderCreator(KitchenService kitchen, String address) {
        this.kitchen = kitchen;
        this.address = address;
    }

    @Override
    public Order createOrder(String name) {
        return new DeliveryOrder(name, address, kitchen);
    }
}
