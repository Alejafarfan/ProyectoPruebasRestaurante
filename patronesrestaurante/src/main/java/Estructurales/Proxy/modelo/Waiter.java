package Estructurales.Proxy.modelo;

public class Waiter implements KitchenService {
    private final String name;
    private final Kitchen kitchen;
    private String currentOrder;

    public Waiter(String name, Kitchen kitchen) {
        this.name = name;
        this.kitchen = kitchen;
    }

    public void takeOrder(String dish) {
        this.currentOrder = dish;
        System.out.println(" la Mesera " + name + " toma el pedido: " + dish);
        prepareOrder(dish);
    }

    public void deliverOrder(String dish) {
        System.out.println("la Mesera " + name + " entrega el plato: " + dish);
    }

    @Override
    public void prepareOrder(String dish) {
        System.out.println("la Mesera " + name + " pasa la orden a la cocina.");
        kitchen.prepareOrder(dish);
        deliverOrder(dish);
    }

    public String getCurrentOrder() { return currentOrder; }
}
