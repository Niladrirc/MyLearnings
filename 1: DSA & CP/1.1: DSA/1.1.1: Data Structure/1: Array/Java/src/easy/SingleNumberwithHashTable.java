package src.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberwithHashTable {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        System.out.println("The digit that appears only once is: " + singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int num : nums) {
            if (hashTable.containsKey(num)) {
                hashTable.put(num, hashTable.get(num)+1);
            } else {
                hashTable.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashTable.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
