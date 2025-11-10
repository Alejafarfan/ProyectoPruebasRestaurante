package Estructurales.Adapter.modelo;

public class Client {
    private final String name;
    private final PayMethodInterface payService;

    public Client(String name, PayMethodInterface payService) {
        this.name = name;
        this.payService = payService;
    }

    public boolean payMethod(double amount) {
        System.out.println("\nCliente " + name + " inicia el pago...");
        return payService.payMethod(amount);
    }
}
