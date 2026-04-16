package model;

public class Vehicle{
	private int vehicleId;
	private int customerId;
	private String make;
	private String model;
	private int year;
	
	public Vehicle(int vehicleId, int customerId, String make, String model, int year) {
		this.setVehicleId(vehicleId);
		this.setCustomerId(customerId);
		this.setMake(make);
		this.setModel(model);
		this.setYear(year);
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		   return "Vehicle ID: " + vehicleId +
		           ", Customer ID: " + customerId +
		           ", Make: " + make +
		           ", Model: " + model +
		           ", Year: " + year;
	}
}
