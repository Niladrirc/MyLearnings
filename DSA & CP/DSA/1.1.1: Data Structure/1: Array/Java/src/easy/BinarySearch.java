package src.easy;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println("Index: "+search(nums, 0, nums.length-1, target));
    }

    private static int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start < end) {
            int mid = (start+end)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }

    private static int search(int[] nums, int start, int end, int target) {
        int mid = (start+end)/2;
        if (start > end)
            return -1;
        if (nums[mid] == target)
            return mid;

        if (nums[mid] > target)
            return search(nums, start, mid-1, target);
        else
            return search(nums, mid+1, end, target);
    }
}
