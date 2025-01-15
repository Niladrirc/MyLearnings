public class ThreadExtender extends Thread {

    private int count;

    public ThreadExtender(String threadName) {
        super(threadName);
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println("Inside thread: " + Thread.currentThread().getName());
            processSomething(i);
            count++;
        }
    }

    private void processSomething(int i) {
        try {
            Thread.sleep(i* 100L);
        } catch (InterruptedException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
