package Comportamentales.Command.modelo;

public class Client {
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    public void requestAction(String command, String order, Cashier cashier, OrderSystem system) {
        System.out.println("Cliente " + name + " solicita: " + command + " pedido");
        switch (command.toLowerCase()) {
            case "registrar" -> cashier.receiveCommand("registrar", system, order, 0);
            case "cancelar" -> cashier.receiveCommand("cancelar", system, order, 0);
            case "pagar" -> cashier.receiveCommand("pagar", system, "", 20000);
            default -> System.out.println("Accion desconocida");
        }
        cashier.executeCommand();
    }
}
