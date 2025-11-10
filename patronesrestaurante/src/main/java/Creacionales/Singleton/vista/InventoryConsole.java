package Creacionales.Singleton.vista;

import Creacionales.Singleton.controlador.InventoryController;
import Creacionales.Singleton.modelo.Administrator;
import Creacionales.Singleton.modelo.Kitchen;

import java.util.Scanner;

public class InventoryConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryController controller = new InventoryController();
        Administrator admin = new Administrator("Lucía");
        Kitchen kitchen = new Kitchen("Chef Carlos");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== SISTEMA DE INVENTARIO (Singleton sin Map) ===");
            System.out.println("1. Ver inventario");
            System.out.println("2. Agregar producto");
            System.out.println("3. Retirar producto (cocina)");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> admin.reviewInventory();
                case 2 -> {
                    System.out.print("Nombre producto: ");
                    String p = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int q = sc.nextInt(); sc.nextLine();
                    admin.addStock(p, q);
                }
                case 3 -> {
                    System.out.print("Ingrediente: ");
                    String p = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int q = sc.nextInt(); sc.nextLine();
                    kitchen.requestIngredient(p, q);
                }
                case 4 -> continuar = false;
                default -> System.out.println("Opción inválida.");
            }
        }
        System.out.println("Saliendo del sistema...");
    }
}

