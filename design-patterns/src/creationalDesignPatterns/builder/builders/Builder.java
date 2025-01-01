package creationalDesignPatterns.builder.builders;

import creationalDesignPatterns.builder.cars.CarType;
import creationalDesignPatterns.builder.components.Engine;
import creationalDesignPatterns.builder.components.GPSNavigator;
import creationalDesignPatterns.builder.components.Transmission;
import creationalDesignPatterns.builder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
