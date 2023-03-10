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
            {'G','O','G','O','G'},
            {'Y','G','B','Y','G'},
            {'R','O','R','B','R'},
        };
        
        char[][] maze4 = {
            {'B','O','R','O','Y'},
            {'O','R','B','G','R'},
            {'B','O','G','O','Y'},
            {'Y','G','B','Y','G'},
            {'R','O','R','B','R'},
        };

        char[][] maze5 = {
            {'G','O','R','O','Y'},
            {'O','R','B','C','R'},
            {'G','O','G','O','G'},
            {'Y','G','B','Y','G'},
            {'R','O','R','B','R'},
        };

        char[][] maze6 = {
            {'R','R','B','R','R','R','B','P','Y','G','P','B','B','B','G','P','B','P','P','R'},
            {'B','G','Y','P','R','P','Y','Y','O','R','Y','P','P','Y','Y','R','R','R','P','P'},
            {'B','P','G','R','O','P','Y','G','R','Y','Y','G','P','O','R','Y','P','B','O','O'},
            {'R','B','B','O','R','P','Y','O','O','Y','R','P','B','R','G','R','B','G','P','G'},
            {'R','P','Y','G','G','G','P','Y','P','Y','O','G','B','O','R','Y','P','B','Y','O'},
            {'O','R','B','G','B','Y','B','P','G','R','P','Y','R','O','G','Y','G','Y','R','P'},
            {'B','G','O','O','O','G','B','B','R','O','Y','Y','Y','Y','P','B','Y','Y','G','G'},
            {'P','P','G','B','O','P','Y','G','B','R','O','G','B','G','R','O','Y','R','B','R'},
            {'Y','Y','P','P','R','B','Y','B','P','O','O','G','P','Y','R','P','P','Y','R','Y'},
            {'P','O','O','B','B','B','G','O','Y','G','O','P','B','G','Y','R','R','Y','R','B'},
            {'P','P','Y','R','B','O','O','R','O','R','Y','B','G','B','G','O','O','P','B','Y'},
            {'B','B','R','G','Y','G','P','Y','G','P','R','R','P','Y','G','O','O','Y','R','R'},
            {'O','G','R','Y','B','P','Y','O','P','B','R','Y','B','G','P','G','O','O','B','P'},
            {'R','Y','G','P','G','G','O','R','Y','O','O','G','R','G','P','P','Y','P','B','G'},
            {'P','Y','P','R','O','O','R','O','Y','R','P','O','R','Y','P','Y','B','B','Y','R'},
            {'O','Y','P','G','R','P','R','G','P','O','B','B','R','B','O','B','Y','Y','B','P'},
            {'B','Y','Y','P','O','Y','O','Y','O','R','B','R','G','G','Y','G','R','G','Y','G'},
            {'Y','B','Y','Y','G','B','R','R','O','B','O','P','P','O','B','O','R','R','R','P'},
            {'P','O','O','O','P','Y','G','G','Y','P','O','G','P','O','B','G','P','R','P','B'},
            {'R','B','B','R','R','R','R','B','B','B','Y','O','B','G','P','G','G','O','O','Y'},
        };
        
       ColorMaze(maze1, new char[]{'R','W'}).forEach(System.out::println);
       System.out.println();
       ColorMaze(maze2, new char[]{'R','W'}).forEach(System.out::println);
       System.out.println();
       ColorMaze(maze3, new char[]{'O','G'}).forEach(System.out::println);
       System.out.println();
       ColorMaze(maze4, new char[]{'O','G'}).forEach(System.out::println);
       System.out.println();
       ColorMaze(maze5, new char[]{'O','G'}).forEach(System.out::println);
       System.out.println();
       ColorMaze(maze6, new char[]{'R','O','Y','P','O'}).forEach(System.out::println);
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

        while (true) {

            int[] actualPosition = path.get(path.size() - 1);
            int x = actualPosition[0];
            int y = actualPosition[1];

            for (int c = 0 ; c < seq.length ; c++) {
                for (int i = 1 ; i <= 3 ; i++) {
                    switch (i) {
                        case 1: {
                            if (y - 1 >= 0 && maze[x][y - 1] == seq[c]) {
                                String step = IntArrayToString(new int[]{x, y - 1});
                                if (!finalPath.contains(step)) {
                                    path.add(new int[]{x, y - 1});
                                    finalPath.add(step);
                                }
                                break;
                            }
                            break;
                        }
                        case 2: {
                            if (x - 1 >= 0 && maze[x - 1][y] == seq[c]) {
                                String step = IntArrayToString(new int[]{x - 1, y});
                                if (!finalPath.contains(step)) {
                                    path.add(new int[]{x - 1, y});
                                    finalPath.add(step);
                                }
                                break;
                            }
                            break;
                        }
                        case 3: {
                            if (y + 1 < maze[0].length && maze[x][y + 1] == seq[c]) {
                                String step = IntArrayToString(new int[]{x, y + 1});
                                if (!finalPath.contains(step)) {
                                    path.add(new int[]{x, y + 1});
                                    finalPath.add(step);
                                }
                                break;
                            }
                            break;
                        }
                    }
                }
            }

            if (x == 0 && y == 0) break;
        }

        return finalPath;
    }

    public static String IntArrayToString (int[] step) {
        return MessageFormat.format("({0},{1})", step[0], step[1]);
    }
}
