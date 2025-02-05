package iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class IterableForEachExample {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();

        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Bengaluru");
        cities.add("Chennai");

        // Defining Consumer function
//        Consumer<String> printer = city -> System.out.println(city);
        Consumer<String> printer = System.out::println;

        cities.forEach(printer);
    }
}
