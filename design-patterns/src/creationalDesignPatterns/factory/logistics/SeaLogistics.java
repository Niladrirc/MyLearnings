package creationalDesignPatterns.factory.logistics;

import creationalDesignPatterns.factory.transport.Ship;
import creationalDesignPatterns.factory.transport.Transport;

public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
