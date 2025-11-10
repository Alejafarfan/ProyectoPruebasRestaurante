package Estructurales.Adapter.modelo;

import java.util.Date;

public class TransferMethod {
    private final String senderAccountId;
    private final String receiverAccountId;
    private final double transferAmount;
    private final Date transferDate;
    private final String transactionId;

    public TransferMethod(String senderAccountId, String receiverAccountId, double transferAmount, Date transferDate, String transactionId) {
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.transferAmount = transferAmount;
        this.transferDate = transferDate;
        this.transactionId = transactionId;
    }

    public boolean transferCash(double amount) {
        System.out.println("Transferencia desde cuenta " + senderAccountId + " a " + receiverAccountId);
        System.out.println("Monto transferido: $" + transferAmount + " | Fecha: " + transferDate);
        System.out.println("Transferencia completada. ID Transacción: " + transactionId);
        return amount <= transferAmount;
    }
}
