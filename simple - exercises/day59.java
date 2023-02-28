import java.util.Arrays;

public class day59 {

    public static void main(String[] args) {
        System.out.println(BalancedBonus("xxxyyyzzz"));
        System.out.println(BalancedBonus("abccbaabccba"));
        System.out.println(BalancedBonus("xxxyyyzzzz"));
        System.out.println(BalancedBonus("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(BalancedBonus("pqq"));
        System.out.println(BalancedBonus("fdedfdeffeddefeeeefddf"));
        System.out.println(BalancedBonus("www"));
        System.out.println(BalancedBonus("x"));
        System.out.println(BalancedBonus(""));
    }

    public static boolean BalancedBonus (String sequence) {

        char[] sequenceArray = sequence.toLowerCase().toCharArray();
        Arrays.sort(sequenceArray);
        int occurrence = 1;
        int occurrence2 = 0;

        if (sequence.length() == 0 || sequence.length() == 1) return true;

        for (int i = 0 ; i < sequenceArray.length ; i++) {

            if (i+1 < sequenceArray.length) {
                if (sequenceArray[i] == sequenceArray[i+1]) {
                    occurrence++;
                } else {

                    if (occurrence != 0 && occurrence2 != 0 && occurrence2 != occurrence) {
                        return false;
                    }

                    occurrence2 = occurrence;
                    occurrence = 1;
                }
            }
        }

        if (occurrence != 0 && occurrence2 != 0 && occurrence2 != occurrence) return false;

        return true;
    }
}
