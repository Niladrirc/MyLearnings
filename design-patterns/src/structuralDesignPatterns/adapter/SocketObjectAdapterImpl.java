package structuralDesignPatterns.adapter;

public class SocketObjectAdapterImpl implements SocketAdapter {

    // Wrapping the service class
    private final Socket socket = new Socket();

    @Override
    public Volts get120Volts() {
        return socket.getVolts();
    }

    @Override
    public Volts get12Volts() {
        Volts v = socket.getVolts();
        return convertVolt(v, 10);
    }

    @Override
    public Volts get3Volts() {
        Volts v = socket.getVolts();
        return convertVolt(v, 40);
    }

    private Volts convertVolt(Volts v, int i) {
        return new Volts(v.getVolts()/i);
    }
}
