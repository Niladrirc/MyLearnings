public class CacheCoherence {
    private static int number=0;
    private static boolean ready;

    private static class Ready extends Thread {
        @Override
        public void run() {
            while (!ready) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {}
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Ready().start();
        number = 42;
        ready = true;
    }
}
