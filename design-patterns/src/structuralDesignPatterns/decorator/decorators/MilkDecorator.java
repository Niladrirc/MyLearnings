package structuralDesignPatterns.decorator.decorators;

import structuralDesignPatterns.decorator.components.Coffee;

public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Milk";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 2.5d;
    }
}
