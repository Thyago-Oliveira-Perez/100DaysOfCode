import java.text.MessageFormat;

public class day56 {

    public static void main(String[] args) {
        System.out.println(ToHex("hello world"));
        System.out.println(ToHex("Big Boi")); 
        System.out.println(ToHex("Marty Poppinson"));
    }

    public static String ToHex (String message) {

        StringBuilder convertedToHex = new StringBuilder();

        char[] messageArray = message.toCharArray();

        for (char letter : messageArray) {
            convertedToHex.append(MessageFormat.format("{0} ", Integer.toString(letter, 16)));
        }

        return convertedToHex.toString();
    }
}
