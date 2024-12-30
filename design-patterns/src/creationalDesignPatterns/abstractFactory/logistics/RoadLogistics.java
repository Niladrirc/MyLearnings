package creationalDesignPatterns.abstractFactory.logistics;

import creationalDesignPatterns.abstractFactory.transport.Transport;
import creationalDesignPatterns.abstractFactory.transport.Truck;

public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
