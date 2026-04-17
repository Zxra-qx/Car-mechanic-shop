package manager;

import java.sql.*;
import model.ServiceOrder;

public class ServiceOrderManager {

    // creating
    public void addServiceOrder(ServiceOrder order) {
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
            System.out.println("Error creating service order"); }
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
            System.out.println("Error retrieving service orders"); }
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
            System.out.println("Error updating service order"); }
    }

    // updating only the status
    public void updateStatus(int orderId, String newStatus) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(
                "UPDATE service_order SET status = ? WHERE orderId = ?"
             )) {

            pst.setString(1, newStatus);
            pst.setInt(2, orderId);

            pst.executeUpdate();
            System.out.println("Status updated!");

        } catch (SQLException e) {
            System.out.println("Error updating status"); }
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
            System.out.println("Error deleting service order"); }
    }
}
