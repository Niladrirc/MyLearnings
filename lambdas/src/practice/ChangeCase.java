package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.
 */
public class ChangeCase {
    public static void main(String[] args) {
        List<String> inputList = List.of("Niladri", "Ray", "Choudhury");

        IChangeCase toUpper = input -> {
            List<String> result = new ArrayList<>();
            for (String str : input) {
                result.add(str.toUpperCase());
            }
            return result;
        };

        IChangeCase toLower = input -> {
            List<String> result = new ArrayList<>();
            for (String s : input) {
                result.add(s.toLowerCase());
            }
            return result;
        };

        List<String> upperCaseList = toUpper.changeCase(inputList);
        List<String> lowerCaseList = toLower.changeCase(inputList);

        System.out.println("Upper case list: "+upperCaseList);
        System.out.println("Lower case list: "+lowerCaseList);
    }
}

@FunctionalInterface
interface IChangeCase {
    List<String> changeCase(List<String> stringList);
}
