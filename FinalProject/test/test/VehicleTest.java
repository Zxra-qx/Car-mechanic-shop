package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import manager.VehicleManager;
import model.Vehicle;

class VehicleTest {

    static VehicleManager vm;

    @BeforeAll
    static void setUpBeforeClass() {
        vm = new VehicleManager();
    }

    @Test
    void testAddVehicle() {

        Vehicle v = new Vehicle(1, 2,"Toyota", "Corolla", 2020);

        assertDoesNotThrow(() -> {
            vm.addVehicle(v);
        });
    }

    @Test
    void testGetAllVehicles() {

        assertDoesNotThrow(() -> {
            vm.getAllVehicles();
        });
    }

    @Test
    void testUpdateVehicle() {

        Vehicle v = new Vehicle(1, 5, "Honda", "Civic", 2022);
        v.setVehicleId(1); // must exist in DB

        assertDoesNotThrow(() -> {
            vm.updateVehicle(v);
        });
    }

    @Test
    void testDeleteVehicle() {

        assertDoesNotThrow(() -> {
            vm.deleteVehicle(1); // must exist in DB
        });
    }

}

