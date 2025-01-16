import java.util.Scanner;

public class ExponentRecursion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int base, exp;
        System.out.print("Enter base: ");
        base = input.nextInt();

        System.out.print("\nEnter exponent: ");
        exp = input.nextInt();

        System.out.println(calcExponent(base, exp));
    }

    private static long calcExponent(int base, int exp) {
        if (exp % 2 == 0 && exp != 0) {
            return calcExponent(base*base, exp/2);
        } else if (exp % 2 != 0) {
            return base * calcExponent(base*base, exp/2);
        } else if (exp == 0) {
            return 1;
        }
        return 1;
    }
}
