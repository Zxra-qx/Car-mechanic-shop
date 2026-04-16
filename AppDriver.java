package mechanicshop.application;

import java.util.Scanner;
import mechanicshop.manager.InvoiceManager;
import mechanicshop.problemdomain.Invoice;

/**
 * Main application class.
 * Handles menu and connects all modules together.
 */
public class AppDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InvoiceManager manager = new InvoiceManager();

        int choice;

        do {
            System.out.println("\n--- Mechanic Shop Menu ---");
            System.out.println("1. Create Invoice");
            System.out.println("2. View Invoices");
            System.out.println("3. Update Payment Status");
            System.out.println("4. Delete Invoice");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Invoice ID: ");
                    int id = sc.nextInt();
                    System.out.print("Service Order ID: ");
                    int soId = sc.nextInt();
                    System.out.print("Total: ");
                    double total = sc.nextDouble();

                    manager.addInvoice(new Invoice(id, soId, total, "UNPAID"));
                    break;

                case 2:
                    manager.viewInvoices();
                    break;

                case 3:
                    System.out.print("Invoice ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Status (PAID/UNPAID): ");
                    String status = sc.nextLine();

                    manager.updatePaymentStatus(updateId, status);
                    break;

                case 4:
                    System.out.print("Invoice ID: ");
                    int deleteId = sc.nextInt();
                    manager.deleteInvoice(deleteId);
                    break;
            }

        } while (choice != 0);

        sc.close();
    }
}
