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
        System.out.println(MessageFormat.format("Classifications -> {0}", PlayerRank(rankedScores, new int[]{55, 80, 105, 70})));
    }

    public static List<Integer> PlayerRank (List<Integer> rankedScores, int[] playerScores) {

        List<Integer> classifications = new ArrayList<>();
        int[] scores = new int[playerScores.length];

        List<Integer> playerScoresList = new ArrayList<>();
        for (int score : playerScores) playerScoresList.add(score);
        Collections.sort(playerScoresList);

        for (int i = 0 ; i < playerScoresList.size() ; i++) {
            for (int j = 0 ; j < playerScores.length ; j++) {
                if (playerScores[j] == playerScoresList.get(i)) {
                    if (playerScores[j] >= 100) {
                        scores[j] = 1;
                    } else {
                        scores[j] = (playerScoresList.size() - i);
                    }
                }
            }
        }

        for (int i : scores) classifications.add(i);

        return classifications;
    }
}
