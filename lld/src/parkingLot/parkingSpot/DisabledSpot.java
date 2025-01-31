package parkingLot.parkingSpot;

public class DisabledSpot extends ParkingSpot {

    private static final String PARKING_SPOT_TYPE = "Disabled Spot";

    public DisabledSpot(String parkingSpotId) {
        super(parkingSpotId, PARKING_SPOT_TYPE);
    }

    @Override
    public String getParkingSpotType() {
        return PARKING_SPOT_TYPE;
    }
}
