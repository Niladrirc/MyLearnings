package structuralDesignPatterns.decorator.decorators;

import structuralDesignPatterns.decorator.components.Coffee;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Sugar";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 1.5d;
    }
}
