package parkingLot.parkingSpot;

public abstract class Vehicle {

    private final String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    protected abstract VehicleType getVehicleType();

    public String getVehicleRegistrationNumber() {
        return this.registrationNumber;
    }
}
