package Creacionales.FactoryMethod.modelo;

import java.util.ArrayList;
import java.util.List;

public class TakeAwayOrder implements Order {
    private final String name;
    private final String pickupCode;
    private final List<String> items = new ArrayList<>();
    private double total = 0.0;
    private final KitchenService kitchen;

    public TakeAwayOrder(String name, String pickupCode, KitchenService kitchen) {
        this.name = name;
        this.pickupCode = pickupCode;
        this.kitchen = kitchen;
    }

    @Override
    public String getName() { return name + " (pickup " + pickupCode + ")"; }

    @Override
    public double getPrice() { return total; }

    @Override
    public String getType() { return "TAKEAWAY"; }

    @Override
    public void prepare() { kitchen.prepareOrder(this); }

    @Override
    public void deliver() {
        System.out.println("Order ready for pickup. Code: " + pickupCode);
    }

    @Override
    public void addItem(String name, double price) {
        items.add(name);
        total += price;
    }

    @Override
    public List<String> getItems() { return new ArrayList<>(items); }

    @Override
    public String toString() {
        return "TakeAwayOrder{" + "name='" + name + '\'' + ", pickupCode='" + pickupCode + '\'' + ", total=" + total + '}';
    }
}
