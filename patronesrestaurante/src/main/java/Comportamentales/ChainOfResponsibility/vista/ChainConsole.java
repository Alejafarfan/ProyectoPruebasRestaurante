package Comportamentales.ChainOfResponsibility.vista;

import Comportamentales.ChainOfResponsibility.controlador.ChainController;

public class ChainConsole {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN CHAIN OF RESPONSIBILITY - SISTEMA DE PEDIDOS ===");
        ChainController controller = new ChainController();
        controller.ejecutarFlujo();
    }
}
