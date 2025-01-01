package creationalDesignPatterns.abstractFactory;

public class VictorianChair implements Chair {
    @Override
    public void hasLegs() {
        System.out.println("Decorative victorian design legs");
    }

    @Override
    public void sitOn() {
        System.out.println("Can be sit on victorian chair");
    }
}
