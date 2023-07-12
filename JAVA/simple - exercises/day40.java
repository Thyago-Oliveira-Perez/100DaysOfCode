import java.util.Arrays;

public class day40 {

    public static void main(String[] args) {

        System.out.println(LarryArray(new int[]{1, 6, 5, 2, 4, 3}));
        System.out.println(LarryArray(new int[]{6, 2, 10, 3, 7, 1, 5, 8, 4, 9}));
    }

    public static boolean LarryArray (int[] numbers) {

        int value = 1;
        int ind = 0;

        for (int i = 0 ; i < numbers.length ; i++) {

            if (value == numbers[i]) {
                value++;
            } else {
                if ((i+2) < numbers.length) {
                    if (numbers[i] == value || numbers[i+1] == value || numbers[i+2] == value) {
                        int j=1;
                        while (numbers[i] != value) {
                            int[] aux = Order(new int[]{numbers[i], numbers[i+1], numbers[i+2]}, j);
                            numbers[i] = aux[0];
                            numbers[i+1] = aux[1];
                            numbers[i+2] = aux[2];
                            j++;
                        }
                        i -= ind+1;
                        ind = 0;
                    } else {
                        ind++;
                    }
                }
            }
        }
        System.out.print(Arrays.toString(numbers));
        return true;
    }

    public static int[] Order (int[] array, int wayToOrder) {
        /*
         * wayToOrder
         * 1 - ABC
         * 2 - BCA
         * 3 - CAB
         */

        if (wayToOrder == 2) {
            int[] aux = new int[array.length];
            aux[0] = array[1];
            aux[1] = array[2];
            aux[2] = array[0];

            return aux;
        } else if (wayToOrder == 3) {
            int[] aux = new int[array.length];
            aux[0] = array[1];
            aux[1] = array[2];
            aux[2] = array[0];

            return aux;
        }

        //in case wayToOrder == 1
        return array;
    }

}
