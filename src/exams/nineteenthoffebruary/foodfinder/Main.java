package exams.nineteenthoffebruary.foodfinder;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringToBeConverted = scanner.nextLine().replaceAll("\\s+", "")
                + scanner.nextLine().replaceAll("\\s+", "");

        char[] lettersArray = stringToBeConverted.toCharArray();
        String[] wordsToCheck = new String[]{"pear", "flour", "pork", "olive"};
        List<String> foundWords = new ArrayList<>();
        for (int i = 0; i < wordsToCheck.length; i++) {
            String currentWord = wordsToCheck[i];
            boolean test = isWordValid(lettersArray, currentWord);
            if (test) {
                foundWords.add(currentWord);
            }
        }

        System.out.print("Words found: ");
        System.out.println(foundWords.size());
        for (String foundWord : foundWords) {
            System.out.println(foundWord);
        }
    }

    private static boolean isWordValid(char[] lettersArray, String currentWord) {
        int sumOfMatchedLetters = 0;
        for (int i = 0; i < currentWord.length(); i++) {
            char currCharOfCurrWord = currentWord.charAt(i);
            for (int j = 0; j < lettersArray.length; j++) {
                char charToCheck = lettersArray[j];
                if (charToCheck == currCharOfCurrWord) {
                    sumOfMatchedLetters++;
                    break;
                }
            }
        }
        if (sumOfMatchedLetters == currentWord.length()) {
            return true;
        }
        return false;
    }
}