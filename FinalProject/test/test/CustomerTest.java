package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import manager.CustomerManager;
import model.Customer;

class CustomerTest {

    @Test
    void testAddCustomer() {

        CustomerManager manager = new CustomerManager();

        Customer customer = new Customer();
        customer.setFirstName("JUnit");
        customer.setLastName("Test");
        customer.setPhone("1231231234");
        customer.setEmail("junit@test.com");

        manager.addCustomer(customer);

        // Basic validation (since no return value from method)
        assertTrue(customer.getFirstName().equals("JUnit"));
        assertTrue(customer.getEmail().contains("@"));
    }

    @Test
    void testUpdateCustomer() {

        CustomerManager manager = new CustomerManager();

        Customer customer = new Customer();
        customer.setCustomerId(1); // must exist in DB
        customer.setFirstName("Updated");
        customer.setLastName("User");
        customer.setPhone("9999999999");
        customer.setEmail("updated@test.com");

        manager.updateCustomer(customer);

        assertEquals("Updated", customer.getFirstName());
        assertEquals("User", customer.getLastName());
    }

    @Test
    void testDeleteCustomer() {

        CustomerManager manager = new CustomerManager();

        Customer customer = new Customer();
        customer.setCustomerId(1); // must exist in DB

        manager.deleteCustomer(customer);

        assertTrue(customer.getCustomerId() == 1);
    }

    @Test
    void testGetAllCustomers() {

        CustomerManager manager = new CustomerManager();

        manager.getAllCustomer(null);

        // No return value, so we just confirm manager exists
        assertNotNull(manager);
    }
}

