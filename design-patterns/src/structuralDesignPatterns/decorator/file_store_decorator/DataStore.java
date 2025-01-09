package structuralDesignPatterns.decorator.file_store_decorator;

public interface DataStore {
    void writeDate(String data) throws InterruptedException;
    String readData() throws InterruptedException;
}
