import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class day31 {

    public static void main(String[] args) {

        System.out.println(TimeInWords(5, 0));
        System.out.println(TimeInWords(5, 1));
        System.out.println(TimeInWords(5, 10));
        System.out.println(TimeInWords(5, 15));
        System.out.println(TimeInWords(5, 30));
        System.out.println(TimeInWords(5, 40));
        System.out.println(TimeInWords(5, 45));
        System.out.println(TimeInWords(5, 47));
        System.out.println(TimeInWords(5, 28));
    }

    public static String TimeInWords (int hours, int minutes) {

        final String errorMessage = "Invalid input!";
        String finalMessage = "";

        if (hours < 1 || hours > 12 || minutes < 0 || minutes > 60) return errorMessage;

        if (minutes == 0) {
            return MessageFormat.format("{0} o` clock", Integer.toString(hours));
        }

        final Map<Integer, String> numberToName = new HashMap<>(){{
            put(1, "one");
            put(2, "two");
            put(3, "three");
            put(4, "four");
            put(5, "five");
            put(6, "six");
            put(7, "seven");
            put(8, "eight");
            put(9, "nine");
            put(10, "ten");
            put(11, "eleven");
            put(12, "twelve");
            put(13, "thirteen");
            put(14, "fourteen");
            put(15, "quarter");
            put(16, "sixteen");
            put(17, "seventeen");
            put(18, "eighteen");
            put(19, "nineteen");
            put(20, "twenty");
            put(21, "twenty one");
            put(22, "twenty two");
            put(23, "twenty three");
            put(24, "twenty four");
            put(25, "twenty five");
            put(26, "twenty six");
            put(27, "twenty seven");
            put(28, "twenty eight");
            put(29, "twenty nine");
            put(30, "half");
        }};

        if (minutes > 30) {
            int diff = (60 - minutes);
            if (diff == 15) {
                finalMessage = MessageFormat.format("{0} to {1}", numberToName.get(diff), numberToName.get((hours + 1)));
            } else {
                finalMessage = MessageFormat.format("{0} minute(s) to {1}", numberToName.get(diff), numberToName.get((hours + 1)));
            }
        }

        if (minutes < 30) {
            if (minutes == 15) {
                finalMessage = MessageFormat.format("{0} past {1}", numberToName.get(minutes), numberToName.get(hours));
            } else {
                finalMessage = MessageFormat.format("{0} minute(s) past {1}", numberToName.get(minutes), numberToName.get(hours));
            }
        }

        if (minutes == 30) {
            finalMessage = MessageFormat.format("{0} past {1}", numberToName.get(minutes), numberToName.get(hours));
        }

        return finalMessage;
    }
}