package src.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        if (containsDuplicate(nums))
            System.out.println("Array contains duplicates");
        else
            System.out.println("Array does not contains duplicates");
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i))
                return true;
            else
                set.add(i);
        }
        return false;
    }
}
