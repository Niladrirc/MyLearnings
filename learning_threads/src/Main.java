
public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main is starting");
        RunnableImplementer ri = new RunnableImplementer();

        Thread t = new ThreadExtender("ThreadExtender"); // Should not be used as it has limitations
        Thread rit = new Thread(ri, "RunnableImplementer"); // Should be used more often


        // Better way
        Thread thread = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                System.out.println("Inside thread: " + Thread.currentThread().getName());
            }
        },
                "LambdaThread");

        rit.start();
        thread.start();

        System.out.println("Main is exiting");
    }
}