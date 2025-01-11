
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ProcessingThreads pt = new ProcessingThreads();

        Thread t1 = new Thread(pt, "t1");
        Thread t2 = new Thread(pt, "t2");
        // thread start
        t1.start();
        t2.start();
        //wait for thread to finish processing
        t1.join();
        t2.join();
        System.out.println("Processing count="+pt.getCount());
    }
}