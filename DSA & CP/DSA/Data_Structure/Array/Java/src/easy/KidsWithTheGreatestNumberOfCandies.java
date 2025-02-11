package src.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;

        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandy = 0;
        for (int numCandy : candies) {
            maxCandy = Math.max(numCandy, maxCandy);
        }

        for (int i=0; i<candies.length; i++) {
            if ((candies[i] + extraCandies) >= maxCandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;

    }
}
