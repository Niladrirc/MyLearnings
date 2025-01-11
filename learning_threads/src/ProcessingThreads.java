public class ProcessingThreads implements Runnable {

    private int count;

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count++;
        }
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i* 100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        return count;
    }
}
