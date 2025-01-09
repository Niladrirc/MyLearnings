package structuralDesignPatterns.decorator.file_store_decorator;

public class DataStoreDecorator implements DataStore {
    private final DataStore dataStore;

    public DataStoreDecorator(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void writeDate(String data) throws InterruptedException {
        dataStore.writeDate(data);
    }

    @Override
    public String readData() throws InterruptedException {
        return dataStore.readData();
    }
}
