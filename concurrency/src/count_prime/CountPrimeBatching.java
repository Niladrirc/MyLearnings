package count_prime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CountPrimeBatching {
    private static final Class<?> clss = CountPrimeBatching.class;

    private static final long MAX_RANGE = 100_000_000L;
    private static AtomicInteger numOfPrimes =  new AtomicInteger(0);

    private static final short numOfBatches = 10;

    public static void main(String[] args) {
        System.out.println("Started Program ... " + clss.getSimpleName() + " ...");

        long startTime = System.nanoTime();

        // Divide the overall data range into ${numOfBatches} batches.
        // Create ${numOfBatches} threads and assign each thread to handle each batch then add the results

        try (ExecutorService executor = Executors.newFixedThreadPool(numOfBatches)) {
            // create all the runnable/callable tasks and add it to a list.
            List<Callable<Void>> tasks = getCallables();
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        System.out.printf("checking till %d found %d prime numbers. took %s", MAX_RANGE, numOfPrimes.get() + 1, calculateTimeElapsed(System.nanoTime(), startTime));

    }

    private static List<Callable<Void>> getCallables() {
        List<Callable<Void>> tasks = new ArrayList<>();
        long nStart = 3;
        long batchSize = MAX_RANGE / numOfBatches;

        for (int i = 0; i < numOfBatches; i++) {
            final String name = String.valueOf(i);
            final long start = nStart;
            final long end = nStart + batchSize;

            Callable<Void> callableTask = () -> batchStart(name, start, end);
            tasks.add(callableTask);
            nStart += batchSize;
        }
        return tasks;
    }

    private static Void batchStart(String threadName, long nStart, long nEnd) {
        long startTime = System.nanoTime();
        for (long i=nStart; i<nEnd; i++) {
            checkPrime(i);
        }
        System.out.printf("Thread %s with range [%d, %d) completed in %s%n", threadName, nStart, nEnd, calculateTimeElapsed(System.nanoTime(), startTime));
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
