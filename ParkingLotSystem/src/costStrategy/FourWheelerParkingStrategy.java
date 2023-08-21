package costStrategy;

public class FourWheelerParkingStrategy implements ParkingCostStrategy{

	@Override
	public int getCost(int parkingHours) {
		if(parkingHours<1)
			return 40;
		else
			
		return parkingHours*40;
	}

}
