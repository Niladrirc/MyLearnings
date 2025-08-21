package learning;

/**
 * @author Niladri Ray Choudhury
 */
public class ThreadJoining {
    public static void main(String[] args) {
        System.out.println("Started the " + Thread.currentThread().getName());

        Thread2 t2 = new Thread2("thread2");
        Thread1 t1 = new Thread1("thread1", t2);

        Thread t = new Thread(t1);
        t.start();
    }
}


class Thread1 implements Runnable {
    private String threadName;
    private Thread subThread;

    public Thread1(String threadName, Thread subThread) {
        this.threadName = threadName;
        this.subThread = subThread;
        System.out.println("Thread " + threadName + " started, State: Runnable");
        System.out.println("SubThread name: " + subThread.getName());
    }

    @Override
    public void run() {
        System.out.println("Thread with name " + threadName + " is now running");
        try {
            System.out.println("Thread " + threadName + " will wait for 20ms before giving giving control to another thread to finish, then will resume again.");
            long start = System.currentTimeMillis();
            Thread.sleep(20);
            long sleepTime = System.currentTimeMillis() - start;
            System.out.println("Thread " + threadName + " slept for " + sleepTime + " duration");

            System.out.println("Giving control to " + subThread.getName());
            subThread.start();
            subThread.join();
            System.out.println("Thread " + subThread.getName() + " finished execution");
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " got interrupted. Exiting");
        } finally {
            System.out.println("Exiting thread " + threadName + " State: Dead");
        }
    }
}

class Thread2 extends Thread {


    public Thread2(String threadName) {
        super(threadName);
        System.out.println("Thread " + threadName + " started, State: Runnable");
    }

    @Override
    public void run() {
        System.out.println("Thread " + getName() + " is now running");

        try {
            System.out.println("Thread " + getName() + " starting it's execution");
            Thread.sleep(100);
            System.out.println("Thread " +getName()+ " finished execution. Going into Dead state");
        } catch (InterruptedException e) {
            System.out.println("Thread " + getName() + " got interrupted. Exiting");
        } finally {
            System.out.println("Exiting thread " + getName() + " State: Dead");
        }
    }
}
