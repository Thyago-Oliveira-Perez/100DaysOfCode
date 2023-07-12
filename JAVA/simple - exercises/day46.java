import java.util.ArrayList;
import java.util.List;

public class day46 {

    public static void main(String[] args) {
        System.out.println(PreventDistractions("vines that butter my eggroll"));
        System.out.println(PreventDistractions("Hot pictures of Danny DeVito"));
        System.out.println(PreventDistractions("How to ace BC Calculus in 5 Easy Steps"));
    }

    public static String PreventDistractions (String phrase) {

        final String negativeMessage = "NO!";
        final String positiveMessage = "Safe watching!";

        final List<String> problematicWords = new ArrayList<>(){{
            add("anime");
            add("meme");
            add("vines");
            add("roasts");
            add("Danny DeVito");
        }};

        for (String word : problematicWords) {
            if (phrase.contains(word)) return negativeMessage;
        }

        return positiveMessage;
    }
}
