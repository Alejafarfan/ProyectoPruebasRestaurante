package Comportamentales.ChainOfResponsibility.modelo;

public class Chef extends BaseHandler {
    private final String name;
    private final String specialty;

    public Chef(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    @Override
    public void handle(String type, String detail) {
        if (type.equalsIgnoreCase("cook")) {
            System.out.println("Chef " + name + " (especialidad: " + specialty + ") prepara: " + detail);
        } else {
            System.out.println("Chef " + name + " no puede manejar '" + type + "', pasa al siguiente...");
            super.handle(type, detail);
        }
    }

    @Override
    public String toString() {
        return "Chef{" + "name='" + name + "', specialty='" + specialty + "'}";
    }
}
