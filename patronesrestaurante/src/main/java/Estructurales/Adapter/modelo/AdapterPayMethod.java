package Estructurales.Adapter.modelo;

import java.util.Date;

public class AdapterPayMethod implements PayMethodInterface {

    private final CreditCardMethod creditCard;
    private final CashMethod cash;
    private final TransferMethod transfer;

    public AdapterPayMethod(CreditCardMethod creditCard, CashMethod cash, TransferMethod transfer) {
        this.creditCard = creditCard;
        this.cash = cash;
        this.transfer = transfer;
    }

    @Override
    public boolean payMethod(double amount) {
        System.out.println("\nEjecutando método de pago...");
        boolean result = false;

        if (creditCard != null) {
            result = creditCard.makePay(amount);
        } else if (cash != null) {
            result = cash.cashPayAmount(amount);
        } else if (transfer != null) {
            result = transfer.transferCash(amount);
        } else {
            System.out.println("No hay método de pago disponible.");
        }

        return result;
    }

    // Métodos de fábrica para construir adaptadores específicos
    public static AdapterPayMethod withCreditCard(String holder, String number, String cvv, int month, int year) {
        return new AdapterPayMethod(new CreditCardMethod(holder, number, cvv, month, year), null, null);
    }

    public static AdapterPayMethod withCash(double received, double required, String transactionId) {
        return new AdapterPayMethod(null, new CashMethod(received, required, transactionId), null);
    }

    public static AdapterPayMethod withTransfer(String sender, String receiver, double amount, String id) {
        return new AdapterPayMethod(null, null, new TransferMethod(sender, receiver, amount, new Date(), id));
    }

    // 🔹 Aquí va la implementación real del método que te faltaba
    public boolean pagar(String cliente, double monto, String metodo) {
        metodo = metodo.toLowerCase().trim();

        System.out.println("\n=== Procesando pago del cliente: " + cliente + " ===");
        System.out.println("Método: " + metodo + " | Monto: $" + monto);

        boolean resultado = false;

        switch (metodo) {
            case "tarjeta" -> {
                AdapterPayMethod adapter = AdapterPayMethod.withCreditCard(
                        cliente, "4111111111111111", "123", 12, 2025);
                resultado = adapter.payMethod(monto);
            }
            case "efectivo" -> {
                AdapterPayMethod adapter = AdapterPayMethod.withCash(
                        monto, monto, "TX-" + System.currentTimeMillis());
                resultado = adapter.payMethod(monto);
            }
            case "transferencia" -> {
                AdapterPayMethod adapter = AdapterPayMethod.withTransfer(
                        "ACC-" + cliente, "ACC-RESTAURANTE", monto, "TRX-" + System.currentTimeMillis());
                resultado = adapter.payMethod(monto);
            }
            default -> {
                System.out.println("Método de pago no reconocido: " + metodo);
                resultado = false;
            }
        }

        if (resultado)
            System.out.println("Pago exitoso del cliente " + cliente);
        else
            System.out.println("Pago fallido para " + cliente);

        return resultado;
    }
}
