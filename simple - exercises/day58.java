import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class day58 {

    public static void main(String[] args) {

        List<String> dices = new ArrayList<>(){{
            add("3d6");
            add("4d12");
            add("1d10");
            add("5d4");
        }};

        System.out.println(DiceRoller(dices));
    }

    public static List<String> DiceRoller (List<String> dices) {

        /*
         * 3d6
         * first number -> number of rolls
         * second number -> how many sides the dice have
         * d -> used to split up the numbers
         */

        List<String> finalMessage = new ArrayList<>();

        for (String dice : dices) {

            List<Integer> numbers = new ArrayList<>();
            StringBuilder message = new StringBuilder();
            int sum = 0;
            int rolls = Integer.parseInt(String.valueOf(dice.split("d")[0]));
            int sides = Integer.parseInt(String.valueOf(dice.split("d")[1]));

            for (int i = 0 ; i < rolls ; i++) {
                numbers.add((int)(Math.random() * sides));
            }

            for (int number : numbers) {
                sum += number;
                message.append(MessageFormat.format("{0} ", number));
            }

            finalMessage.add(MessageFormat.format("{0}: {1}", sum, message));
        }

        return finalMessage;
    }
}
