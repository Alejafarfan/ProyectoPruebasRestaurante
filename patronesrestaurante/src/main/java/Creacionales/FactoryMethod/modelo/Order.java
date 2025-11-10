package Creacionales.FactoryMethod.modelo;

import java.util.List;

public interface Order {
    String getName();
    double getPrice();
    String getType();
    void prepare();
    void deliver();
    void addItem(String name, double price);
    List<String> getItems();
}

