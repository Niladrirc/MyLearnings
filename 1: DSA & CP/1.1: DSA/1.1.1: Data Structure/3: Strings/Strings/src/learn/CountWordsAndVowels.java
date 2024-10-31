package learn;

public class CountWordsAndVowels {
    public static void main(String[] args) {
        StringADT myStringObj = new StringADT();
        myStringObj.setStr("Hello World");

        System.out.println("Number of letters in the string: "+ myStringObj.letterCount());
        System.out.println("Number of words in the string: "+ myStringObj.wordsCount());
        System.out.println("Number of vowels in the string: "+ myStringObj.vowelCount());
        System.out.println("Number of unique vowels in the string: "+ myStringObj.uniqueVowelCount());
    }
}
