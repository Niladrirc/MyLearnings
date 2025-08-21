package learning;

/**
 * @author Niladri Ray Choudhury
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Test2 t1 = new Test2("thread-1");
        Test2 t2 = new Test2("thread-2");

        t1.start();
        t2.start();
    }
}


class Test2 extends Thread {
    private String threadName;

    public Test2(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Starting thread with name: " + this.threadName);

        try {
            for (int i = 1; i <= 4; i++) {
                System.out.println("Thread " + this.threadName + " is running iteration " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + this.threadName + " interrupted.");
        }
    }

    @Override
    public void start() {
        System.out.println("Starting thread with name: " + this.threadName);
        if (this.getState() == Thread.State.NEW) {
            super.start();
        }
    }
}
