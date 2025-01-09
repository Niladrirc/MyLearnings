package structuralDesignPatterns.decorator.file_store_decorator;

public class EncryptionDecorator extends DataStoreDecorator {

    public EncryptionDecorator(DataStore dataStore) {
        super(dataStore);
    }

    @Override
    public void writeDate(String data) throws InterruptedException {
        System.out.println("Encrypting raw data...");
        Thread.sleep(10000);
        System.out.println("Encryption complete");
        super.writeDate(data);
    }

    @Override
    public String readData() throws InterruptedException {
        String rawData = super.readData();
        System.out.println("Decrypting raw data...");
        Thread.sleep(10000);
        System.out.println("Decryption complete!!!");
        return rawData;
    }
}
