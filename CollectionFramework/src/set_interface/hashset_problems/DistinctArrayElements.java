package set_interface.hashset_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctArrayElements {
    public static void main(String[] args) {
        int[] arr = {12, 10, 9, 45, 2, 10, 10, 45};

        ArrayList<Integer> res = findDistinct(arr);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    private static ArrayList<Integer> findDistinct(int[] arr) {
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        return new ArrayList<>(set);
    }
}
