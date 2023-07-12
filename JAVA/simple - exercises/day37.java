import java.util.Arrays;

public class day37 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(BreakingRecords(new int[]{10,5,20,20,4,5,2,25,1})));
    }

    public static int[] BreakingRecords (int[] scores) {

        /*
         * position 0: indicates how many times the player breaks his maximum points record
         * position 1: indicates how many times the player breaks his minimum points record
         */
        int[] recordBreaks = new int[]{0,0};

        int minimum = 0;
        int maximum = 0;

        for (int score : scores) {

            if (maximum == 0 && minimum == 0) {
                maximum = score;
                minimum = score;
            } else {
                if (score > maximum) {
                    maximum = score;
                    recordBreaks[0] += 1;
                } else if (score < minimum) {
                    minimum = score;
                    recordBreaks[1] += 1;
                }
            }
        }

        return recordBreaks;
    }
}
