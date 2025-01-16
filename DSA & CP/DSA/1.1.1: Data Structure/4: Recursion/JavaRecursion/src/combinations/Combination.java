package combinations;

import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter r: ");
        int r = sc.nextInt();


        Naive naiveApproach = new Naive();
        long result = naiveApproach.result(n,r);

        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        long pascalResult = pascalsTriangle.result(n, r);

        System.out.println("Naive Result: " + result);
        System.out.println("Pascal Triangle Result: " + pascalResult);
    }
}
