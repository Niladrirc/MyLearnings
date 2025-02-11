package src.hard;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }

    private static int longestConsecutive(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toSet()).stream().sorted().toList());
        int result = 0, len = 0;
        for (int i = 1; i < list.size(); i++) {
            if (Objects.equals(list.get(i), list.get(i - 1)) || (list.get(i) - list.get(i-1) > 1)) {
                result = Math.max(result, len+1);
                len = 0;
                continue;
            }
            len++;
        }
        return Math.max(result, len+1);
    }
}
