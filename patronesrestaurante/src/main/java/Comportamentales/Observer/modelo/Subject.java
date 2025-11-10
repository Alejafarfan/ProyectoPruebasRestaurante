package Comportamentales.Observer.modelo;

public interface Subject {
    void agregarObservador(Observer obs);
    void eliminarObservador(Observer obs);
    void notificarObservadores();
}
