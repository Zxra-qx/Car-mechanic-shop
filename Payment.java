package mechanicshop.problemdomain;

/**
 * Represents a payment made toward an invoice.
 * Helps separate billing and payment logic.
 */
public class Payment {

    private int paymentId;
    private int invoiceId;
    private double amount;

    public Payment(int paymentId, int invoiceId, double amount) {
        this.paymentId = paymentId;
        this.invoiceId = invoiceId;
        this.amount = amount;
    }

    public int getPaymentId() { return paymentId; }
    public int getInvoiceId() { return invoiceId; }
    public double getAmount() { return amount; }
}
