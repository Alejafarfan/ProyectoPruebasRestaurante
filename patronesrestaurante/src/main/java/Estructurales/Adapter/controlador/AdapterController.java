package Estructurales.Adapter.controlador;

import Estructurales.Adapter.modelo.AdapterPayMethod;
import java.util.ArrayList;
import java.util.List;

public class AdapterController {

    private final List<String> historial = new ArrayList<>();

    public boolean realizarPago(String cliente, double monto, String metodo) {
        AdapterPayMethod adapter = new AdapterPayMethod(null, null, null);
        boolean resultado = adapter.pagar(cliente, monto, metodo);

        // Registrar en historial
        String registro = String.format("%s - %s - $%.2f → %s",
                cliente,
                metodo.toUpperCase(),
                monto,
                resultado ? "APROBADO " : "RECHAZADO ");

        historial.add(registro);
        return resultado;
    }

    // Muestra el historial de pagos
    public void mostrarHistorial() {
        System.out.println("\nHISTORIAL DE PAGOS:");
        if (historial.isEmpty()) {
            System.out.println("Aún no hay pagos registrados.");
        } else {
            historial.forEach(System.out::println);
        }
    }

    public void ejecutarPagos() {
        System.out.println("\nSimulación de pagos automáticos iniciada...");

        realizarPago("Lucía", 30000, "tarjeta");
        realizarPago("Carlos", 15000, "efectivo");
        realizarPago("Ana", 50000, "transferencia");
        realizarPago("Pedro", 100000, "efectivo");
        realizarPago("María", 40000, "tarjeta");

        mostrarHistorial();
    }
}
