public class NestedRecusion {
    public static void main(String[] args) {
        int n = 95;
        System.out.println("Result: " + fun(95));
    }

    private static int fun(int i) {
        if (i > 100) {
            return i - 10;
        } else {
            return fun(fun(i+11));
        }
    }
}
