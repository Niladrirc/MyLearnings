package src.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumGoodSubarraySum {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 4, 5};
        int k = 3;

        System.out.println("Maximum Good Subarray Sum: " + maximumSubarraySum(nums, k));
    }

    /**
     * Requirements:
     *      Hashmap -> stores every element in the array (as key) and the corresponding sum of all elements before that (as prefixSum).
     * LOGIC: For any value in the array
     *          1. check if the value already exists in hashmap
     *              1.1 If exists -> compare the corresponding prefixSum with current prefixSum and store the lesser value.
     *                  1.1.1 This ensures that if duplicates are present, storing lesser prefixSum gets us larger maxSum
     *              1.2 If does not exist -> add it to the hashmap with current prefixSum
     *          2. For the currentElement, update the prefixSum
     *          3. Get complement1 & complement2
     *          4. Check which exists in hashmap,
     *              4.1 For anyone that exists: we compare the current prefixSum i.e. sum of all elements till current element and complement's prefixSum i.e. sum of all elements till that (excluding it)
     *                      this will give the sum from the complement to currentElement
     *                      and as we only store minimum prefixSum -> we get the max sum
     */
    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> valToMinPrefixSum = new HashMap<>();
        long maxSum = Long.MIN_VALUE, prefixSum = 0;
        for (int currentElement : nums) {
            if (valToMinPrefixSum.getOrDefault(currentElement, Long.MAX_VALUE) > prefixSum) {
                valToMinPrefixSum.put(currentElement, prefixSum);
            }
            prefixSum += currentElement;
            int complement1 = currentElement + k;
            int complement2 = currentElement - k;
            if (valToMinPrefixSum.containsKey(complement1)) {
                maxSum = Math.max(maxSum, prefixSum - valToMinPrefixSum.get(complement1));
            }
            if (valToMinPrefixSum.containsKey(complement2)) {
                maxSum = Math.max(maxSum, prefixSum - valToMinPrefixSum.get(complement2));
            }
        }
        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}
