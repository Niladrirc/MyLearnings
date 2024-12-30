package creationalDesignPatterns.abstractFactory.logistics;

import creationalDesignPatterns.abstractFactory.transport.Ship;
import creationalDesignPatterns.abstractFactory.transport.Transport;

public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
