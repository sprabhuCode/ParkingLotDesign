package model;

public class Vehicle {
	
	private String vehicleNo;
	private VehicleType type;
	
	
	public Vehicle(String vehicleNo, VehicleType type) {
		super();
		this.vehicleNo = vehicleNo;
		this.type = type;
	}
	
	
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Vehicle [vehicleNo=" + vehicleNo + ", type=" + type + "]";
	}
	
	

}
