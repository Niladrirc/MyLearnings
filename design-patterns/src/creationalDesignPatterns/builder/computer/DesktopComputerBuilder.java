package creationalDesignPatterns.builder.computer;

public class DesktopComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public DesktopComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public ComputerBuilder processor(String processor) {
        computer.setProcessor(processor);
        return this;
    }

    @Override
    public ComputerBuilder memory(int memory) {
        computer.setMemory(memory);
        return this;
    }

    @Override
    public ComputerBuilder storage(int storage) {
        computer.setStorage(storage);
        return this;
    }

    @Override
    public ComputerBuilder graphicsCard(String graphicsCard) {
        computer.setGraphicsCard(graphicsCard);
        return this;
    }

    @Override
    public Computer build() {
        return this.computer;
    }
}
