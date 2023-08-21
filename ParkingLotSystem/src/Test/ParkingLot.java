package Test;

import controller.ParkingVehicleImpl;
import costStrategy.FourWheelerParkingStrategy;
import exception.InvalidVehicleException;
import exception.ParkingException;
import model.Ticket;
import model.Vehicle;
import model.VehicleType;

public class ParkingLot {

	public static void main(String[] args) throws ParkingException, InvalidVehicleException {
		// TODO Auto-generated method 
		ParkingVehicleImpl vehicleImpl = ParkingVehicleImpl.getParkingLot();
		vehicleImpl.initailizeParkingSlot(1, 2);
		
		Vehicle v1 = new Vehicle("KA123", VehicleType.TWO_WHEELER);
		Ticket t1 = vehicleImpl.park(v1);
		System.out.println(t1);
		
		Vehicle v2 = new Vehicle("KA345", VehicleType.FOUR_WHEELER);
		Ticket t2 = vehicleImpl.park(v2);
		System.out.println(t2);
		
		
//		Vehicle v3 = new Vehicle("KA123", VehicleType.TWO_WHEELER);
//		Ticket t3 = vehicleImpl.park(v3);
//		System.out.println(t3);
		
		vehicleImpl.unPark(t2, new FourWheelerParkingStrategy());
		
//		vehicleImpl.unPark(t3, new FourWheelerParkingStrategy());
		

	}

}
