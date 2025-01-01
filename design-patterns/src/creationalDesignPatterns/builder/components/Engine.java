package creationalDesignPatterns.builder.components;

public class Engine {
    private final double volume;
    private double milage;
    private boolean started;

    public Engine(double volume, double milage) {
        this.volume = volume;
        this.milage = milage;
    }

    public double getVolume() {
        return volume;
    }

    public double getMilage() {
        return milage;
    }

    public boolean isStarted() {
        return started;
    }

    public void on() {
        this.started = true;
    }

    public void off() {
        this.started = false;
    }

    public void go(double milage) {
        if (this.started) {
            this.milage += milage;
        } else {
            System.err.println("Cannot go(), you must start engine first!");
        }
    }

}
