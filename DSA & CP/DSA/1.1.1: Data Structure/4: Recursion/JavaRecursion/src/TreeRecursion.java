public class TreeRecursion {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Result: \n");
        fun(n);
    }

    private static void fun(int n) {
        if (n > 0) {
            System.out.println(n + ", ");
            fun(n-1);
            fun(n-1);
        }
    }
}
