package Creacionales.FactoryMethod.modelo;

import java.util.ArrayList;
import java.util.List;

public class DeliveryOrder implements Order {
    private final String name;
    private final String address;
    private final List<String> items = new ArrayList<>();
    private double total = 0.0;
    private final KitchenService kitchen;

    public DeliveryOrder(String name, String address, KitchenService kitchen) {
        this.name = name;
        this.address = address;
        this.kitchen = kitchen;
    }

    @Override
    public String getName() { return name + " (delivery to " + address + ")"; }

    @Override
    public double getPrice() { return total; }

    @Override
    public String getType() { return "DELIVERY"; }

    @Override
    public void prepare() { kitchen.prepareOrder(this); }

    @Override
    public void deliver() {
        System.out.println("Sending delivery to: " + address);
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
        return "DeliveryOrder{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", total=" + total + '}';
    }
}
