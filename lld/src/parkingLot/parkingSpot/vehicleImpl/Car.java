package parkingLot.parkingSpot.vehicleImpl;

import parkingLot.parkingSpot.Vehicle;
import parkingLot.parkingSpot.VehicleType;

public class Car extends Vehicle {

    public Car(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }
}
