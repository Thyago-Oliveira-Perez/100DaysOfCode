import java.text.MessageFormat;
import java.util.*;

public class day32 {

    public static void main(String[] args) {

        List<Integer> rankedScores = new ArrayList<>(){{
            add(100);
            add(90);
            add(90);
            add(80);
        }};

        System.out.println(MessageFormat.format("Classifications -> {0}", PlayerRank(rankedScores, new int[]{70, 80, 105})));
        System.out.println(MessageFormat.format("Classifications -> {0}", PlayerRank(rankedScores, new int[]{106, 107, 105})));
        System.out.println(MessageFormat.format("Classifications -> {0}", PlayerRank(rankedScores, new int[]{106, 95, 105})));
        System.out.println(MessageFormat.format("Classifications -> {0}", PlayerRank(rankedScores, new int[]{106, 92, 92})));
        System.out.println(MessageFormat.format("Classifications -> {0}", PlayerRank(rankedScores, new int[]{70, 80, 105, 55})));
    }

    public static List<Integer> PlayerRank (List<Integer> rankedScores, int[] playerScores) {

        List<Integer> classifications = new ArrayList<>();

        int top1 = Collections.max(rankedScores);
        int top2 = Collections.max(rankedScores.stream().filter(e -> e != top1).toList());
        int top3 = Collections.max(rankedScores.stream().filter(e -> e != top1 && e != top2).toList());
        int position = 3;

        for (int score : playerScores) {
            if (score >= top1) {
                classifications.add(1);
            } else if (score >= top2) {
                classifications.add(2);
            } else if (score >= top3) {
                classifications.add(3);
            } else {
                classifications.add(position + 1);
                position++;
            }
        }

        return classifications;
    }
}
