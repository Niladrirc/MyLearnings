package wissen;

import java.util.*;
import java.util.stream.*;

public class FlattenObjectArray {
    public static void main(String[] args) throws Exception{
        Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };

        Integer[] flattenedArray = flatten(array);

        System.out.println(Arrays.toString(flattenedArray));
    }

    public static Integer[] flatten(Object[] inputArray) throws Exception {
        List<Integer> arrayList = new ArrayList<>();
        for (int i=0; i< inputArray.length; i++) {
            if (inputArray[i] instanceof Object[]) {
                Integer[] result = flatten((Object[]) inputArray[i]);
                arrayList.addAll(Arrays.stream(result).toList());
            } else {
                arrayList.add((Integer) inputArray[i]);
            }
        }
        return arrayList.toArray(new Integer[0]);
    }

    public static Integer[] flattenUsingStream(Object[] arr) {
         return Arrays.stream(arr).
                flatMap(element -> element instanceof Object[] ?
                        Arrays.stream(flattenUsingStream((Object[]) element)) :
                        element instanceof Integer ? Stream.of((Integer) element) : Stream.empty())
                 .toArray(Integer[]::new);
    }
}
