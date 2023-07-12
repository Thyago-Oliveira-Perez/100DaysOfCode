import java.util.ArrayList;
import java.util.List;

public class day64 {

    public static void main(String[] args) {
        System.out.println(FirstRecurringCharacter("ABCDEBC"));
        System.out.println(FirstRecurringCharacter("ABcDec"));
        System.out.println(FirstRecurringCharacter("ABBA"));
        System.out.println(FirstRecurringCharacter("ABCDEEC"));
        System.out.println(FirstRecurringCharacter("ABCDEFGHI"));
    }

    public static String FirstRecurringCharacter (String word) {

        List<Character> arrayAux = new ArrayList<>();

        for (Character letter : word.toUpperCase().toCharArray()) {
            if (arrayAux.contains(letter)) {
                return String.valueOf(letter);
            } else {
                arrayAux.add(letter);
            }
        }
        return "There isn't any recurring character.";
    }
}
