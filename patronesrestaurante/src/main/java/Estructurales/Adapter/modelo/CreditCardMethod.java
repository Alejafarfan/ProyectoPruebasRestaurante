package Estructurales.Adapter.modelo;

public class CreditCardMethod {
    private final String cardHolderName;
    private final String cardNumber;
    private final String securityCode;
    private final int expirationMonth;
    private final int expirationYear;

    public CreditCardMethod(String cardHolderName, String cardNumber, String securityCode, int expirationMonth, int expirationYear) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public boolean makePay(double amount) {
        System.out.println("Procesando pago con tarjeta de " + cardHolderName);
        System.out.println("Monto: $" + amount + " - Tarjeta: ****" + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Transacción aprobada.");
        return true;
    }
}
