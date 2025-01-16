package easy;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        int columnNumber = 1;

        String columnTitle = convertToTitle(columnNumber);
        System.out.println("Column Title: " + columnTitle);

        System.out.println("Column Number: "+titleToColumn(columnTitle));
    }

    private static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            result.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }

    private static int titleToColumn(String columnTitle) {
        int columnNumber = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char currentChar = columnTitle.charAt(i);
            int ascii = (currentChar - 'A') + 1;
            columnNumber = columnNumber * 26 + ascii;
        }
        return columnNumber;
    }
}
