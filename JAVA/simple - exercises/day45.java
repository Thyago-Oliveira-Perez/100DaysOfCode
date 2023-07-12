public class day45 {

    public static void main(String[] args) {
        System.out.println(XOR(10, 41));
        System.out.println(XOR(69, 420));
        System.out.println(XOR(12345, 890412));
        System.out.println(XOR(2, 1));
    }

    public static int XOR (int x, int y) {

        /*
         * 1. x = x ^ y -> x = 15
         * 2. y = x ^ y -> y = 5
         * 3. x = x ^ y -> x = 10
         */
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        return x - y;
    }
}
