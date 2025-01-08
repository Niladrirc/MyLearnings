package structuralDesignPatterns.adapter;

public interface SocketAdapter {
    Volts get120Volts();
    Volts get12Volts();
    Volts get3Volts();
}
