package parkingLot.parkingSpot;

public class ElectricCarSpot extends ParkingSpot {

    private static final String PARKING_SPOT_TYPE = "Electric Car Spot";

    public ElectricCarSpot(String parkingSpotId) {
        super(parkingSpotId, PARKING_SPOT_TYPE);
    }

    @Override
    public String getParkingSpotType() {
        return PARKING_SPOT_TYPE;
    }
}
