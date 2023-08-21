package model;

import java.util.Date;

public class Ticket {
	
	private String vehicleNumber;
	private int slotId;
	private Date date;
	private VehicleType type;
	
	
	
	
	
	public Ticket(String vehicleNumber, int slotId, Date date, VehicleType type) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.slotId = slotId;
		this.date = date;
		this.type = type;
	}
	
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "Ticket [vehicleNumber=" + vehicleNumber + ", slotId=" + slotId + ", date=" + date + ", type=" + type
				+ "]";
	}
	
	

}
