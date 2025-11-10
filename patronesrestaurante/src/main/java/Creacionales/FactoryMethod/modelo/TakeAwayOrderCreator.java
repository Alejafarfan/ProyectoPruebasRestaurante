package Creacionales.FactoryMethod.modelo;

public class TakeAwayOrderCreator extends OrderCreator {
    private final KitchenService kitchen;
    private final String pickupCode;

    public TakeAwayOrderCreator(KitchenService kitchen, String pickupCode) {
        this.kitchen = kitchen;
        this.pickupCode = pickupCode;
    }

    @Override
    public Order createOrder(String name) {
        return new TakeAwayOrder(name, pickupCode, kitchen);
    }
}
