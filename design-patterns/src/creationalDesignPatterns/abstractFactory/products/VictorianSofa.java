package creationalDesignPatterns.abstractFactory.products;

public class VictorianSofa implements Sofa {
    @Override
    public void numberOfSeats() {
        System.out.println("3 seater victorian sofa");
    }

    @Override
    public void sitOn() {
        System.out.println("Can be sit on");
    }
}
