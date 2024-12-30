package creationalDesignPatterns.abstractFactory;

import creationalDesignPatterns.abstractFactory.logistics.Logistics;
import creationalDesignPatterns.abstractFactory.logistics.SeaLogistics;
import creationalDesignPatterns.abstractFactory.transport.Transport;

public class Client {
    public static void main(String[] args) {
        Logistics logistics = new SeaLogistics();
        Transport transport = logistics.createTransport();
        transport.deliver();
    }
}
