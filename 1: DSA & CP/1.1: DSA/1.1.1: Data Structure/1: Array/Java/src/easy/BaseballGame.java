package src.easy;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};

        System.out.println("Output: " + calPoints(ops));
    }

    private static int calPoints(String[] ops) {
        List<Integer> record = new ArrayList<>();

        for (String op : ops) {
            switch (op) {
                case "+" -> record.add(record.get(record.size() - 2) + record.get(record.size() - 1));
                case "D" -> record.add(record.get(record.size() - 1) * 2);
                case "C" -> record.remove(record.size() - 1);
                default -> record.add(Integer.parseInt(op));
            }
        }

        return record.stream().mapToInt(Integer::intValue).sum();
    }
}
