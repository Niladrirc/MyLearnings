package practice;

import java.util.Arrays;

public class EnumStream {
    public static void main(String[] args) {
        boolean result = Arrays.stream(Types.values()).anyMatch(enumValue -> {
            String enumStr = enumValue.getType();
            return enumStr.equalsIgnoreCase("C");
        });

        System.out.println(result);
    }
}

enum Types {
    A("A"),
    B("B");

    Types(String value) {
        this.type = value;
    }

    private String type;

    public String getType() {
        return type;
    }
}
