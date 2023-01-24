import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.Scanner;

public class day02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Type a phrase to find the word 'Nemo':");
        String phrase = scan.nextLine();

        System.out.println(FindNemo(phrase));
    }

    public static String FindNemo(String phrase){

        final String nemo = "Nemo";
        final String failMessage = "I can't find Nemo :(";
        final String successMessage = "I found Nemo at";

        if (phrase.contains(nemo)) {
            char[] charArrayPhrase = phrase.trim().toCharArray();
            char[] nemoArray = nemo.toCharArray();
            int indexNemo = 1;

            for (int i = 0; i < charArrayPhrase.length; i++) {

                boolean foundedNemo = charArrayPhrase[i+1] == nemoArray[0] &&
                        charArrayPhrase[i+2] == nemoArray[1] &&
                        charArrayPhrase[i+3] == nemoArray[2] &&
                        charArrayPhrase[i+4] == nemoArray[3];

                if (charArrayPhrase[i] == ' ' && charArrayPhrase[i+1] != ' ') {
                    indexNemo += 1;
                    if(foundedNemo) break;
                }

            }

            return MessageFormat.format("{0} {1}!", successMessage, indexNemo);
        }
        return failMessage;
    }
}
