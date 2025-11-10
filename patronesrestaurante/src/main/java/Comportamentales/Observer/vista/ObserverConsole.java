package Comportamentales.Observer.vista;

import Comportamentales.Observer.controlador.ObserverController;
import Comportamentales.Observer.modelo.Pedido;

import java.util.Scanner;

public class ObserverConsole {
    public static void main(String[] args) {
        ObserverController controller = new ObserverController();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE NOTIFICACIONES DE PEDIDOS (Observer) ===");
        Pedido pedido = controller.crearPedido(1, "Bandeja Paisa");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEstado actual: " + pedido.getEstado());
            System.out.println("1. Marcar como 'En preparación'");
            System.out.println("2. Marcar como 'Listo'");
            System.out.println("3. Marcar como 'Entregado'");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> controller.cambiarEstadoPedido(pedido, "En preparación");
                case 2 -> controller.cambiarEstadoPedido(pedido, "Listo");
                case 3 -> controller.cambiarEstadoPedido(pedido, "Entregado");
                case 4 -> continuar = false;
                default -> System.out.println("Opción inválida");
            }
        }

        System.out.println("Saliendo del sistema Observer...");
    }
}
