package Creacionales.FactoryMethod.vista;

import Creacionales.FactoryMethod.controlador.OrderFactoryController;
import Creacionales.FactoryMethod.modelo.*;

import java.util.Scanner;

public class FactoryConsole {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KitchenService kitchen = order -> System.out.println("Preparando Pedido de: " + order.getName());
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Sistema de Pedidos (Factory Method) ===");
            System.out.println("1. Pedi1do en mesa");
            System.out.println("2. Pedido a domicilio");
            System.out.println("3. Pedido para llevar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            String input = sc.nextLine().trim();
            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
                continue;
            }

            if (option == 4) {
                continuar = false;
                System.out.println("Saliendo del sistema de pedidos...");
                break;
            }

            try {
                OrderCreator creator = switch (option) {
                    case 1 -> new DineInOrderCreator(kitchen);
                    case 2 -> {
                        System.out.print("Ingrese dirección de entrega: ");
                        String address = sc.nextLine();
                        yield new DeliveryOrderCreator(kitchen, address);
                    }
                    case 3 -> {
                        System.out.print("Ingrese código de retiro: ");
                        String code = sc.nextLine();
                        yield new TakeAwayOrderCreator(kitchen, code);
                    }
                    default -> {
                        System.out.println("Opción inválida, intente nuevamente.");
                        yield null;
                    }
                };

                if (creator == null) continue;

                OrderFactoryController controller = new OrderFactoryController(creator);

                System.out.print("Ingrese el nombre del cliente: ");
                String cliente = sc.nextLine();

                Order order = controller.placeOrder(cliente);
                order.deliver();

                System.out.println("\nOrden creada exitosamente:");
                System.out.println(order);
                System.out.println("Items: " + order.getItems());
                System.out.println("Total: $" + order.getPrice());

            } catch (Exception e) {
                System.out.println("Error al crear la orden: " + e.getMessage());
            }

            System.out.println("\nPresione ENTER para volver al menú...");
            sc.nextLine();
        }

        sc.close();
    }
}


