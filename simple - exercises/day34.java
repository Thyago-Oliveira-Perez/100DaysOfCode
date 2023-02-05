public class day34 {

    public static void main(String[] args) {

        System.out.println(CarryOperations(123, 456));
        System.out.println(CarryOperations(555, 555));
        System.out.println(CarryOperations(123, 594));
        System.out.println(CarryOperations(555, 545));
        System.out.println(CarryOperations(1, 20000));
        System.out.println(CarryOperations(1, 2));
    }

    public static int CarryOperations (int num, int num2) {

        char[] numArray = Integer.toString(num).toCharArray();
        char[] num2Array = Integer.toString(num2).toCharArray();

        int carryOperations = 0;

        char[] arrayAux = numArray.length < num2Array.length ? numArray : num2Array;

        for (int i = (arrayAux.length - 1) ; i >= 0  ; i--) {
            int sum = (Integer.parseInt(String.valueOf(num2Array[i])) + Integer.parseInt(String.valueOf(numArray[i])));
            if (sum >= 10) {
                if ((i-1) >= 0) {
                    num2Array[(i-1)] = Integer.toString(Integer.parseInt(String.valueOf(Integer.toString(sum).toCharArray()[0])) + Integer.parseInt(String.valueOf(num2Array[i]))).toCharArray()[0];
                }
                carryOperations++;
            }
        }


        return carryOperations;
    }
}
