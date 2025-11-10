package Creacionales.FactoryMethod.modelo;

import java.util.ArrayList;
import java.util.List;

public class DineInOrder implements Order {
    private final String name;
    private final List<String> items = new ArrayList<>();
    private double total = 0.0;
    private final KitchenService kitchen;

    public DineInOrder(String name, KitchenService kitchen) {
        this.name = name;
        this.kitchen = kitchen;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getPrice() { return total; }

    @Override
    public String getType() { return "DINE_IN"; }

    @Override
    public void prepare() { kitchen.prepareOrder(this); }

    @Override
    public void deliver() {
        System.out.println("Delivering to table: " + name);
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
        return "DineInOrder{" + "name='" + name + '\'' + ", total=" + total + '}';
    }

}

