import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day13 {

    public static void main(String[] args) {

        int[] weights = { 2, 1, 2, 5, 4, 3, 6, 1, 1, 9, 3, 2 };
        int[] weights2 = { 2, 7, 1, 3, 3, 4, 7, 4, 1, 8, 2 };

        System.out.println(MessageFormat.format("{0}", CanFit(weights, 4)));
        System.out.println(MessageFormat.format("{0}", CanFit(weights2, 4)));
    }

    public static boolean CanFit(int[] weights, int numberOfBags){

        int fullBags = 0;

        List<Integer> items = new ArrayList<>(Arrays.stream(weights).boxed().toList());

        for (int i = 0; i < numberOfBags; i++) {

            int bag = 0;
            boolean isPossibleBag = true;

            while (isPossibleBag) {

                List<Integer> passedItems = new ArrayList<>();

                for (int e = 0; e < items.size(); e++) {
                    if ((bag + items.get(e)) > 10) {
                        //REDO se eu faço e++ quando o e vale 2, ele começa a valer 3 e ai quebra o for
                        e++;
                    } else {
                        bag += items.get((e)) ;
                        passedItems.add(items.get(e));
                    }
                }

                for (Integer index: passedItems) {
                    items.remove(index);
                }

                isPossibleBag = false;
            }

            fullBags++;
        }

        if (fullBags == numberOfBags && items.size() == 0) return true;
        return false;
    }
}

/**
 * 2, 7, 1, 3, 3, 4, 7, 4, 1, 8, 2
 * 2, 8 - bag1
 * 2, 7, 1, 3, 3, 4, 7, 4, 1
 * 3, 7 - bag2
 * 2, 1 ,3, 4, 7, 4, 1
 * 2, 4, 4 - bag3
 * 1 ,3, 7, 1
 * 7, 3 - bag4
 * 1, 1
 */
