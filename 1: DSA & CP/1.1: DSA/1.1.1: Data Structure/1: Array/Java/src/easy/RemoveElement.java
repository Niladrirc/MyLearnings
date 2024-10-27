package src.easy;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;

        int k = removeElement(nums, val);
        System.out.println(k);
    }

    private static int removeElement(int[] nums, int val) {
        int k = 0;
        int[] expectedNums = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != val) {
                expectedNums[k] = nums[i];
                k++;
            }
        }
        System.arraycopy(expectedNums, 0, nums, 0, nums.length);
        return k;
    }
}
