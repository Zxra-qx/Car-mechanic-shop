package manager;

import java.sql.*;
import model.ServiceOrder;

public class ServiceOrderManager {
    
    // checking if the customer exists
    private boolean customerExists(int customerId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(
                 "SELECT customerId FROM customer WHERE customerId = ?"
             )) {

            pst.setInt(1, customerId);
            ResultSet rs = pst.executeQuery();
            boolean exists = rs.next();
            rs.close();
            return exists;

        } catch (SQLException e) {
            System.out.println("Error checking customer.");
            return false; }
    }

    // checking if the vehicle belongs to the customer
    private boolean vehicleBelongsToCustomer(int vehicleId, int customerId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(
                 "SELECT vehicleId FROM vehicle WHERE vehicleId = ? AND customerId = ?"
             )) {

            pst.setInt(1, vehicleId);
            pst.setInt(2, customerId);
            ResultSet rs = pst.executeQuery();
            boolean valid = rs.next();
            rs.close();
            return valid;

        } catch (SQLException e) {
            System.out.println("Error checking vehicle ownership.");
            return false; }
    }

    // calculaing the cost
    public double calculateEstimate(double laborHours, double hourlyRate, double partsCost) {
        return (laborHours * hourlyRate) + partsCost; }

    // the status transition validation
    private boolean isValidStatusTransition(String currentStatus, String newStatus) {
        if (currentStatus.equals("PENDING") && newStatus.equals("IN_PROGRESS")) return true;
        if (currentStatus.equals("IN_PROGRESS") && newStatus.equals("COMPLETED")) return true;
        return false; 
    }

    // creating
    public void addServiceOrder(ServiceOrder order) {

        // validating the customer
        if (!customerExists(order.getCustomerId())) {
            System.out.println("Error: Customer does not exist.");
            return; }

        // validating that the vehicle belongs to the customer
        if (!vehicleBelongsToCustomer(order.getVehicleId(), order.getCustomerId())) {
            System.out.println("Error: Vehicle does not belong to this customer.");
            return; }

        // inserting into DB
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO service_order (customerId, vehicleId, description, costEstimate, status) VALUES (?, ?, ?, ?, ?)"
             )) {

            pst.setInt(1, order.getCustomerId());
            pst.setInt(2, order.getVehicleId());
            pst.setString(3, order.getDescription());
            pst.setDouble(4, order.getCostEstimate());
            pst.setString(5, order.getStatus());

            pst.executeUpdate();
            System.out.println("Service order created!");

        } catch (SQLException e) {
            System.out.println("Error creating service order.");
        }
    }

    // reading
    public void getAllServiceOrders() {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement("SELECT * FROM service_order");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("orderId");
                int customerId = rs.getInt("customerId");
                int vehicleId = rs.getInt("vehicleId");
                String description = rs.getString("description");
                double estimate = rs.getDouble("costEstimate");
                String status = rs.getString("status");

                System.out.println(
                    "Order ID: " + id +
                    ", Customer ID: " + customerId +
                    ", Vehicle ID: " + vehicleId +
                    ", Description: " + description +
                    ", Estimate: $" + estimate +
                    ", Status: " + status );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving service orders.");
        }
    }

    // updating
    public void updateServiceOrder(ServiceOrder order) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(
                "UPDATE service_order SET customerId = ?, vehicleId = ?, description = ?, costEstimate = ?, status = ? WHERE orderId = ?"
             )) {

            pst.setInt(1, order.getCustomerId());
            pst.setInt(2, order.getVehicleId());
            pst.setString(3, order.getDescription());
            pst.setDouble(4, order.getCostEstimate());
            pst.setString(5, order.getStatus());
            pst.setInt(6, order.getOrderId());

            pst.executeUpdate();
            System.out.println("Service order updated!");

        } catch (SQLException e) {
            System.out.println("Error updating service order."); }
    }

    //updating status with validation
    public void updateStatus(int orderId, String newStatus) {
        try (Connection conn = DBConnection.getConnection()) {

            // getting the current status
            PreparedStatement select = conn.prepareStatement(
                "SELECT status FROM service_order WHERE orderId = ?"
            );
            select.setInt(1, orderId);
            ResultSet rs = select.executeQuery();

            if (!rs.next()) {
                System.out.println("Service order not found.");
                return; }

            String currentStatus = rs.getString("status");

            // validating the transition
            if (!isValidStatusTransition(currentStatus, newStatus)) {
                System.out.println("Invalid status transition: " + currentStatus + " → " + newStatus);
                return;  }

            // updaing
            PreparedStatement update = conn.prepareStatement(
                "UPDATE service_order SET status = ? WHERE orderId = ?" );
            update.setString(1, newStatus);
            update.setInt(2, orderId);
            update.executeUpdate();

            System.out.println("Status updated!");

            rs.close();
            select.close();
            update.close();

        } catch (SQLException e) {
            System.out.println("Error updating status.");
        }
    }

        // deleting
    public void deleteServiceOrder(int orderId) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(
                "DELETE FROM service_order WHERE orderId = ?"
             )) {

            pst.setInt(1, orderId);
            pst.executeUpdate();

            System.out.println("Service order deleted!");

        } catch (SQLException e) {
            System.out.println("Error deleting service order.");
        }
    }
}
