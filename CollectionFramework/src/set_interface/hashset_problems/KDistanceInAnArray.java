package set_interface.hashset_problems;

import java.util.HashMap;
import java.util.Map;

public class KDistanceInAnArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(checkDuplicatesWithinK(arr, 3) ? "Yes" : "No");
    }

    private static boolean checkDuplicatesWithinK(int[] arr, int i) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < arr.length; j++) {
            if (map.containsKey(arr[j])) {
                if (Math.abs(map.get(arr[j]) - j) <= i) return true;
            } else {
                map.put(arr[j], j);
            }
        }
        return false;
    }
}
