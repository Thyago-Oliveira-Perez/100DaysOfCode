import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class day24 {

    public static void main(String[] args) {

        System.out.println(MessageFormat.format("Fortunate survivor: {0}", Josephus(41, 3)));
        System.out.println(MessageFormat.format("Fortunate survivor: {0}", Josephus(35, 11)));
        System.out.println(MessageFormat.format("Fortunate survivor: {0}", Josephus(11, 1)));
    }

    public static int Josephus (int numberOfSoldiers, int killInterval) {

        List<Integer> soldiersCircle = CreateList(numberOfSoldiers);
        int i = 0;

        while (soldiersCircle.size() > 1) {
            i = (i + (killInterval - 1)) % soldiersCircle.size();
            soldiersCircle.remove(i);
        }

        return soldiersCircle.get(0);
    }

    public static List<Integer> CreateList (int listSize) {

        List<Integer> newList = new ArrayList<>();

        for (int i = 1 ; i <= listSize ; i ++) {
            newList.add(i);
        }

        return newList;
    }
}
