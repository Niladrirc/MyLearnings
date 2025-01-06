package structuralDesignPatterns.decorator;

import structuralDesignPatterns.decorator.components.Coffee;
import structuralDesignPatterns.decorator.components.PlainCoffee;
import structuralDesignPatterns.decorator.decorators.MilkDecorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new PlainCoffee();

        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getPrice());

        Coffee milkCoffee = new MilkDecorator(new PlainCoffee());
        System.out.println("\nDescription: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.getPrice());

    }
}
