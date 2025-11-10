package Estructurales.Proxy.modelo;

public class Client {
    private final String name;
    private final KitchenService waiter;

    public Client(String name, KitchenService waiter) {
        this.name = name;
        this.waiter = waiter;
    }

    public void requestDish(String dish) {
        System.out.println("La cliente " + name + " solicita el plato: " + dish);
        waiter.prepareOrder(dish);
    }

    public String getName() { return name; }
}
