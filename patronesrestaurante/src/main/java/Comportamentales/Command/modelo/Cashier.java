package Comportamentales.Command.modelo;

public class Cashier {
    private final String name;
    private Command command;

    public Cashier(String name) {
        this.name = name;
    }

    public void receiveCommand(String commandType, OrderSystem system, String details, double amount) {
        switch (commandType.toLowerCase()) {
            case "registrar" -> command = new RegisterOrder(system, details);
            case "cancelar" -> command = new CancelOrder(system, details);
            case "pagar" -> command = new ProcessPayment(system, amount);
            default -> System.out.println("Comando desconocido");
        }
    }

    public void executeCommand() {
        if (command != null) {
            System.out.println("La Cajera " + name + " Realiza la accion...");
            command.execute();
        } else {
            System.out.println("No hay comando asignado.");
        }
    }

    public Command getCommand() {
        return command;
    }
}
