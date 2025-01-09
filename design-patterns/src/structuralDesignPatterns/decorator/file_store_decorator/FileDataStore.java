package structuralDesignPatterns.decorator.file_store_decorator;

public class FileDataStore implements DataStore {
    @Override
    public void writeDate(String data) throws InterruptedException {
        System.out.println("Writing data to file store: \n" + data);
        System.out.println("Writing...");
        Thread.sleep(10000);
        System.out.println("Completed!!");
    }

    @Override
    public String readData() {
        return "Reading from file store";
    }
}
