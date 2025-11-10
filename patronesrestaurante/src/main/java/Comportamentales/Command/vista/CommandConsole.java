package Comportamentales.Command.vista;

import Comportamentales.Command.controlador.CommandController;
import java.util.Scanner;

public class CommandConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CommandController controller = new CommandController();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== SISTEMA DE COMANDOS DE PEDIDOS ===");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Cancelar pedido");
            System.out.println("3. Procesar pago");
            System.out.println("4. Ver estado del sistema");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Detalles del pedido: ");
                    String order = sc.nextLine();
                    controller.clienteSolicita("registrar", order);
                }
                case 2 -> {
                    System.out.print("Pedido a cancelar: ");
                    String order = sc.nextLine();
                    controller.clienteSolicita("cancelar", order);
                }
                case 3 -> controller.clienteSolicita("pagar", "");
                case 4 -> {
                    System.out.println("Pedidos activos: " + controller.getSystem().getActiveOrders());
                    System.out.println("Ventas totales: $" + controller.getSystem().getTotalSales());
                }
                case 5 -> continuar = false;
                default -> System.out.println("Opción inválida.");
            }
        }
        System.out.println("Cierre del sistema de comandos.");
    }
}

