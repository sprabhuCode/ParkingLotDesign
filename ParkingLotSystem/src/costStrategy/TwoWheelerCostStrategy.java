package costStrategy;

public class TwoWheelerCostStrategy implements ParkingCostStrategy{

	@Override
	public int getCost(int parkingHours) {
		if(parkingHours<1)
			return 20;
		else
			
		return parkingHours*20;
	}

}
