package parkingLot.parkingSpot.vehicleImpl;

import parkingLot.parkingSpot.Vehicle;
import parkingLot.parkingSpot.VehicleType;

public class ElectricCar extends Vehicle {

    public ElectricCar(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.ELECTRIC_CAR;
    }
}
