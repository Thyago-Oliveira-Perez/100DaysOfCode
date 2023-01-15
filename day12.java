import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class day12 {

    public static void main(String[] args) {

        final Integer[] exampleMountain = {3,4,5,4,3,};
        final Integer[] exampleMountain2 = {3,4,5,9,7,5,4,3,1};
        final Integer[] exampleValley = {9,7,3,1,2,4};
        final Integer[] exampleValley2 = {9,8,9};
        final Integer[] exampleNeither = {9,8,9,8};
        final Integer[] exampleNeither2 = {9,8};

        System.out.println(LandscapeType(exampleMountain));
        System.out.println(LandscapeType(exampleMountain2));
        System.out.println(LandscapeType(exampleValley));
        System.out.println(LandscapeType(exampleValley2));
        System.out.println(LandscapeType(exampleNeither));
        System.out.println(LandscapeType(exampleNeither2));
    }

    public static String LandscapeType(Integer[] userInput){

        final String mountain = "mountain";
        final String valley= "valley";
        final String neither = "neither";

        final String returnMessage = "LandscapeType";

        if (userInput.length < 3 ) return MessageFormat.format("{0}({1}) -> {2}", returnMessage, Arrays.stream(userInput).toList(), neither);

        int numbersLeft = 0;
        int numberIncreasing = 0;

        int numbersRight = 0;
        int numberDecreasing = 0;

        int peak = Collections.max(List.of(userInput));
        int trough = Collections.min(List.of(userInput));


        for (int i = 0 ; i < userInput.length; i++) {

            if (i+1 >= userInput.length) break;

            if (userInput[i] == peak) {
                numbersLeft = i;
                numbersRight = userInput.length - (i+1);
            }

            if (userInput[i] == trough) {
                numbersLeft = i;
                numbersRight = userInput.length - (i+1);
            }

            if (userInput[i] < userInput[i+1]) {
                numberIncreasing++;
            }

            if (userInput[i] > userInput[i+1]) {
                numberDecreasing++;
            }
        }

        if (numbersLeft == numberIncreasing && numbersRight == numberDecreasing && peak != userInput[0] && peak != userInput[userInput.length-1]) {
            return MessageFormat.format("{0}({1}) -> {2}", returnMessage, Arrays.stream(userInput).toList(), mountain);
        }

        if (numbersLeft == numberDecreasing && numbersRight == numberIncreasing && trough != userInput[0] && trough != userInput[userInput.length-1]) {
            return MessageFormat.format("{0}({1}) -> {2}", returnMessage, Arrays.stream(userInput).toList(), valley);
        }

        return MessageFormat.format("{0}({1}) -> {2}", returnMessage, Arrays.stream(userInput).toList(), neither);
    }
}
