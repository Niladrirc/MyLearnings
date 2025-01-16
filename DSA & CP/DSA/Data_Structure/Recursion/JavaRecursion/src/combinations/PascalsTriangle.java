package combinations;

public class PascalsTriangle {
    public long result(long n, long r) {
        if (n == r || r == 0)
            return 1;
        return result(n-1, r-1) + result(n-1, r);
    }
}
