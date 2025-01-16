package src.easy;

public class SingleNumberWithXor {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        System.out.println("The digit that appears only once is: " + singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        return getResult(0, nums);
    }

    private static int getResult(int i, int[] nums) {
        if (i == nums.length) {
            return 0;
        }
        return nums[i] ^ getResult(i + 1, nums);
    }
}
