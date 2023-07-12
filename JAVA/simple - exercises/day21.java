public class day21 {

    public static void main(String[] args) {

        DrawMaze(4, 6);
    }

    public static void DrawMaze (int height, int width) {

        for (int i = 0; i < height ; i++) {

            for (int j = 0; j < width; j++) {
                if ((i == 0 && j < (width - 1)) || i == (height - 1) && j < (width - 1)) {
                    System.out.print("*---");
                } else if (j == 0) {
                    System.out.print("*");
                } else if (j == (width - 1)) {
                    System.out.print("*");
                } else if (Random("col")) {
                    System.out.print("---*");
                } else {
                    System.out.print("     ");
                }
            }

            System.out.print("\n");

            if (i < (height - 1)) {

                for (int j = 0; j < width; j++) {
                    if (j == 0) {
                        System.out.print("|   ");
                    } else if (j == (width - 1)) {
                        System.out.print("|");
                    } else if (Random("row")) {
                        System.out.print(" |  ");
                    } else {
                        System.out.print("     ");
                    }
                }
            }

            System.out.print("\n");
        }
    }

    public static boolean Random (String info) {

        final String col = "col";
        int value;

        value = info.equals(col) ? 40 : 20;

        int randomNumber = (int)Math.floor(Math.random() * 100 + 1);

        if (randomNumber > 0 && value <= randomNumber) {
            return true;
        }
        return false;
    }
}
