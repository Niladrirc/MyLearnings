package learning;

/**
 * @author Niladri Ray Choudhury
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Test1 t1 = new Test1("thread1");
        Test1 t2 = new Test1("thread2");

        t1.start();
        t2.start();
    }
}

class Test1 implements Runnable {

    private String threadName;
    private Thread t;

    public Test1(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Starting thread with name: " + threadName);

        try {
            for (int i=4; i>=0; i--) {
                System.out.println("Inside thread " + threadName + " iteration " + i);

                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread with name " + threadName + " interrupted. Exiting");
        }

        System.out.println("Finished processing " + threadName + ". Exiting");
    }


    public void start() {
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
