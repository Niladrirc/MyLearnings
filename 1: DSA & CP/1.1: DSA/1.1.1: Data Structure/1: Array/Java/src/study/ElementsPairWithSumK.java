package src.study;

public class ElementsPairWithSumK {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int k = 3;

        pairSum(nums, k);
    }

    public static void pairSum(int[] nums, int k) {
        int max = findMax(nums);
        int[] hash = new int[max+1];
        int index = 0;
        while (index < nums.length) {
            hash[nums[index]] = 1;
            int x = k - nums[index];
            if (hash[x] == 1) {
                System.out.println("["+nums[index]+", "+x+"]");
            }
        }
    }

    private static int findMax(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            max = Math.max(max, i);
        }
        return max;
    }
}
