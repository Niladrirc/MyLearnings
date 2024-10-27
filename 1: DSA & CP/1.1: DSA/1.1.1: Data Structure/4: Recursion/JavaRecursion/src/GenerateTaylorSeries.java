import java.util.Scanner;

public class GenerateTaylorSeries {
    private static double p=1, f=1, hornerSum = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter base: ");
        int base = input.nextInt();

        System.out.print("\n Enter max exponent: ");
        int exp = input.nextInt();

        System.out.println("Result: " + taylor(base, exp));
    }


    private static double taylor(int x, int n) {
        if (n == 0)
            return 1;
        double num = power(x, n);
        double den = fact(x);
        return num/den;
    }

    private static double fact(int x) {
        if (x == 0)
            return 1;
        return x * fact(x - 1);
    }

    private static double power(int x, int n) {
        if (n%2 == 0 && n != 0) {
            return power(x*x, n/2);
        } else if (n%2 != 0) {
            return x*power(x*x, n/2);
        } else
            return 0;
    }

    private static double fastTaylor(int x, int n) {

        if (n == 0)
            return 1;

        double sum = fastTaylor(x, n-1);
        p *= x;
        f *= n;

        return (sum + p/f);
    }

    private static double hornerTaylor(int x, int n) {
        if (n == 0)
            return hornerSum;
        hornerSum = 1 + ((double) x /n)*hornerSum;
        return hornerTaylor(x, n-1);
    }
}
