import java.text.MessageFormat;
import java.util.Scanner;

public class day18 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Height: ");
        String height = scan.nextLine();

        System.out.print("Width: ");
        String width = scan.nextLine();

        System.out.println(MessageFormat.format("Possible paths: {0}", UniquePaths(Integer.parseInt(height), Integer.parseInt(width))));
    }

    public static int UniquePaths (int height, int width) {

        int paths = 1;

        for (int i = 1; i < width; i++) {
            paths += i+1;
        }

        return paths;
    }
}
