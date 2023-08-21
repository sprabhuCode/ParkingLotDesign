package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import costStrategy.ParkingCostStrategy;
import exception.InvalidVehicleException;
import exception.ParkingException;
import model.Slot;
import model.Ticket;
import model.Vehicle;
import model.VehicleType;

public class ParkingVehicleImpl implements ParkingVehicle{
	
	List<Slot> twoWheelerPark;
	List<Slot> fourWheelerPark;
	private static ParkingVehicleImpl vehicleImpl;
	
	private ParkingVehicleImpl() {
		this.twoWheelerPark = new ArrayList<>();
		this.fourWheelerPark = new ArrayList<>();
		
	};
	
	public static ParkingVehicleImpl getParkingLot() {
		if(vehicleImpl == null ) {
			vehicleImpl = new ParkingVehicleImpl();
		}
		return vehicleImpl;
	}
	
	public void initailizeParkingSlot(int twoWheeler, int fourWheeler) {
		for(int i=1;i<=twoWheeler;i++) {
			twoWheelerPark.add(new Slot(i));
		}
		
		System.out.printf("Created two wheeler parking lot with %s slots %n", twoWheeler);

		
		for(int i=1;i<=fourWheeler;i++) {
			fourWheelerPark.add(new Slot(i));
		}
		
		System.out.printf("Created four wheeler parking lot with %s slots %n", fourWheeler);
		
	}

	@Override
	public Ticket park(Vehicle vehicle) throws ParkingException {
		Slot availableSlot;
		
		if(vehicle.getType().equals(VehicleType.TWO_WHEELER)) {
			availableSlot = getNextAvailableTwoWheelerSlot();
		} else {
			availableSlot = getNextAvailableFourWheelerSlot();
		}
		
		availableSlot.occupySlot(vehicle);
		Ticket ticket = new Ticket(vehicle.getVehicleNo(), availableSlot.getSlotId(),new Date() , vehicle.getType());
		return ticket;
	}

	@Override
	public int unPark(Ticket ticket, ParkingCostStrategy costStrategy) throws InvalidVehicleException {
	
		Slot slot = getVehicle(ticket);
		if(slot==null)
			throw new InvalidVehicleException("Vehicle not found " + ticket.getVehicleNumber());
		
		slot.vaccateSlot();
		Date cur_Date = new Date();
		Date start_Date = ticket.getDate();
		long secs = (cur_Date.getTime() - start_Date.getTime()) / 1000;
		int hours = (int) (secs / 3600);
		int cost = costStrategy.getCost(hours);
		
		System.out.println("Vehicle " + ticket.getVehicleNumber() + " at slot number " + slot.getSlotId()
						+ " was parked for " + hours + " hours and the total charge is " + cost);
		return cost;
		
		
		
	}
	
	private Slot getNextAvailableTwoWheelerSlot() throws ParkingException {
		
		for(Slot slot : twoWheelerPark) {
			if(!slot.isOccupied()) {
				return slot;
			}
		}
		
		throw new ParkingException("No Available slots for 2 wheelers");
	}
	
private Slot getNextAvailableFourWheelerSlot() throws ParkingException {
		
		for(Slot slot : fourWheelerPark) {
			if(!slot.isOccupied()) {
				return slot;
			}
		}
		
		throw new ParkingException("No Available slots for 4 wheelers");
	}

	private Slot getVehicle(Ticket ticket) throws InvalidVehicleException {
		if(ticket.getType().equals(VehicleType.TWO_WHEELER)) {
			for(Slot slot : twoWheelerPark) {
				if(slot.getVehicle()!=null && slot.getVehicle().getVehicleNo().equals(ticket.getVehicleNumber())) {
					return slot;
				}
			}
		} else {
			for(Slot slot : fourWheelerPark) {
				if(slot.getVehicle()!=null && slot.getVehicle().getVehicleNo().equals(ticket.getVehicleNumber())) {
					return slot;
				}
			}
		}
		throw new InvalidVehicleException("Vehicle number " + ticket.getVehicleNumber() + "is not valid");
	}

}
