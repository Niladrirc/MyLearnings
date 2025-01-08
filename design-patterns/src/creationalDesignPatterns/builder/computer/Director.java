package creationalDesignPatterns.builder.computer;

public class Director {

    private ComputerBuilder builder;

    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructComputer() {
        return builder.processor("Intel i7").memory(16).storage(512).graphicsCard("NVIDIA GTX 1660").build();
    }
}
