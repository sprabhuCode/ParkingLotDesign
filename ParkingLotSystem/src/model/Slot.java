package model;

public class Slot {
	
	private int slotId;
	private boolean isOccupied;
	private  Vehicle vehicle;
	
	
	
	public Slot(int slotId) {
		super();
		this.slotId = slotId;
	}
	
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public boolean isOccupied() {
		return isOccupied;
	}
	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void occupySlot(Vehicle vehicle) {
		this.isOccupied = true;
		this.vehicle = vehicle;
	}
	
	public void vaccateSlot() {
		this.isOccupied = false;
		this.vehicle = null;
	}
	
	
	

}
