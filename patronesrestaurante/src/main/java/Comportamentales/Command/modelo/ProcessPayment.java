package Comportamentales.Command.modelo;

public class ProcessPayment implements Command {
    private final OrderSystem system;
    private final double amount;

    public ProcessPayment(OrderSystem system, double amount) {
        this.system = system;
        this.amount = amount;
    }

    @Override
    public void execute() {
        system.processPayment(amount);
    }
}
