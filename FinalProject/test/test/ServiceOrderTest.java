package test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import manager.ServiceOrderManager;
import model.ServiceOrder;

class ServiceOrderTest {

    static ServiceOrderManager som;

    @BeforeAll
    static void setUpBeforeClass() {
        som = new ServiceOrderManager();
    }

    @Test
    void testAddServiceOrder() {
        ServiceOrder order = new ServiceOrder(
                  // orderId
                0, 
                  // customerId 
                1, 
                  // vehicleId 
                1,      
                "Oil change and inspection",
                150.0,
                "PENDING" );

        assertDoesNotThrow(() -> {
            som.addServiceOrder(order); });
    }

    @Test
    void testGetAllServiceOrders() {
        assertDoesNotThrow(() -> {
            som.getAllServiceOrders(); });
    }

    @Test
    void testUpdateServiceOrder() {
        ServiceOrder order = new ServiceOrder(
               // existing orderId 
                1,      
                1,
                1,
                "Updated description",
                200.0,
                "IN_PROGRESS" );

        assertDoesNotThrow(() -> {
            som.updateServiceOrder(order);  });
    }

    @Test
    void testUpdateStatus() {
        assertDoesNotThrow(() -> {
            som.updateStatus(1, "COMPLETED");  });
    }

    @Test
    void testDeleteServiceOrder() {
        assertDoesNotThrow(() -> {
            som.deleteServiceOrder(1);  });
    }
}
