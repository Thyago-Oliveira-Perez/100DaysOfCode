import java.text.MessageFormat;
import java.util.Scanner;

public class day10 {

    public static void main(String[] args) {

        final String failMessage = "Only numbers!";

        Scanner scan = new Scanner(System.in);

        System.out.print("Type a number: ");
        String userInput = scan.nextLine();

        try{
            int input = Integer.parseInt(userInput);

            System.out.println(BinarySearchTrees(input));
        }catch (Exception e){
            System.out.println(failMessage);
        }
    }

    public static String BinarySearchTrees(int input){

        final String successMessage = "Number of BST's";
        final String incorrectInputMessage = "Number must be bigger than 1 and smaller than 19.";

        if (input <= 1 || input >= 19) return incorrectInputMessage;

        int bts = 1;

        for (int i = 0; i < input; i++) {
            bts = bts + (2 * Math.getExponent(input + 1) - 1);
        }

        bts = bts / 2;

        return MessageFormat.format("{0}: {1}", successMessage, bts);
    }
}
