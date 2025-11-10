package Comportamentales.Command.modelo;

import java.util.ArrayList;
import java.util.List;

public class OrderSystem {
    private final List<String> activeOrders;
    private int totalSales;

    public OrderSystem() {
        this.activeOrders = new ArrayList<>();
        this.totalSales = 0;
    }

    public void registerOrder(String order) {
        activeOrders.add(order);
        System.out.println("Pedido registrado: " + order);
    }

    public void cancelOrder(String order) {
        if (activeOrders.remove(order)) {
            System.out.println("Pedido cancelado: " + order);
        } else {
            System.out.println("No se encontró el pedido: " + order);
        }
    }

    public void processPayment(double amount) {
        totalSales += amount;
        System.out.println("Pago procesado por $" + amount);
    }

    public List<String> getActiveOrders() {
        return new ArrayList<>(activeOrders);
    }

    public int getTotalSales() {
        return totalSales;
    }
}
