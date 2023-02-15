public class day48 {

    public static void main(String[] args) {
        DrawChristmasTree(1);
        DrawChristmasTree(2);
        DrawChristmasTree(5);
        DrawChristmasTree(0);
    }

    public static void DrawChristmasTree (int height) {

        for (int j = 1 ; j <= height ; j++) {
            for (int i = 1 ; i <= (height - j) ; i++) {
                System.out.print(" ");
            }
            for (int i = 1 ; i <= ((j * 2) - 1) ; i++) {
                System.out.print("#");
            }
            for (int i = 1 ; i <= (height - j) ; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
