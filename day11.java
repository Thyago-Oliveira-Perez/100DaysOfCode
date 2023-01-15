import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day11 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Generate IP addresses!");
        System.out.print("Type a number:");
        String userInput = scan.nextLine();

        System.out.println(PossibleIpAddresses(userInput));
    }

    public static String PossibleIpAddresses(String userInput){

        final String failMessage = "Verify if you typed only numbers or the length is between 4 and 12.";

        if (userInput.length() < 4 || userInput.length() > 12) return failMessage;

        //verify if the user input has only numbers
        try {
            Long.parseLong(userInput);
        } catch (Exception e) {
            return failMessage;
        }

        final String successMessage = "Possible IP addresses: ";
        List<String> possibleIpAddresses = new ArrayList<>();

        int length = userInput.length();

        for (int i = 0; i < 3; i++) {

            for (int ii = (i + 1); ii < (i + 4); ii++) {

                for (int e = (ii + 1); e < (ii + 4); e++) {

                    if (e >= (length - 1)) continue;

                    String p1 = userInput.substring(0, i+1);
                    String p2 = userInput.substring((i+1), (ii+1));
                    String p3 = userInput.substring((ii+1), (e+1));
                    String p4 = userInput.substring((e+1), length);

                    if (Verify(p1) && Verify(p2) && Verify(p3) && Verify(p4)) {
                        possibleIpAddresses.add(MessageFormat.format("{0}.{1}.{2}.{3}", p1, p2, p3, p4));
                    }
                }
            }
        }
        return MessageFormat.format("{0}{1}", successMessage, possibleIpAddresses);
    }

    public static boolean Verify(String part){

        if (part.length() == 0 || part.length() > 3) return false;
        if (part.startsWith("0") && part.length() > 1) return false;

        int num = Integer.parseInt(part);

        return num >= 0 && num <= 255;
    }
}
