package controller;

import costStrategy.ParkingCostStrategy;
import exception.InvalidVehicleException;
import exception.ParkingException;
import model.Ticket;
import model.Vehicle;

public interface ParkingVehicle {
	
	public Ticket park(Vehicle vehicle) throws ParkingException;
	
	public int unPark(Ticket ticket, ParkingCostStrategy costStrategy) throws InvalidVehicleException;

}
