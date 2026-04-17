CREATE TABLE service_order (
    orderId INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT NOT NULL,
    vehicleId INT NOT NULL,
    description VARCHAR(255),
    costEstimate DOUBLE,
    status VARCHAR(20),

    FOREIGN KEY (customerId) REFERENCES customer(customerId),
    FOREIGN KEY (vehicleId) REFERENCES vehicle(vehicleId));
