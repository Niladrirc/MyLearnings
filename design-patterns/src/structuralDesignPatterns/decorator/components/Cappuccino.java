package structuralDesignPatterns.decorator.components;

public class Cappuccino implements Coffee {
    @Override
    public String getDescription() {
        return "Cappuccino";
    }

    @Override
    public double getPrice() {
        return 60.00d;
    }
}
