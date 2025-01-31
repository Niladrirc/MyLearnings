package parkingLot.parkingSpot;

public class MotorcycleSpot extends ParkingSpot {

    private static final String PARKING_SPOT_TYPE = "Motorcycle Spot";

    public MotorcycleSpot(String parkingSpotId) {
        super(parkingSpotId, PARKING_SPOT_TYPE);
    }

    @Override
    public String getParkingSpotType() {
        return PARKING_SPOT_TYPE;
    }
}
