package Comportamentales.ChainOfResponsibility.modelo;

public class Client {
    private final String name;
    private final RequestHandler waiter;

    public Client(String name, RequestHandler waiter) {
        this.name = name;
        this.waiter = waiter;
    }

    public void makeRequest(String type, String detail) {
        System.out.println("\nCliente " + name + " hace una solicitud: " + type.toUpperCase() + " -> " + detail);
        waiter.handle(type, detail);
    }

    @Override
    public String toString() {
        return "Client{" + "name='" + name + "'}";
    }
}
