package Estructurales.Adapter.vista;

import Estructurales.Adapter.controlador.AdapterController;
import java.util.Scanner;

public class AdapterConsole {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdapterController controller = new AdapterController();

        System.out.println("=== PATRÓN ADAPTER - SISTEMA DE PAGOS ===");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Realizar pago");
            System.out.println("2. Ver historial de pagos");
            System.out.println("3. Simular múltiples pagos (automático)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Ingrese nombre del cliente: ");
                    String cliente = sc.nextLine();

                    System.out.print("Ingrese el monto a pagar: ");
                    double monto;
                    try {
                        monto = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Monto inválido. Intente nuevamente.");
                        continue;
                    }

                    System.out.println("\nSeleccione método de pago:");
                    System.out.println("1. Transferencia bancaria");
                    System.out.println("2. Tarjeta de crédito");
                    System.out.println("3. Efectivo");
                    System.out.print("Opción: ");
                    String metodoOpcion = sc.nextLine();

                    String metodo = switch (metodoOpcion) {
                        case "1" -> "transferencia";
                        case "2" -> "tarjeta";
                        case "3" -> "efectivo";
                        default -> "desconocido";
                    };

                    System.out.println("\nProcesando pago...");
                    boolean exito = controller.realizarPago(cliente, monto, metodo);

                    if (exito) {
                        System.out.println("Pago realizado correctamente por " + metodo);
                    } else {
                        System.out.println("Error al procesar el pago con " + metodo);
                    }
                }

                case "2" -> controller.mostrarHistorial();

                case "3" -> {
                    System.out.println("\nSimulando pagos automáticos...");
                    controller.ejecutarPagos();
                }

                case "4" -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema de pagos...");
                }

                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

            if (continuar) {
                System.out.println("\nPresione ENTER para continuar...");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
