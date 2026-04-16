package mechanicshop.problemdomain;

/**
 * Represents an invoice generated from a service order.
 * Stores billing details and payment status.
 */
public class Invoice {

    private int invoiceId;
    private int serviceOrderId;   // links to ServiceOrder
    private double totalAmount;
    private String paymentStatus; // e.g., "UNPAID", "PAID"

    public Invoice(int invoiceId, int serviceOrderId, double totalAmount, String paymentStatus) {
        this.invoiceId = invoiceId;
        this.serviceOrderId = serviceOrderId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    // Getters
    public int getInvoiceId() { return invoiceId; }
    public int getServiceOrderId() { return serviceOrderId; }
    public double getTotalAmount() { return totalAmount; }
    public String getPaymentStatus() { return paymentStatus; }

    // Setters
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    @Override
    public String toString() {
        return "Invoice ID: " + invoiceId +
               "\nService Order ID: " + serviceOrderId +
               "\nTotal: $" + totalAmount +
               "\nStatus: " + paymentStatus;
    }
}
