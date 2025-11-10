package Comportamentales.Command.modelo;

public class RegisterOrder implements Command {
    private final OrderSystem system;
    private final String details;

    public RegisterOrder(OrderSystem system, String details) {
        this.system = system;
        this.details = details;
    }

    @Override
    public void execute() {
        system.registerOrder(details);
    }
}


