import java.util.Arrays;

public class day41 {

    public static void main(String[] args) {
        System.out.println(ManyPairsOfSocksPerColor(new int[]{1,2,1,1,2,1,3,2,2}));
    }

    public static int ManyPairsOfSocksPerColor (int[] socks) {

        int numberOfPairs = 0;

        Arrays.sort(socks);

        int numberOfSocks = 1;

        for (int i = 0 ; i < socks.length ; i++) {

            int value = socks[i];

            if ((i+1) < socks.length) {
                if (value == socks[i+1]) {
                    numberOfSocks++;
                } else {
                    int pair = numberOfSocks / 2;
                    numberOfPairs += pair;
                    numberOfSocks = 1;
                }
            } else {
                int pair = numberOfSocks / 2;
                numberOfPairs += pair;
                numberOfSocks = 1;
            }
        }

        return numberOfPairs;
    }
}
