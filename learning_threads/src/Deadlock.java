import java.util.Scanner;

public class Deadlock {
    public static void main(String[] args) {
        String lock1 = "lock1";
        String lock2 = "lock2";

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Acquired lock1");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Acquired lock2");
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Acquired lock2");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Acquired lock1");
                }
            }
        }, "t2");


        t1.start();
        t2.start();


        System.out.println("Main exiting");
    }
}
