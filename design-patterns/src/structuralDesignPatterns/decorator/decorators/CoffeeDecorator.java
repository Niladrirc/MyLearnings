package structuralDesignPatterns.decorator.decorators;

import structuralDesignPatterns.decorator.components.Coffee;

public abstract class CoffeeDecorator implements Coffee {

    private Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getPrice() {
        return decoratedCoffee.getPrice();
    }
}
