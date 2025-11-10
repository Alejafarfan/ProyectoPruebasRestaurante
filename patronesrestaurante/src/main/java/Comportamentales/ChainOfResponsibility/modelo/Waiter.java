package Comportamentales.ChainOfResponsibility.modelo;

public class Waiter extends BaseHandler {
    private final String name;
    private final String zone;

    public Waiter(String name, String zone) {
        this.name = name;
        this.zone = zone;
    }

    @Override
    public void handle(String type, String detail) {
        if (type.equalsIgnoreCase("order")) {
            System.out.println("Mesero " + name + " (zona " + zone + ") toma la orden: " + detail);
        } else {
            System.out.println("Mesero " + name + " no puede manejar '" + type + "', pasa al siguiente...");
            super.handle(type, detail);
        }
    }

    @Override
    public String toString() {
        return "Waiter{" + "name='" + name + "', zone='" + zone + "'}";
    }
}
