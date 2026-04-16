/**
 * 
 */
package manager;

import java.sql.*;

import model.Customer;

/**
 * 
 */
public class CustomerManager {
	
	public void addCustomer(Customer customer){
	    try (Connection conn = DBConnection.getConnection();
	            PreparedStatement pst = conn.prepareStatement(
	                "INSERT INTO customer (firstName, lastName, phone, email) VALUES (?, ?, ?, ?)")) {
	    	
	    		pst.setString(1, customer.getFirstName());
	        	pst.setString(2, customer.getLastName());
	    		pst.setString(3, customer.getPhone());
	    		pst.setString(4, customer.getEmail());

	           pst.executeUpdate();

	           System.out.println("Customer added successfully!");

	       } catch (SQLException e) {
	           System.out.println("Error adding customer");
	       }
	}
	
	public void getAllCustomer(Customer customer) {
		try {
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM customer";
			PreparedStatement pst = conn.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("customerId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				
				System.out.println(
						"ID: " + id +
						", Name: " + firstName + " " + lastName +
						", Phone: " + phone +
						", Email: " + email
					);
			}
			
			rs.close();
			pst.close();
			conn.close();
			
		}catch (SQLException e) {
			System.out.println("Error retrieving customers");
			
		}
	}//AllCustomers
	
	public void updateCustomer(Customer customer) {
		try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(
            "UPDATE customer SET firstName = ?, lastName = ?, phone = ?, email = ? WHERE customerId = ?"
         )) {
	        pst.setString(1, customer.getFirstName());
	        pst.setString(2, customer.getLastName());
	        pst.setString(3, customer.getPhone());
	        pst.setString(4, customer.getEmail());
	        pst.setInt(5, customer.getCustomerId());			
			
			pst.executeUpdate();
			
			System.out.println("Customer updated successfully!");
			
		}catch(SQLException e){
			System.out.println("Error updating customer");
			
		}
	}

	
	public void deleteCustomer(Customer customer) {
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement pst = conn.prepareStatement(
	                 "DELETE FROM customer WHERE customerId = ?"
	         )) {

	        pst.setInt(1, customer.getCustomerId());

	        int count = pst.executeUpdate();

	        if (count == 0)
	            System.out.println("No customer found with ID " + customer.getCustomerId());
	        else
	            System.out.println("Customer record deleted");

	    } catch (SQLException e) {
	        System.out.println("Error while deleting customer");
	    }
	}
	
  
}
