package structuralDesignPatterns.adapter;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter {
    @Override
    public Volts get120Volts() {
        return getVolts();
    }

    @Override
    public Volts get12Volts() {
        Volts v = getVolts();
        return convertVolt(v,10);
    }

    @Override
    public Volts get3Volts() {
        Volts v = getVolts();
        return convertVolt(v, 40);
    }

    private Volts convertVolt(Volts v, int i) {
        return new Volts(v.getVolts()/i);
    }
}
