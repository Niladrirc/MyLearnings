package structuralDesignPatterns.decorator.components;

public class PlainCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    @Override
    public double getPrice() {
        return 40.00d;
    }
}
