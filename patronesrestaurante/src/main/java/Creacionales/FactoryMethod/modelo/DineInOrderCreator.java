package Creacionales.FactoryMethod.modelo;

public class DineInOrderCreator extends OrderCreator {
    private final KitchenService kitchen;

    public DineInOrderCreator(KitchenService kitchen) { this.kitchen = kitchen; }

    @Override
    public Order createOrder(String name) {
        return new DineInOrder(name, kitchen);
    }
}
