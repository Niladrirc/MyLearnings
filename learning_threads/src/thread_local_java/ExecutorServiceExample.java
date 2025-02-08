package thread_local_java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ExecutorServiceExample {
    private static int count = 0;
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        es.submit(() -> process("user1"));
        es.submit(() -> process("user2"));
        System.out.println(count);

        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.submit(() -> process("user1"));
        pool.submit(() -> process("user2"));
        System.out.println(count);
    }

    private static void process(String user) {
        try {
            count++;
            System.out.println("Processing for " + user);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
