import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class day28 {

    public static void main(String[] args) {

        List<String> wordsToSearch = new ArrayList<>(){{
            add("oath");
            add("pea");
            add("eat");
            add("rain");
        }};
        List<Character[]> board = new ArrayList<>(){{
            add(new Character[]{'o','a','a','n'});
            add(new Character[]{'a','t','a','e'});
            add(new Character[]{'e','h','k','r'});
            add(new Character[]{'p','f','l','v'});
            add(new Character[]{'n','i','a','r'});
        }};

        System.out.println(MessageFormat.format("Founded: {0}", WordSearch(board, wordsToSearch)));

    }

    public static List<String> WordSearch (List<Character[]> board, List<String> wordsToSearch) {

        List<String> foundedWords = new ArrayList<>();

        for (int i = 0 ; i < board.size() ; i++) {

            List<Character> possibleWord = new ArrayList<>();

            for (int x = 0 ; x < board.get(0).length ; x++) {
                int p = 0;
                for (int y = i ; y < board.size() ; y++) {
                    while (p < x) {
                        possibleWord.add(board.get(y)[p]);
                        p++;
                    }
                    possibleWord.add(board.get(y)[p]);
                }

                String word = possibleWord.toString()
                        .substring(1, 3 * possibleWord.size() - 1)
                        .replaceAll(", ", "");

                String searchAbleWord = FindWord(word, wordsToSearch);

                if (!searchAbleWord.isEmpty() && !foundedWords.contains(searchAbleWord)) foundedWords.add(searchAbleWord);

                possibleWord = new ArrayList<>();
            }
        }

        return foundedWords;
    }

    public static String FindWord (String line, List<String> wordsToSearch) {

        for (String word : wordsToSearch) {
            if (line.contains(word)) {
                return word;
            } else {
                //invert the line and validate again
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(line);
                stringBuilder.reverse();

                if (stringBuilder.toString().contains(word)) {
                    return word;
                }
            }

        }

        return "";
    }
}
