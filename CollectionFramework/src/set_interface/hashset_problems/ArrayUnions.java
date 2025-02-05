package set_interface.hashset_problems;

import java.util.*;

public class ArrayUnions {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        int[] b = {3, 2, 2, 3, 3, 2};

        List<Integer> res = intersection(a, b);

        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    private static List<Integer> intersection(int[] a, int[] b) {
        Set<Integer> intersection = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            intersection.add(a[i]);
        }

        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
            setB.add(b[i]);
        }

        intersection.retainAll(setB);

        return new ArrayList<>(intersection);

    }
}
