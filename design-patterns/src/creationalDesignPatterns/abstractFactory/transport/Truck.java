package creationalDesignPatterns.abstractFactory.transport;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver vis road");
    }
}
