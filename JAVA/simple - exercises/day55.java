import java.util.ArrayList;
import java.util.List;

public class day55 {

    public static void main(String[] args) {
        System.out.println(IdenticalFilter(new String[]{"aaaaaa", "bc", "d", "eeee", "xyz"}));
        System.out.println(IdenticalFilter(new String[]{"88", "999", "22", "545", "133"}));
        System.out.println(IdenticalFilter(new String[]{"xxxxo", "oxo", "xox", "ooxxoo", "oxo"}));
    }

    public static List<String> IdenticalFilter (String[] strings) {

        List<String> onlyRepeated = new ArrayList<>();

        for (String string : strings) {

            boolean diff = false;
            char[] pieces = string.toCharArray();

            for (char piece : pieces) {
                if (piece != pieces[0]) {
                    diff = true;
                    break;
                }
            }

            if (!diff) onlyRepeated.add(string);
        }

        return onlyRepeated;
    }
}
