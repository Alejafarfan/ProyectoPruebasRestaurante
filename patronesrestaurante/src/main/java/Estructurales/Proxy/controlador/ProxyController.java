package Estructurales.Proxy.controlador;

import Estructurales.Proxy.modelo.*;

public class ProxyController {

    public void ejecutarFlujo() {
        Kitchen kitchen = new Kitchen("Pedro", 2, "Comida típica");
        Waiter waiter = new Waiter("Laura", kitchen);
        Client client = new Client("Lucía", waiter);

        client.requestDish("Bandeja paisa");
    }
}
