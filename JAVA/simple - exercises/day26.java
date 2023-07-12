import java.text.MessageFormat;

public class day26 {

    public static void main(String[] args) {

        System.out.println(MessageFormat.format("Minimum turns -> {0}", MinTurns("4089", "5672")));
        System.out.println(MessageFormat.format("Minimum turns -> {0}", MinTurns("1111", "1100")));
        System.out.println(MessageFormat.format("Minimum turns -> {0}", MinTurns("2391", "4984")));
    }

    public static int MinTurns (String currentLock, String targetLock) {

        char[] currentLockArray = currentLock.toCharArray();
        char[] targetLockArray = targetLock.toCharArray();

        int way = 0;

        for (int i = 0 ; i < currentLockArray.length ; i++) {

            int key = Integer.parseInt(String.valueOf(currentLockArray[i]));
            int nextKey = Integer.parseInt(String.valueOf(targetLockArray[i]));

            if (key <= 5 && nextKey <= 5 || key > 5 && nextKey > 5) {
                way += ToPositive((key - nextKey));
            }

            if (key > 5 && nextKey < 5) {
                way += ToPositive(((10 - key) + nextKey));
            }

            if (key < 5 && nextKey > 5) {
                way += ToPositive(((10 - nextKey) + key));
            }
        }

        return way;
    }

    public static int ToPositive (int number) {
        if (number < 0) return number * (-1);
        return number;
    }
}
