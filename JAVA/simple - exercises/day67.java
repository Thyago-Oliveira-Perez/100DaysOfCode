import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class day67 {

    public static void main(String[] args) {

        char[][] maze1 = {
            {'R','O','G'},
            {'W','R','W'},
            {'G','O','R'},
            {'O','R','W'},
        };

        char[][] maze2 = {
            {'R','O','G'},
            {'W','R','W'},
            {'G','O','O'},
            {'O','R','W'},
        };

        char[][] maze3 = {
            {'C','O','R','O','Y'},
            {'O','R','V','G','R'},
            {'G','O','G','O','T'},
            {'Y','G','B','Y','G'},
            {'R','O','R','B','R'},
        };

       System.out.println("SOLUTION:" + ColorMaze(maze1, new char[]{'R','W'}));
       System.out.println("SOLUTION:" + ColorMaze(maze2, new char[]{'R','W'}));
       System.out.println("SOLUTION:" + ColorMaze(maze3, new char[]{'O','G'}));
    }

    public static List<String> ColorMaze(char[][] maze, char[] seq) {

        /*
         * the path always finished at the top, so, it means that it finished at y = 0, example: 3, 0
         */
        List<String> finalPath = new ArrayList<>();
        List<int[]> path = new ArrayList<>();

        int[] start = null;

        for (int j = 0; j < maze[0].length; j++) {
            if (maze[maze.length - 1][j] == seq[0]) {
                start = new int[]{maze.length - 1, j};
                break;
            }
        }

        if (start == null) return null;

        path.add(start);
        finalPath.add(IntArrayToString(start));

        int j;
        while (true) {

            int[] actualPosition = path.get(path.size() - 1);
            int x = actualPosition[0];
            j = 1;
            for (int i = 0; i < seq.length; i++) {
                char curr_color = seq[j];
                int[] curr_pos = path.get(path.size() - 1);
                boolean found_next = false;
                // look for next color in adjacent nodes
                int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                for (int[] dir : directions) {
                    int[] next_pos = {curr_pos[0] + dir[0], curr_pos[1] + dir[1]};
                    if (next_pos[0] < 0 || next_pos[0] >= maze.length || next_pos[1] < 0 || next_pos[1] >= maze[0].length) {
                        continue;
                    }
                    if (maze[next_pos[0]][next_pos[1]] == curr_color) {
                        if (!finalPath.contains(IntArrayToString(next_pos))) {
                            path.add(next_pos);
                            finalPath.add(IntArrayToString(next_pos));
                            found_next = true;
                            break;
                        }
                    }
                }

                if (x == 0) break;

                if (!found_next) {
                    return new ArrayList<>(){{
                        add("NO SOLUTION!");
                    }};
                }
                j = 0;
            }

            if (x == 0) break;
        }

        return finalPath;
    }

    public static String IntArrayToString (int[] step) {
        return MessageFormat.format("({0},{1})", step[0], step[1]);
    }
}
