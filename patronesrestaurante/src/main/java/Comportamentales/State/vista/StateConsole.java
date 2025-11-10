package Comportamentales.State.vista;

import Comportamentales.State.controlador.StateController;
import Comportamentales.State.modelo.Pedido;

import java.util.Scanner;

public class StateConsole {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StateController controller = new StateController();

        boolean continuar = true;
        System.out.println("=== SISTEMA DE ESTADOS DE PEDIDOS (State) ===");

        while (continuar) {
            System.out.print("\nIngrese el ID del pedido: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Ingrese la descripción del pedido: ");
            String descripcion = sc.nextLine();

            Pedido pedido = controller.crearPedido(id, descripcion);
            System.out.println("\nPedido creado: " + pedido);

            while (!controller.esPedidoCerrado(pedido)) {
                System.out.println("\nPresione ENTER para avanzar al siguiente estado...");
                sc.nextLine();
                controller.avanzarEstado(pedido);
                System.out.println("" + pedido);
            }

            System.out.println("El pedido ha sido cerrado correctamente.");

            System.out.print("\n¿Desea gestionar otro pedido? (si/no): ");
            String respuesta = sc.nextLine().trim().toLowerCase();
            if (!respuesta.equals("si")) {
                continuar = false;
            }
        }

        System.out.println("\nSaliendo del sistema de estados...");
        sc.close();
    }
}
