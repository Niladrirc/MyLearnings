package set_interface;

import java.util.*;

public class LearningSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(6);
        set.add(123);
        set.add(52);
        set.add(2);

        System.out.println(set);

        Integer[] set1 = {1, 3, 2, 4, 8, 9, 0};
        Integer[] set2 = {1, 3, 7, 5, 4, 0, 7, 5};

        Set<Integer> setA = new HashSet<>(Arrays.asList(set1));

        Set<Integer> setB = new HashSet<>();
        setB.addAll(Arrays.asList(set2));

        // To find union
        Set<Integer> union = new HashSet<>(setA);
        union.addAll(setB); // This method is used to append all of the elements from the mentioned collection to the existing set.
                            // The elements are added randomly without following any specific order.
        System.out.println("Union: " + union);

        // To find intersection
        Set<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB); // -> This method is used to retain all the elements from the set which are mentioned in the given collection.
                                            // This method returns true if this set changed as a result of the call.
        System.out.println("Intersection: " + intersection);


        // To find difference
        /*
            use remove all:
                This method is used to remove all the elements from the collection which are present in the set.
                This method returns true if this set changed as a result of the call.
         */
        Set<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference: " + difference);


        // Accessing set element
        System.out.println(setA.contains(9));

        //Removing element
        setA.remove(0);
        Set<Integer> newIntersection = new HashSet<>(setA);
        newIntersection.retainAll(setB);
        System.out.println("Intersection after removing 0: " + newIntersection);


        // Iterating through elements
        for (Integer value : setA) {
            System.out.print(value + ",");
        }


    }
}
