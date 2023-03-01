import java.text.MessageFormat;

public class day60 {

    public static void main(String[] args) {
        GameOfThree(100);
        GameOfThree(300);
        GameOfThree(30);
        GameOfThree(150);
    }

    public static void GameOfThree (int value) {

        double result = value;

        while (result != 1.0) {
            if (Double.toString(result / 3).split("\\.")[1].equals("0")) {
                System.out.println(MessageFormat.format("{0} {1}", result, 0));
                result = result / 3;
            } else {
                if (Double.toString((result - 1) / 3).split("\\.")[1].equals("0")) {
                    System.out.println(MessageFormat.format("{0} {1}", result, -1));
                    result = (result - 1) / 3;
                } else if (Double.toString((result + 1) / 3).split("\\.")[1].equals("0")) {
                    System.out.println(MessageFormat.format("{0} {1}", result, +1));
                    result = (result + 1) / 3;
                }
            }
        }
        System.out.println((int)result);
        System.out.println();
    }
}
