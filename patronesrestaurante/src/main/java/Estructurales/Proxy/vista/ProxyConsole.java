package Estructurales.Proxy.vista;

import Estructurales.Proxy.controlador.ProxyController;

public class ProxyConsole {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN PROXY - SISTEMA DE PEDIDOS===");
        ProxyController controller = new ProxyController();
        controller.ejecutarFlujo();
    }
}
