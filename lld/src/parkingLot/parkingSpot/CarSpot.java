package parkingLot.parkingSpot;

public class CarSpot extends ParkingSpot {

    private static final String PARKING_SPOT_TYPE = "Car Spot";

    public CarSpot(String parkingSpotId) {
        super(parkingSpotId, PARKING_SPOT_TYPE);
    }

    @Override
    public String getParkingSpotType() {
        return PARKING_SPOT_TYPE;
    }
}
