package Comportamentales.ChainOfResponsibility.modelo;

public interface RequestHandler {
    void setNext(RequestHandler handler);
    void handle(String type, String detail);
}
