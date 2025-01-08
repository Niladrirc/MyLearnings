package creationalDesignPatterns.builder.computer;

public class Client {
    public static void main(String[] args) {
        ComputerBuilder desktopBuilder = new DesktopComputerBuilder();
        Director director = new Director(desktopBuilder);
        Computer desktop = director.constructComputer();

        // Access the constructed Computer object
        System.out.println(desktop.toString());
    }
}
