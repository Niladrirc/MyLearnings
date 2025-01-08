package structuralDesignPatterns.adapter;

public class Socket {

    public Volts getVolts() {
        return new Volts(120);
    }
}
