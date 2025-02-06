package set_interface.hashset_problems;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 };
        System.out.println(longestConsecutive(arr));
    }

    private static int longestConsecutive(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().distinct().sorted().toList();
        for (int i = 1; i < list.size(); i++) {
            if ((list.get(i) - list.get(i-1)) > 1) return i;
        }
        return 0;
    }
}
