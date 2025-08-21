package learning;

/**
 * @author Niladri Ray Choudhury
 */
public class ThreadLifeCycle {
    public static void main(String[] args) {
        Demo demo1 = new Demo("demo1");
        Demo demo2 = new Demo("demo2");

        demo1.start();
        demo2.start();
    }
}

class Demo implements Runnable {

    private Thread t;
    private String threadName;

    public Demo(String threadName) {
        this.threadName = threadName;
        System.out.println("Thread: " + threadName + ", " + "State: New");
    }

    @Override
    public void run() {
        System.out.println("Thread: " + threadName + ", " + "State: Running");
        try {
            for (int i = 4; i > 0 ; i--) {
                System.out.println("Thread: " + threadName + ", " + "State: Waiting");
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread: " + threadName + ", " + "State: Dead");
    }

    public void start() {
        System.out.println("Starting a new thread with name " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            System.out.println("Thread " + threadName + " transitioning to new state");

            t.start();
            System.out.println("Thread " + threadName + " entered in runnable state");
        }
    }
}