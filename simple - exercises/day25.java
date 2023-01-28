import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class day25 {

    public static void main(String[] args) {
        System.out.println(MessageFormat.format("{0}", CoinsDiv(new int[]{1, 2, 3, 2, 2, 2, 3})));
        System.out.println(MessageFormat.format("{0}", CoinsDiv(new int[]{5, 3, 10, 1, 2})));
        System.out.println(MessageFormat.format("{0}", CoinsDiv(new int[]{2, 4, 3, 2, 4, 9, 7, 8, 6, 9})));
    }

    public static boolean CoinsDiv(int[] coins){

        final int numberOfChildren = 3;

        int maxOfMoney = Arrays.stream(coins).sum();

        int combinationValue = maxOfMoney / numberOfChildren;

        List<Integer> coinsList = new ArrayList<>(Arrays.stream(coins).boxed().toList());

        //order the items
        Collections.sort(coinsList);

        for (int i = 0; i < numberOfChildren; i++) {

            int combination = 0;
            boolean rightDivision = true;

            while (rightDivision) {

                List<Integer> coinsAlreadyCounted = new ArrayList<>();

                for (int e = (coinsList.size() - 1); e > -1; e--) {
                    if ((combination + coinsList.get(e)) <= combinationValue) {
                        combination += coinsList.get(e);
                        coinsAlreadyCounted.add(coinsList.get(e));
                    }
                }

                for (Integer index: coinsAlreadyCounted) {
                    coinsList.remove(index);
                }

                rightDivision = false;
            }
        }

        return coinsList.size() == 0 ? true : false;
    }
}
