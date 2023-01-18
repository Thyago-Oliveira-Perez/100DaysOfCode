import java.text.MessageFormat;
import java.util.Scanner;

public class day15 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Type the first word:");
        String firstWord = scan.nextLine();

        System.out.print("Type the second word:");
        String secondWord = scan.nextLine();

        System.out.println(MessageFormat.format("Is it an anagram? {0}", ValidAnagram(firstWord, secondWord)));
    }

    public static boolean ValidAnagram(String firstWord, String secondWord){

        boolean allWordsEquals = true;

        if (firstWord.length() == secondWord.length()) {
            char[] firstWordArray = firstWord.toCharArray();

            for (int i = 0; i < firstWord.length(); i++) {
                if (!secondWord.contains(String.valueOf(firstWordArray[i]))) {
                    allWordsEquals = false;
                    break;
                }
            }
        } else {
            allWordsEquals = false;
        }

        return allWordsEquals;
    }
}
