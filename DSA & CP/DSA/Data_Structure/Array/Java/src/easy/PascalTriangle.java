package src.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numRows;
        System.out.println("Enter the number of rows to be printed: ");
        numRows = input.nextInt();

        List<List<Integer>> result = generate(numRows);
        for (List<Integer> row : result) {
            for (int col = 0; col < row.size(); col++) {
                System.out.print(row.get(col) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            List<Integer> prev = new ArrayList<>();
            if (i > 0) {
                prev = result.get(i-1);
            } else {
                result.add(new ArrayList<>(List.of(1)));
                continue;
            }
            List<Integer> curr = new ArrayList<>(i);
            for (int x = 0; x<=i; x++) {
                if (x == 0 || x == i) {
                    curr.add(1);
                } else {
                    curr.add(prev.get(x-1) + prev.get(x));
                }
            }
            result.add(curr);
        }
        return result;
    }
}
