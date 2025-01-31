package parkingLot.parkingSpot;

public abstract class ParkingSpot {
    private final String parkingSpotId;
    private boolean isSpotAvailable;
    private Vehicle vehicle;
    private final String parkingSpotType;

    public ParkingSpot(String parkingSpotId, String parkingSpotType) {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
    }

    public boolean isSpotFree() {
        return isSpotAvailable;
    }

    public abstract String getParkingSpotType();

    public String getParkingSpotId() {
        return this.parkingSpotId;
    }

    public Vehicle getVehicleType() {
        return vehicle;
    }

    public void assignVehicleToSpot(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void vacateVehicleFromSpot() {
        isSpotAvailable = true;
    }
}
