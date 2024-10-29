package src.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumGoodSubarraySum {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 4, 5};
        int k = 3;

        System.out.println("Maximum Good Subarray Sum: " + maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> valToMinPrefixSum = new HashMap<>();
        long maxSum = Long.MIN_VALUE, prefixSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (valToMinPrefixSum.getOrDefault(nums[i], Long.MAX_VALUE) > prefixSum) {
                valToMinPrefixSum.put(nums[i], prefixSum);
            }
            prefixSum += nums[i];
            if (valToMinPrefixSum.containsKey(nums[i] + k)) {
                maxSum = Math.max(maxSum, prefixSum - valToMinPrefixSum.get(nums[i] + k));
            }
            if (valToMinPrefixSum.containsKey(nums[i] - k)) {
                maxSum = Math.max(maxSum, prefixSum - valToMinPrefixSum.get(nums[i] - k));
            }
        }
        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}
