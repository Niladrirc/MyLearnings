package creationalDesignPatterns.factory;

import creationalDesignPatterns.factory.logistics.Logistics;
import creationalDesignPatterns.factory.logistics.SeaLogistics;
import creationalDesignPatterns.factory.transport.Transport;

public class Client {
    public static void main(String[] args) {
        Logistics logistics = new SeaLogistics();
        Transport transport = logistics.createTransport();
        transport.deliver();
    }
}
