package set_interface.hashset_problems;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DisjointCheck {
    public static void main(String[] args) {
        int[] a = {12, 34, 11, 9, 3};
        int[] b = {7, 2, 1, 5};

        if(areDisjoint(a, b))
            System.out.println("True");
        else
            System.out.println("False");
    }

    private static boolean areDisjoint(int[] a, int[] b) {
        Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
        int initialSetASize = setA.size();
        Set<Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());
        setA.removeAll(setB);

        return setA.size() == initialSetASize;
    }
}
