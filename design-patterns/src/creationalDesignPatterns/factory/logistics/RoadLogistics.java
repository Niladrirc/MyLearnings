package creationalDesignPatterns.factory.logistics;

import creationalDesignPatterns.factory.transport.Transport;
import creationalDesignPatterns.factory.transport.Truck;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
