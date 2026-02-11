package count_prime;

public class CountPrimeSequence {

    private static final Class<?> cls = CountPrimeSequence.class;

    private static final long MAX_RANGE = 100_000_000L;
    private static int numOfPrimes = 0;


    public static void main(String[] args) {
        System.out.println("Starting program..." + cls.getSimpleName() + "...");
        long startNano = System.nanoTime();
        for (int i=3; i<=MAX_RANGE; i++) {
            checkPrime(i);
        }
        System.out.println("Number of primes till " + MAX_RANGE + " is: " + numOfPrimes + 1 + ". Time to calculate" +
                ": " + calculateTimeElapsed(System.nanoTime(), startNano));
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

        return String.format("%s.%02d.%05d", timeElapsed, seconds, milliseconds);
    }

    private static void checkPrime(int x) {

        if (x % 2 == 0) return;

        for (int i = 3; i <= Math.sqrt(x); i++) {
            if (x%i == 0) {
                return;
            }
        }
        numOfPrimes++;
    }
}
