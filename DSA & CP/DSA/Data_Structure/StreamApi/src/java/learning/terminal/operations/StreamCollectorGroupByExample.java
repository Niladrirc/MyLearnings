package src.java.learning.terminal.operations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectorGroupByExample {
    record Person(String name, long age) {}
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Niladri", 30),
                new Person("Prapti", 24),
                new Person("Susmita", 30)

        );

        Map<Long, List<Person>> ageNameMap = persons.stream()
                .collect(Collectors.groupingBy(Person::age));

        for (Map.Entry<Long, List<Person>> entry: ageNameMap.entrySet()) {
            System.out.println("Persons with age: " +
                    entry.getKey() + " are: " +
                    entry.getValue().stream()
                            .map(Person::name)
                            .collect(Collectors.joining(", "))
            );
        }

            //Easier method
        Map<Long, List<String>> ageToNameMapNew = persons.stream()
                .collect(Collectors.groupingBy(Person::age, Collectors.mapping(Person::name, Collectors.toList())));
        ageToNameMapNew.forEach((age, name) -> System.out.println("Persons with age "+age+" are "+name));


        // Count the number of persons in each group
        for (Map.Entry<Long, List<Person>> entry:ageNameMap.entrySet()) {
            System.out.println("Number of persons with age of "+ entry.getKey()+ " are "+
                    entry.getValue().size());
        }

            // Another method
        Map<Long, Long> ageToCountMap = persons.stream().collect(Collectors.groupingBy(Person::age, Collectors.counting()));
        ageToCountMap.forEach((key, value) -> System.out.println("Number of persons with age of "+key+" are "+value));

    }
}
