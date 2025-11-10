package Comportamentales.ChainOfResponsibility.controlador;

import Comportamentales.ChainOfResponsibility.modelo.*;

public class ChainController {

    private final Waiter waiter;
    private final Chef chef;
    private final Administrator admin;
    private final Client client;

    public ChainController() {
        waiter = new Waiter("Laura", "Zona A");
        chef = new Chef("Andrés", "Comida típica");
        admin = new Administrator("Lucía", "Tarde");

        // Cadena de responsabilidad: Waiter → Chef → Admin
        waiter.setNext(chef);
        chef.setNext(admin);

        client = new Client("Carlos", waiter);
    }

    public void ejecutarFlujo() {
        client.makeRequest("order", "Una bandeja paisa");
        client.makeRequest("cook", "Preparar la bandeja paisa");
        client.makeRequest("admin", "Registrar queja del cliente");
    }

    public Client getClient() {
        return client;
    }
}
