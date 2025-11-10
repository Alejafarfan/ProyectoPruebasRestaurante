package Comportamentales.Command.modelo;

public class CancelOrder implements Command {
    private final OrderSystem system;
    private final String orderId;

    public CancelOrder(OrderSystem system, String orderId) {
        this.system = system;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        system.cancelOrder(orderId);
    }
}
