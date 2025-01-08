package creationalDesignPatterns.builder.computer;

/**
 * Builder Interface
 */
public interface ComputerBuilder {
    ComputerBuilder processor(String processor);
    ComputerBuilder memory(int memory);
    ComputerBuilder storage(int storage);
    ComputerBuilder graphicsCard(String graphicsCard);
    Computer build();
}
