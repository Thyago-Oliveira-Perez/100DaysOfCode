import java.util.ArrayList;
import java.util.List;

public class day50 {

    public static void main(String[] args) {

        List<char[]> game1 = new ArrayList<>(){{
            add(new char[]{'X', 'O', 'O'});
            add(new char[]{'O', 'X', 'O'});
            add(new char[]{'O', '#', 'X'});
        }};

        List<char[]> game2 = new ArrayList<>(){{
            add(new char[]{'X', 'O', 'O'});
            add(new char[]{'O', 'X', 'O'});
            add(new char[]{'X', '#', 'O'});
        }};

        List<char[]> game3 = new ArrayList<>(){{
            add(new char[]{'X', 'X', 'O'});
            add(new char[]{'O', 'X', 'O'});
            add(new char[]{'X', 'O', '#'});
        }};

        System.out.println(TicTacToe(game1));
        System.out.println(TicTacToe(game2));
        System.out.println(TicTacToe(game3));
    }

    public static String TicTacToe (List<char[]> game) {

        /*
         * Player 1 is X
         * Player 2 is O
         * # is a blank space
         */

        final String TieMessage = "It's a Tie.";

        if (Line(game, 0, 'X') || Line(game, 1, 'X') || Line(game, 2, 'X') ||
            Column(game, 0, 'X') || Column(game, 1, 'X') || Column(game, 2, 'X') ||
            Horizontal(game, 0, 'X') || Horizontal(game, 2, 'X')
        ) {
            return "Player 1 wins!";
        } else if (Line(game, 0, 'O') || Line(game, 1, 'O') || Line(game, 2, 'O') ||
                   Column(game, 0, 'O') || Column(game, 1, 'O') || Column(game, 2, 'O') ||
                   Horizontal(game, 0, 'O') || Horizontal(game, 2, 'O')
        ) {
            return "Player 2 wins!";
        }

        return TieMessage;
    }

    public static boolean Line (List<char[]> game, int position, char check) {
        return game.get(position)[0] == check && game.get(position)[1] == check && game.get(position)[2] == check;
    }

    public static boolean Column (List<char[]> game, int position, char check) {
        return game.get(0)[position] == check && game.get(1)[position] == check && game.get(2)[position] == check;
    }

    public static boolean Horizontal (List<char[]> game, int position, char check) {
        if (position == 0) {
            return game.get(0)[position] == check && game.get(1)[position + 1] == check && game.get(2)[position + 2] == check;
        } else if (position == 2) {
            return game.get(0)[position] == check && game.get(1)[position - 1] == check && game.get(2)[position - 2] == check;
        } else {
            System.out.print("Invalid position: 1. Default return false");
        }
        return false;
    }
}
