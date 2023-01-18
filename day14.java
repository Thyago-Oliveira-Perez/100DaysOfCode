import java.text.MessageFormat;
import java.util.Scanner;

public class day14 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Type an word to encrypt:");
        String wordToEncrypt = scan.nextLine();

        System.out.println(MessageFormat.format("Encrypted word: {0}", KaracasEncrypt(wordToEncrypt)));
    }

    public static String KaracasEncrypt(String wordToEncrypt){

        char[] letters = wordToEncrypt.toCharArray();
        char[] newWord = new char[letters.length];

        for (int i = (letters.length - 1), o = 0; i >= 0; i--, o++) {
            switch (letters[i]) {
                case 'a' -> newWord[o] = '0';
                case 'e' -> newWord[o] = '1';
                case 'i' -> newWord[o] = '2';
                case 'o' -> newWord[o] = '3';
                case 'u' -> newWord[o] = '4';
                default -> newWord[o] = letters[i];
            }
        }

        //encrypted word
        return MessageFormat.format("{0}aca", String.valueOf(newWord));
    }
}
