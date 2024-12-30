package creationalDesignPatterns.abstractFactory.logistics;

import creationalDesignPatterns.abstractFactory.transport.Transport;

public abstract class Logistics {
    public abstract Transport createTransport();

    // Primary task
    public void someOperation() {
        System.out.println("Doing some operation");
    }
}
