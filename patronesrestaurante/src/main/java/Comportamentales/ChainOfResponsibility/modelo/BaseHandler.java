package Comportamentales.ChainOfResponsibility.modelo;

public abstract class BaseHandler implements RequestHandler {
    protected RequestHandler next;

    @Override
    public void setNext(RequestHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(String type, String detail) {
        if (next != null) {
            next.handle(type, detail);
        } else {
            System.out.println("No se pudo manejar la solicitud: " + detail);
        }
    }
}
