package model;

public class ServiceOrder {

    private int orderId;
    private int customerId;
    private int vehicleId;
    private String description;
    private double costEstimate;
    private String status; 

    public ServiceOrder() {}

    public ServiceOrder(int orderId, int customerId, int vehicleId,
                        String description, double costEstimate, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.description = description;
        this.costEstimate = costEstimate;
        this.status = status; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getCostEstimate() { return costEstimate; }
    public void setCostEstimate(double costEstimate) { this.costEstimate = costEstimate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Service Order ID: " + orderId +
               ", Customer ID: " + customerId +
               ", Vehicle ID: " + vehicleId +
               ", Description: " + description +
               ", Estimate: $" + costEstimate +
               ", Status: " + status; }
}
