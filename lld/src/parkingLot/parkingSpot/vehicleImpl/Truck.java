package parkingLot.parkingSpot.vehicleImpl;

import parkingLot.parkingSpot.Vehicle;
import parkingLot.parkingSpot.VehicleType;

public class Truck extends Vehicle {

    public Truck(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.TRUCK;
    }
}
