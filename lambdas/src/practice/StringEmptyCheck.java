package practice;

import java.util.Scanner;
import java.util.function.Predicate;

public class StringEmptyCheck {
    public static void main(String[] args) {
        Predicate<String> expression = str -> str.isEmpty();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String s = sc.nextLine();

        if (expression.test(s)) {
            System.out.println("String is empty!!");
        } else {
            System.out.println("String not empty");
        }
    }
}


