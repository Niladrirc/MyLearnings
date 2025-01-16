package combinations;

public class Naive {
    public long result(long n, long r) {
        long t1 = fact(n);
        long t2 = fact(r);
        long t3 = fact(n-r);

        return t1/(t2*t3);
    }

    private long fact(long n) {
        if (n == 0) {
            return 1;
        }
        return n*fact(n-1);
    }
}
