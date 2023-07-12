public class day16 {

    public static void main(String[] args) {

        System.out.println(NimGame(1));
        System.out.println(NimGame(2));
        System.out.println(NimGame(4));
        System.out.println(NimGame(17));
    }

    public static boolean NimGame(Integer stones) {

        if (stones % 4 == 0) {
            return false;
        }
        return true;
    }
}
