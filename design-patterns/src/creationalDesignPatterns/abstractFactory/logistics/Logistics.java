package creationalDesignPatterns.abstractFactory.logistics;

import creationalDesignPatterns.abstractFactory.transport.Transport;

public abstract class Logistics {
    public abstract Transport createTransport();
}
