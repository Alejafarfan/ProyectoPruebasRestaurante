package Creacionales.Builder.vista;

import Creacionales.Builder.controlador.BuilderController;
import Creacionales.Builder.modelo.Dish;

import java.util.Scanner;

public class BuilderConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BuilderController controller = new BuilderController();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== SISTEMA DE COCINA (Builder) ===");
            System.out.println("1. Menú del día");
            System.out.println("2. Menú vegetariano");
            System.out.println("3. Menú gourmet");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt(); sc.nextLine();

            Dish dish = null;
            switch (opcion) {
                case 1 -> dish = controller.buildDish("dia");
                case 2 -> dish = controller.buildDish("vegetariano");
                case 3 -> dish = controller.buildDish("gourmet");
                case 4 -> continuar = false;
                default -> System.out.println("Opción inválida.");
            }

            if (dish != null) {
                System.out.println("\n" + dish);
            }
        }

        System.out.println("Cierre del sistema de cocina.");
    }
}
