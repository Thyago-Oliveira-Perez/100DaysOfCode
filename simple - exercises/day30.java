import java.text.MessageFormat;
import java.util.Arrays;

public class day30 {

    public static void main(String[] args) {

        System.out.println(MessageFormat.format("result -> {0}", TheMaximumValue(276, 3)));
        System.out.println(MessageFormat.format("result -> {0}", TheMaximumValue(-999, 4)));
        System.out.println(MessageFormat.format("result -> {0}", TheMaximumValue(0, 3)));
        System.out.println(MessageFormat.format("result -> {0}", TheMaximumValue(860, 7)));
        System.out.println(MessageFormat.format("result -> {0}", TheMaximumValue(9560, 7)));
    }

    public static int TheMaximumValue (int originalValue, int digit) {

        char[] valueArray = Integer.toString(originalValue).toCharArray();
        char[] newValueArray = new char[(valueArray.length + 1)];
        char digitChar = Integer.toString(digit).toCharArray()[0];
        boolean isNegative = originalValue < 0 ? true : false;

        if (valueArray.length == 1) {
            newValueArray[0] = valueArray[0];
            newValueArray[1] = digitChar;

            return Integer.parseInt(String.valueOf(BubbleSort(newValueArray, isNegative)));
        }

        for (int i = (newValueArray.length - 1) ; i >= 0 ; i--) {

            if (i == valueArray.length - 3) {
                newValueArray[i] = digitChar;
            } else {
                if ((i-1) < 0) {
                    newValueArray[i] = valueArray[0];
                } else {
                    newValueArray[i] = valueArray[i-1];
                }
            }
        }

        char[] auxArray = new char[2];

        for (int i = 0 ; i < newValueArray.length ; i++) {

            if (newValueArray[i] == digitChar) {
                auxArray = BubbleSort(new char[]{newValueArray[i], newValueArray[i+1]}, isNegative);
            }
        }

        for (int i = (newValueArray.length - 1) ; i >= 0 ; i--) {

            if (i == valueArray.length - 3) {
                newValueArray[i] = auxArray[0];
                newValueArray[i+1] = auxArray[1];
            } else {
                if ((i-1) < 0) {
                    newValueArray[i] = valueArray[0];
                } else {
                    newValueArray[i] = valueArray[i-1];
                }
            }
        }

        return Integer.parseInt(String.valueOf(newValueArray));
    }

    public static char[] BubbleSort (char[] array, boolean isNegative) {

        if (isNegative) {
            Arrays.sort(array);
            return array;
        } else {
            for (int i = 0 ; i < array.length ; i++) {

                if ((i+1) < array.length && array[i] < array[i + 1]) {
                    char temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        return array;
    }
}
