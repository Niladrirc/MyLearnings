package structuralDesignPatterns.decorator.file_store_decorator;

public class CompressionDecorator extends DataStoreDecorator {

    public CompressionDecorator(DataStore dataStore) {
        super(dataStore);
    }

    @Override
    public void writeDate(String data) throws InterruptedException {
        System.out.println("Compressing raw data...");
        Thread.sleep(10000);
        System.out.println("Compression complete");
        super.writeDate(data);
    }

    @Override
    public String readData() throws InterruptedException {
        String rawData = super.readData();
        System.out.println("Decompressing raw data...");
        Thread.sleep(10000);
        System.out.println("Decompression complete!!!");
        return rawData;
    }
}
