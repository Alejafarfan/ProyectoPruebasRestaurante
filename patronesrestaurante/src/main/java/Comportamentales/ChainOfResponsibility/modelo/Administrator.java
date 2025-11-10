package Comportamentales.ChainOfResponsibility.modelo;

public class Administrator extends BaseHandler {
    private final String name;
    private final String shift;

    public Administrator(String name, String shift) {
        this.name = name;
        this.shift = shift;
    }

    @Override
    public void handle(String type, String detail) {
        if (type.equalsIgnoreCase("admin")) {
            System.out.println("Administrador " + name + " (turno: " + shift + ") maneja solicitud: " + detail);
        } else {
            System.out.println("Solicitud no reconocida: " + detail);
        }
    }

    @Override
    public String toString() {
        return "Administrator{" + "name='" + name + "', shift='" + shift + "'}";
    }
}
