package count_prime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountPrimeInterleave {
    private static final Class<?> clss = CountPrimeInterleave.class;

    private static final long MAX_RANGE = 100_000_000L;
    private static final AtomicInteger numOfPrimes =  new AtomicInteger(0);
    private static final AtomicInteger currentNum = new AtomicInteger(3);

    private static final short threadPoolSize = 10;

    public static void main(String[] args) {
        System.out.println("Started Program ... " + clss.getSimpleName() + " ...");
        long startTime = System.nanoTime();

        // Each thread picks up an unprocessed line and checks if it is prime.
        // This continues till the whole MAX_RANGE is exhausted.
        try (ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize)) {
            List<Callable<Void>> tasks = new ArrayList<>();
            for (int i = 0; i < threadPoolSize; i++) {
                String threadName = String.valueOf(i);
                tasks.add(() -> doWork(threadName));
            }
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("checking till %d found %d prime numbers. took %s", MAX_RANGE, numOfPrimes.get() + 1, calculateTimeElapsed(System.nanoTime(), startTime));
    }

    private static Void doWork(String threadName) {
        long startTime = System.nanoTime();
        while (true) {
            var x = currentNum.getAndIncrement();
            if (x > MAX_RANGE) break;
            checkPrime(x);
        }

        System.out.printf("thread %s completed in %s\n", threadName, calculateTimeElapsed(System.nanoTime(), startTime));
        return null;
    }

    private static String calculateTimeElapsed(long end, long start) {
        long elapsedTimeNanos = end - start;

        long hours = (elapsedTimeNanos / (1_000_000_000L * 60 * 60));
        long remainingNanosAfterHours = elapsedTimeNanos % (1_000_000_000L * 60 * 60);

        long minutes = (remainingNanosAfterHours / (1_000_000_000L * 60));
        long remainingNanosAfterMinutes = remainingNanosAfterHours % (1_000_000_000L * 60);

        long seconds = (remainingNanosAfterMinutes / 1_000_000_000L);
        long milliseconds = (remainingNanosAfterMinutes % 1_000_000_000L) / 1_000_000L;

        StringBuilder timeElapsed = new StringBuilder();

        if (hours > 0) {
            timeElapsed.append(hours);
            timeElapsed.append("h");
        }
        if (minutes > 0) {
            timeElapsed.append(minutes);
            timeElapsed.append("m");
        }

        timeElapsed.append(String.format("%02d.%07d sec", seconds, milliseconds));

        return timeElapsed.toString();
    }

    private static void checkPrime(long x) {
        if (x % 2 == 0) return;

        for (int i = 3; i <= Math.sqrt(x); i++) {
            if (x%i == 0) {
                return;
            }
        }
        numOfPrimes.getAndIncrement();
    }
}
