package structuralDesignPatterns.decorator.file_store_decorator;

public class Client {
    private static final boolean ENCRYPTION_ENABLED = true;
    private static final boolean COMRESSION_ENABLED = true;

    public static void main(String[] args) throws InterruptedException {
        DataStore ds = getConfiguredDataStore();

        ds.writeDate("Niladri");

        ds.readData();
    }

    private static DataStore getConfiguredDataStore() {
        DataStore store = new FileDataStore();

        if (ENCRYPTION_ENABLED)
            store = new EncryptionDecorator(store);
        if (COMRESSION_ENABLED)
            store = new CompressionDecorator(store);

        return store;
    }
}
