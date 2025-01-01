import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Natural Number: ");
        int n = input.nextInt();

        System.out.println("Sum of Natural Numbers till: " + n + " is: " + sum(n));
    }

    private static int sum(int n) {
        if (n > 0) {
            return n + sum(n-1);
        }
        return 0;
    }
}
