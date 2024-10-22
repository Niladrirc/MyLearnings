package src;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int val = 4;

        int index = searchInsert(nums, val);
        System.out.println(index);
    }

    private static int searchInsert(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
