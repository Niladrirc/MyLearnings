    package learning;

    /**
     * @author Niladri Ray Choudhury
     */
    public class ThreadJoiningWithDefaultDuration {
        public static void main(String[] args) {
            System.out.println("Thread " + Thread.currentThread().getName() + " started");

            Thred2 t2 = new Thred2("thread2");
            Thred1 t1 = new Thred1("thread1", t2);

            Thread t = new Thread(t1);
            t.start();
        }
    }

    class Thred1 extends Thread {

        private final Thread subThread;

        public Thred1(String threadName, Thread subThread) {
            super(threadName);
            this.subThread = subThread;
            System.out.println("Thread " + getName() + " started. State: Runnable");
        }

        @Override
        public void run() {
            System.out.println("Thread " + getName() + " started running. State: Running");
            try {
                long start = System.currentTimeMillis();
                Thread.sleep(20);
                long sleepTime = System.currentTimeMillis() - start;
                System.out.println("Thread " + getName() + " slept for " + sleepTime + " duration");

                System.out.println("Giving control to " + subThread.getName());
                start = System.currentTimeMillis();
                subThread.start();
                subThread.join(100);
                long subThreadExecutionTime = System.currentTimeMillis() - start;
                System.out.println("Thread " + subThread.getName() + " finished execution in " + subThreadExecutionTime + "ms");
            } catch (InterruptedException e) {
                System.out.println("Thread " + getName() + " got interrupted. State: Interrupted");
            } finally {
                System.out.println("Exiting thread " + getName() + " State: Dead");
            }
        }
    }

    class Thred2 extends Thread {

        public Thred2(String threadName) {
            super(threadName);
            System.out.println("Thread " + threadName + " started, State: Runnable");
        }

        @Override
        public void run() {
            System.out.println("Thread " + getName() + " is now running");

            try {
                System.out.println("Thread " + getName() + " starting it's execution");
                Thread.sleep(10);
                System.out.println("Thread " +getName()+ " finished execution. Going into Dead state");
            } catch (InterruptedException e) {
                System.out.println("Thread " + getName() + " got interrupted. Exiting");
            } finally {
                System.out.println("Exiting thread " + getName() + " State: Dead");
            }
        }
    }
