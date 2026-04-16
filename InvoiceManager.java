package mechanicshop.manager;

import java.util.ArrayList;
import mechanicshop.problemdomain.Invoice;

/**
 * Handles CRUD operations for invoices.
 */
public class InvoiceManager {

    private ArrayList<Invoice> invoices = new ArrayList<>();

    // CREATE
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
        System.out.println("Invoice created.");
    }

    // READ
    public void viewInvoices() {
        if (invoices.isEmpty()) {
            System.out.println("No invoices found.");
            return;
        }

        for (Invoice i : invoices) {
            System.out.println(i);
            System.out.println("-------------------");
        }
    }

    // UPDATE
    public void updatePaymentStatus(int invoiceId, String status) {
        for (Invoice i : invoices) {
            if (i.getInvoiceId() == invoiceId) {
                i.setPaymentStatus(status);
                System.out.println("Invoice updated.");
                return;
            }
        }
        System.out.println("Invoice not found.");
    }

    // DELETE
    public void deleteInvoice(int invoiceId) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getInvoiceId() == invoiceId) {
                invoices.remove(i);
                System.out.println("Invoice deleted.");
                return;
            }
        }
        System.out.println("Invoice not found.");
    }
}
