package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Vehicle;

public class VehicleManager {
		public void addVehicle(Vehicle vehicle) {
			try (Connection conn = DBConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(
						"INSERT INTO vehicle (customerId, make, model, year) VALUES (?, ?, ?, ?)")) {
				pst.setInt(1, vehicle.getCustomerId());
				pst.setString(2, vehicle.getMake());
				pst.setString(2, vehicle.getModel());
				pst.setInt(2, vehicle.getYear());
						
				pst.executeUpdate();
				
				System.out.println("Vehicle added successfully");
				
			}catch(SQLException e) {
				System.out.println("Error adding vehicle");
			}
		}//addVehicle

		public void getAllVehicles() {
			try {
		        Connection conn = DBConnection.getConnection();

		        String sql = "SELECT * FROM vehicle";
		        PreparedStatement pst = conn.prepareStatement(sql);

		        ResultSet rs = pst.executeQuery();

		        while (rs.next()) {

		            int vehicleId = rs.getInt("vehicleId");
		            int customerId = rs.getInt("customerId");
		            String make = rs.getString("make");
		            String model = rs.getString("model");
		            int year = rs.getInt("year");

		            System.out.println(
		                "Vehicle ID: " + vehicleId +
		                ", Customer ID: " + customerId +
		                ", Make: " + make +
		                ", Model: " + model +
		                ", Year: " + year
		            );
		        }

		        rs.close();
		        pst.close();
		        conn.close();

		    } catch (SQLException e) {
		        System.out.println("Error retrieving vehicles");
		    }
		}//getVehicle
		
		public void updateVehicle(Vehicle vehicle) {

		    try (Connection conn = DBConnection.getConnection();
		         PreparedStatement pst = conn.prepareStatement(
		            "UPDATE vehicle SET make = ?, model = ?, year = ?, customerId = ? WHERE vehicleId = ?"
		         )) {

		        pst.setString(1, vehicle.getMake());
		        pst.setString(2, vehicle.getModel());
		        pst.setInt(3, vehicle.getYear());
		        pst.setInt(4, vehicle.getCustomerId());
		        pst.setInt(5, vehicle.getVehicleId());

		        pst.executeUpdate();

		        System.out.println("Vehicle updated successfully!");

		    } catch (SQLException e) {
		        System.out.println("Error updating vehicle");

		    }
		}
		
		
		public void deleteVehicle(int vehicleId) {

		    try (Connection conn = DBConnection.getConnection();
		         PreparedStatement pst = conn.prepareStatement(
		            "DELETE FROM vehicle WHERE vehicle_id = ?"
		         )) {

		        pst.setInt(1, vehicleId);

		        pst.executeUpdate();

		        System.out.println("Vehicle deleted successfully!");

		    } catch (SQLException e) {
		        System.out.println("Error deleting vehicle");
		    }
		}

	}//end

