package Estructurales.Adapter.modelo;

public class CashMethod {
    private final double receivedAmount;
    private final double requiredAmount;
    private final String cashTransactionId;

    public CashMethod(double receivedAmount, double requiredAmount, String cashTransactionId) {
        this.receivedAmount = receivedAmount;
        this.requiredAmount = requiredAmount;
        this.cashTransactionId = cashTransactionId;
    }

    public boolean cashPayAmount(double amount) {
        System.out.println("Pago en efectivo recibido: $" + receivedAmount);
        if (receivedAmount >= amount) {
            double change = receivedAmount - amount;
            System.out.println("Pago completado. Cambio: $" + change + " | Transacción #" + cashTransactionId);
            return true;
        } else {
            System.out.println("Fondos insuficientes. Faltan $" + (amount - receivedAmount));
            return false;
        }
    }
}
