public class ThreadStateTest {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread t1 = new Thread(thread1, "thread1");

        System.out.println("State of thread1 before start:- " + t1.getState());

        t1.start();

        System.out.println("State of thread1 after start:- " + t1.getState());
    }
}

class Thread1 implements Runnable {

    public static Thread t2;

    @Override
    public void run() {
        Thread2 thread2 = new Thread2();
        t2 = new Thread(thread2, "thread2");

        System.out.println("State of thread2 before start:- " + t2.getState());

        t2.start();

        System.out.println("State of thread2 after start:- " + t2.getState());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("State of thread2 after calling .sleep()"
                + " method on it - " + t2.getState());

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread2 when it has finished "
                + "it's execution - " + t2.getState());
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread1 while it called"
                + " join() method on thread2 -"
                + Thread1.t2.getState());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}