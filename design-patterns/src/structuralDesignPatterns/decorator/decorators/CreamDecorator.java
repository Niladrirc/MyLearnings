package structuralDesignPatterns.decorator.decorators;

import structuralDesignPatterns.decorator.components.Coffee;

public class CreamDecorator extends CoffeeDecorator {

    public CreamDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Cream";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 15.00d;
    }
}
