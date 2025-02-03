public class DeadlockWithSingleThread {
    public static void main(String[] args) {
        try {
            Thread.currentThread().join();
            System.out.println("Waiting current thread to finish");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
